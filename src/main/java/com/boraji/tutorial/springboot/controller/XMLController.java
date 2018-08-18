package com.boraji.tutorial.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.springboot.model.Coffee;
import com.boraji.tutorial.springboot.model.CoffeeBean;
import com.boraji.tutorial.springboot.service.CoffeeBeanServiceImpl;

/**
 * invoke the service using url:http://localhost:8080/coffee/{id}
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/coffee")
public class XMLController {

	@Autowired
	private CoffeeBeanServiceImpl coffeeBeanService;

	@Autowired
	private CoffeeBean coffeeBean;

	final Logger logger = LoggerFactory.getLogger(XMLController.class);

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public CoffeeBean getCoffeeInXML(@PathVariable long id) {

		try {
			coffeeBean = coffeeBeanService.getCoffeeBeanById(id);
			logger.info(coffeeBean.getName());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return coffeeBean;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public CoffeeBean saveCoffeeInXML(@RequestBody Coffee coffee) {
		
		try {
			if (null != coffee) {
				coffeeBean.setName(coffee.getName());
				coffeeBean.setQuantity(coffee.getQuantity());
				coffeeBean.setMsg(coffee.getMsg());
				coffeeBean = coffeeBeanService.create(coffeeBean);
				logger.info(coffeeBean.getName());
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return coffeeBean;

	}

}