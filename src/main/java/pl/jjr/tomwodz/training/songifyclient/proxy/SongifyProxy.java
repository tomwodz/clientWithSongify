package pl.jjr.tomwodz.training.songifyclient.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.jjr.tomwodz.training.songifyclient.model.SongAdd;
import pl.jjr.tomwodz.training.songifyclient.proxy.response.SampleSongifyResponseDto;
import pl.jjr.tomwodz.training.songifyclient.proxy.response.SongifyAllSongsResponseDto;

import java.util.Map;

@FeignClient(value = "songify-client")
@Component
public interface SongifyProxy {

    @GetMapping(value = "/songs/{id}")
    SampleSongifyResponseDto makeGetRequestById(@PathVariable Integer id);

    @GetMapping(value = "/songs")
    SongifyAllSongsResponseDto makeGetRequestAll();

    @GetMapping(value = "/songs")
    SongifyAllSongsResponseDto makeGetRequestAllWithLimit(@RequestParam(required = false) Integer limit);

    @DeleteMapping(value = "/songs/{songId}")
    void makeDeleteById(@PathVariable Integer songId);

    @PostMapping(value = "/songs")
    void makePostSampleSong(@RequestBody SongAdd song);

    @PutMapping(value = "/songs/{songId}")
    void makePutUpdateSampleSongById(@PathVariable Integer songId, @RequestBody SongAdd song);
    @PatchMapping(value = "/songs/{songId}")
    void makePatchUpdateSampleSongById(@PathVariable Integer songId, @RequestBody SongAdd song);

}
