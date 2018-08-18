package com.boraji.tutorial.springboot.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.springboot.model.CoffeeBean;

@Repository
@Transactional(readOnly = false)
public class CoffeeBeanDaoImpl implements CoffeeBeanDao {

	@PersistenceContext
	private EntityManager entityManager;

	public CoffeeBean create(CoffeeBean coffeeBean)
			throws IllegalArgumentException, TransactionRequiredException {
		return entityManager.merge(coffeeBean);
	}

	public CoffeeBean find(Class<CoffeeBean> class1, long id)
			throws IllegalArgumentException {
		return entityManager.find(CoffeeBean.class, id);
	}
}