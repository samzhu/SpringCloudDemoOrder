package com.sam.reader;

import com.sam.dto.Item;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by samchu on 2016/12/8.
 */
@FeignClient(name = "item-service",url = "${ItemReader.url}")
public interface ItemReader {

    @RequestMapping(method = RequestMethod.GET, value = "item/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Resource<Item> get(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "item", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    PagedResources<Resource<Item>> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "item/search/findByNameContaining", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    PagedResources<Resource<Item>> findByNameContaining(@RequestParam(value = "name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "item/search/findByPriceBetween", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    PagedResources<Resource<Item>> findByPriceBetween(@RequestParam(value = "minprice") Integer minprice, @RequestParam(value = "maxprice") Integer maxprice);


}
