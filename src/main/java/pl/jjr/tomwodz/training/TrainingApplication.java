package pl.jjr.tomwodz.training;

import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class TrainingApplication {

    @Autowired
    ShawnMendesProxy shawnMendesClient;

   // Logger log = getLogger(TrainingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToShawnMendesEndpoint() {
        try {
            ShawnMendesResponse response = shawnMendesClient.makeSearchRequest("shawnmendes", 5);
            List<ShawnMendesResult> results = response.results();
            results.forEach(
                    shawnMendesResult -> System.out.println(shawnMendesResult.trackName())
            );
        } catch (FeignException.FeignClientException feignException) {
            log.error("Client exception: " + feignException.status());
            log.info("Client exception: " + feignException.status());
            log.warn("Client exception: " + feignException.status());
        } catch (FeignException.FeignServerException feignException) {
            System.out.println("Server exception: " + feignException.status());
        } catch (RetryableException retryableException) {
            System.out.println("Retryable exception: " + retryableException.getMessage());
        } catch (FeignException feignException) {
            System.out.println(feignException.getMessage() + " " + feignException.status());
        }
    }

}
