package com.boraji.tutorial.springboot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;

import com.boraji.tutorial.springboot.model.CoffeeBean;

@Configuration
@EnableTransactionManagement
public class Config {
	final static Logger logger = LoggerFactory.getLogger(Config.class);


	public Config() throws IOException {
		Properties properties = new Properties();

		// Taking the property file in to a file obj.
		File file = ResourceUtils.getFile("classpath:application.properties");

		// create an input stream with the file obj.
		InputStream in = new FileInputStream(file);

		// loading the contents of properties file in to properties(java class)
		// as stream.
		properties.load(in);
	}

	@Bean
	public CoffeeBean getCoffeeBean() {
		return new CoffeeBean();
	}

}
