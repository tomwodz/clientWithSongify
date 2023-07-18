package pl.jjr.tomwodz.training.songifyclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jjr.tomwodz.training.songifyclient.model.SongAdd;
import pl.jjr.tomwodz.training.songifyclient.proxy.SongifyProxy;
import pl.jjr.tomwodz.training.songifyclient.proxy.response.SampleSongifyResponseDto;
import pl.jjr.tomwodz.training.songifyclient.proxy.response.SongifyAllSongsResponseDto;

@Service
public class SongifyService {

    @Autowired
    SongifyProxy songifyProxy;

    public SongifyService(SongifyProxy songifyProxy) {
        this.songifyProxy = songifyProxy;
    }

    public SampleSongifyResponseDto makeGetRequestById(Integer id){
            return songifyProxy.makeGetRequestById(id);
    }

    public SongifyAllSongsResponseDto makeGetRequestAll(){
        return  songifyProxy.makeGetRequestAll();
    }

    public SongifyAllSongsResponseDto makeGetRequestAllWithLimit(Integer id){
        return  songifyProxy.makeGetRequestAllWithLimit(id);
    }

    public void makeDeleteById(Integer id){
        songifyProxy.makeDeleteById(id);
    }

    public void makePostSampleSong(SongAdd song){
        songifyProxy.makePostSampleSong(song);
    }

    public void makePutUpdateSampleSongByIdInteger(Integer songId, SongAdd song){
    songifyProxy.makePutUpdateSampleSongById(songId, song);
    }

    public void makePatchUpdateSampleSongByIdInteger(Integer songId, SongAdd song){
        songifyProxy.makePatchUpdateSampleSongById(songId, song);
    }

}
