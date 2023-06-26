package pl.jjr.tomwodz.training.itunes;

import java.util.List;

public record ItunesResponse(Integer resultCount, List<ItunesResult> results) {
}
