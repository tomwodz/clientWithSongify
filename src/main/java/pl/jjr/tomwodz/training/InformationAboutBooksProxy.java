package pl.jjr.tomwodz.training;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="informationaboutbooks-clinet", url="http://openlibrary.org")
public interface InformationAboutBooksProxy {

    @GetMapping(path = "api/volumes/brief/isbn")
        String makeSearchBook(
                @RequestParam() String isbn);
}
