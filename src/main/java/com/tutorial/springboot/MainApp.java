package com.tutorial.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tutorial.springboot.controller.XMLController;

@EnableJpaRepositories
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class MainApp {

	final static Logger logger = LoggerFactory.getLogger(XMLController.class);

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

}
