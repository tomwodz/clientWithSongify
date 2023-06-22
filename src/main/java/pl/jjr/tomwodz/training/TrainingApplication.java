package pl.jjr.tomwodz.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
public class TrainingApplication {

    @Autowired
    ShawnMendesProxy shawnMendesClinet;

    @Autowired
    InformationAboutBooksProxy informationAboutBooksProxy;
    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToShawnMendesEndpoint(){
        String response = shawnMendesClinet.makeSearchRequest("shawnmendes", 1);
        System.out.println(response);
    }

}
