package pl.jjr.tomwodz.training.songifyclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongAdd {
    String songName;
    String artist;
}
