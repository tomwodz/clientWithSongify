package pl.jjr.tomwodz.training.sampleshawnmendesserver;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jjr.tomwodz.training.itunes.ItunesResponse;

@FeignClient(value = "sample-server-shawn-mendes-client")

public interface SampleShawnMendesServerProxy {

    //GET http://localhost:8080/shawn/songs
    @GetMapping(value = "/shawn/songs")
   SampleServerShawnMendesResponse fetchAllSongs(@RequestHeader String requestId);
}
