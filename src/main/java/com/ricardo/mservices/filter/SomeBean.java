package com.ricardo.mservices.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(value={"field1", "field2"})
public class SomeBean {

    @JsonIgnore
    private String field1;

    @JsonIgnore
    private String field2;

    private String field3;

    public SomeBean(String f1, String f2, String f3) {
        this.field1 = f1;
        this.field2 = f2;
        this.field3 = f3;
    }
}
