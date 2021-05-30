package com.ricardo.mservices.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorld helloWorldBean() {
        return new HelloWorld("Hello World!");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorld helloWorldPath(@PathVariable(name = "name") String name) {
        return new HelloWorld(String.format("Hello World: %s", name));
    }

    @GetMapping(path = "/hello-world-i18n")
    public String helloWorldInternationalized() {
        return messageSource.getMessage(
                "good.morning.message",
                null,
                "Default message",
                LocaleContextHolder.getLocale()
        );
    }
}
