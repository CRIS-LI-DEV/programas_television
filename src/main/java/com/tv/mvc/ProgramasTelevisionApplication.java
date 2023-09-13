package com.tv.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProgramasTelevisionApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProgramasTelevisionApplication.class);
    }
 
    public static void main(String[] args) {
        SpringApplication.run(ProgramasTelevisionApplication.class, args);
    }
}