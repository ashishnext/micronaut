package taskmanager.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

    @Get("/")
    public String index(){
        System.out.println("=Hello======");
        return "Hello";
    }
}
