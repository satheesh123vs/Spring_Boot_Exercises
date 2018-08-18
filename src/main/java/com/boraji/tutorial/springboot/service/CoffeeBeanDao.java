package com.boraji.tutorial.springboot.service;

import javax.persistence.TransactionRequiredException;

import com.boraji.tutorial.springboot.model.CoffeeBean;

public interface CoffeeBeanDao {
	CoffeeBean create(CoffeeBean coffeeBean) throws IllegalArgumentException,
			TransactionRequiredException;

	CoffeeBean find(Class<CoffeeBean> class1, long id)
			throws IllegalArgumentException;
}
