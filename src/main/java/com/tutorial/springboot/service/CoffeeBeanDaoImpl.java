package com.tutorial.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

import org.hibernate.PessimisticLockException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.springboot.model.CoffeeBean;

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

	@SuppressWarnings("unchecked")
	public List<CoffeeBean> findByName(Class<CoffeeBean> class1, String name)
			throws IllegalStateException, PessimisticLockException,
			QueryTimeoutException, LockTimeoutException,
			TransactionRequiredException {
		List<CoffeeBean> listCoffeBean = null;

		Query query = entityManager.createNativeQuery(
				"select * from coffee_bean where name = :name",
				CoffeeBean.class);

		query.setParameter("name", name);
		listCoffeBean = (List<CoffeeBean>) query.getResultList();
		for (CoffeeBean a : listCoffeBean) {
			System.out.println("CoffeBean " + a.getName() + " "
					+ a.getQuantity());
		}
		return listCoffeBean;
	}
}