package pl.jjr.tomwodz.training;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "shawnmendes-client", url="https://itunes.apple.com")

public interface ShawnMendesProxy {

    @GetMapping(value = "/search")
    String makeSearchRequest(
            @RequestParam("term") String term,
            @RequestParam("limit") Integer limit
    );
}
