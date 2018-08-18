package com.boraji.tutorial.springboot.service;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boraji.tutorial.springboot.model.CoffeeBean;

@Service
public class CoffeeBeanServiceImpl {

	@Autowired
	private CoffeeBeanDao coffeeBeanDao;

	public CoffeeBean create(CoffeeBean coffeeBean) throws IllegalArgumentException, TransactionRequiredException {
		return coffeeBeanDao.create(coffeeBean);
	}

	public CoffeeBean getCoffeeBeanById(long id) throws IllegalArgumentException {
		return coffeeBeanDao.find(CoffeeBean.class, id);
	}

}
