package com.tutorial.springboot.service;

import java.util.List;

import javax.persistence.TransactionRequiredException;

import com.tutorial.springboot.model.CoffeeBean;

public interface CoffeeBeanDao {
	CoffeeBean create(CoffeeBean coffeeBean) throws IllegalArgumentException,
			TransactionRequiredException;

	CoffeeBean find(Class<CoffeeBean> class1, long id)
			throws IllegalArgumentException;

	List<CoffeeBean> findByName(Class<CoffeeBean> class1, String name) 
			throws IllegalArgumentException;;
}
