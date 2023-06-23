package pl.jjr.tomwodz.training;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Decoder feignDecoder(){
        return new JacksonDecoder();
    }
}
