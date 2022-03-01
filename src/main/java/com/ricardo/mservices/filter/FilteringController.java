package com.ricardo.mservices.filter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(value = "/filtering", produces = MediaType.APPLICATION_JSON_VALUE) // only send field1 and field2
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        return SomeBeanFilter.getFilteredBean(someBean, "field1", "field2");
    }

    @GetMapping(value = "/filtering-list", produces = MediaType.APPLICATION_JSON_VALUE) // only send field3
    public MappingJacksonValue retrieveSomeBeanList() {
        List<SomeBean> list = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));

        return SomeBeanFilter.getFilteredBeans(list, "field3");
    }
}
