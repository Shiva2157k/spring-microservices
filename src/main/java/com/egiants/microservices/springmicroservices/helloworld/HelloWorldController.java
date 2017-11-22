package com.egiants.microservices.springmicroservices.helloworld;

import com.egiants.microservices.springmicroservices.helloworld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String sayHello(){
        return "Hello World..!!!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean sayHelloBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean sayHelloPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }

    @GetMapping(path = "/i")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required =false)Locale locale) {
        return messageSource.getMessage("good.morning.message",null, locale);
    }
}
