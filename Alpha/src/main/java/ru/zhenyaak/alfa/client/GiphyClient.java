package ru.zhenyaak.alfa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.zhenyaak.alfa.entity.Giphy;

@FeignClient(url = "${giphy.url}", name = "GIPHY-CLIENT")
public interface GiphyClient {

    @GetMapping("random?api_key={api_key}&tag={tag}&rating={rating}")
    public Giphy getGiphy(@PathVariable("api_key") String api_key,
			    		  @PathVariable("tag") String tag,
			    		  @PathVariable("rating") String rating);
}
