package com.emp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmployeeApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

}
