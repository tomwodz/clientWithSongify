package pl.jjr.tomwodz.training.songifyclient.proxy.response;



import pl.jjr.tomwodz.training.songifyclient.model.Song;

import java.util.Map;

public record SongifyAllSongsResponseDto(Map<Integer, Song> songs) {
}
