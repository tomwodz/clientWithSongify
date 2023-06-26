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
import pl.jjr.tomwodz.training.itunes.ItunesProxy;
import pl.jjr.tomwodz.training.itunes.ItunesResponse;
import pl.jjr.tomwodz.training.itunes.ItunesResult;
import pl.jjr.tomwodz.training.sampleshawnmendesserver.SampleServerShawnMendesResponse;
import pl.jjr.tomwodz.training.sampleshawnmendesserver.SampleShawnMendesServerProxy;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class TrainingApplication {

    @Autowired
    ItunesProxy itunesClient;

    @Autowired
    SampleShawnMendesServerProxy sampleShawnMendesServerClinet;

   // Logger log = getLogger(TrainingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        try {
//            ItunesResponse response = itunesClient.makeSearchRequest("shawnmendes", 5);
            SampleServerShawnMendesResponse response = sampleShawnMendesServerClinet.fetchAllSongs("id1");
            log.info(response);
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
