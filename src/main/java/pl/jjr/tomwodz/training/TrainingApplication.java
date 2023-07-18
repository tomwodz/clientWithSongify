package pl.jjr.tomwodz.training;
import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import pl.jjr.tomwodz.training.songifyclient.model.SongAdd;
import pl.jjr.tomwodz.training.songifyclient.service.SongifyService;


@SpringBootApplication
@EnableFeignClients
@Log4j2
public class TrainingApplication {


   @Autowired
    SongifyService songifyService;

    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        try {
            log.info(songifyService.makeGetRequestById(1));
            log.info(songifyService.makeGetRequestAllWithLimit(2));
            log.info(songifyService.makeGetRequestAll());
            songifyService.makePostSampleSong(new SongAdd("Nowa piosenka 1","Tomek"));
            songifyService.makePostSampleSong(new SongAdd("Nowa piosenka 2","Adam"));
            log.info(songifyService.makeGetRequestAll());
            songifyService.makePutUpdateSampleSongByIdInteger(2, new SongAdd("Update","Update"));
            //songifyService.makeDeleteById(3);
            log.info(songifyService.makeGetRequestAll());
            songifyService.makePatchUpdateSampleSongByIdInteger(1, new SongAdd("Nowa","Update"));
            log.info(songifyService.makeGetRequestAll());

        } catch (FeignException.FeignClientException feignException) {
            log.error("Client exception: " + feignException.status());
        } catch (FeignException.FeignServerException feignException) {
            System.out.println("Server exception: " + feignException.status());
        } catch (RetryableException retryableException) {
            System.out.println("Retryable exception: " + retryableException.getMessage());
        } catch (FeignException feignException) {
            System.out.println(feignException.getMessage() + " " + feignException.status());
        }
    }

}
