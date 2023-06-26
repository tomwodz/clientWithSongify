package pl.jjr.tomwodz.training.sampleshawnmendesserver;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import pl.jjr.tomwodz.training.itunes.ItunesResponse;

@FeignClient(value = "sample-server-shawn-mendes-client")

public interface SampleShawnMendesServerProxy {

    //GET http://localhost:8080/shawn/songs
    @GetMapping(value = "/shawn/songs")
   SampleServerShawnMendesResponse fetchAllSongs(@RequestHeader String requestId);

    @PostMapping(value = "/shawn/songs")
    SampleServerShawnMendesResponse addSong(@RequestBody SampleShawnMendesRequest request);
}
