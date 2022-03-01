package com.ricardo.mservices.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.util.List;

public class SomeBeanFilter {

    public static MappingJacksonValue getFilteredBeans(List<SomeBean> instances, String... fields) {
        return doFilter(instances, fields);
    }

    public static MappingJacksonValue getFilteredBean(SomeBean instance, String... fields) {
        return doFilter(instance, fields);
    }

    private static MappingJacksonValue doFilter(Object value, String... fields) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(value);
        mapping.setFilters(filters);
        return mapping;
    }
}
