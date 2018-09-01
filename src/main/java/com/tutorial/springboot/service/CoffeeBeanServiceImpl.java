package com.tutorial.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.springboot.model.Coffee;
import com.tutorial.springboot.model.CoffeeBean;
import com.tutorial.springboot.model.CoffeeBeanResponse;
import com.tutorial.springboot.service.CoffeeBeanConstants.SEVERITY;

@Service
public class CoffeeBeanServiceImpl {

	@Autowired
	private CoffeeBeanDao coffeeBeanDao;

	public CoffeeBean create(CoffeeBean coffeeBean)
			throws IllegalArgumentException, TransactionRequiredException {
		return coffeeBeanDao.create(coffeeBean);
	}

	public CoffeeBean getCoffeeBeanById(long id)
			throws IllegalArgumentException {
		return coffeeBeanDao.find(CoffeeBean.class, id);
	}

	public CoffeeBeanResponse getCoffeeBeanByName(String name)
			throws IllegalArgumentException {

		// Locale locale = Locale.getDefault();
		ResourceBundle boundle = ResourceBundle
				.getBundle("CoffeeBeanProperties");

		CoffeeBeanResponse coffeeBeanResponse = new CoffeeBeanResponse();
		List<ErrorTextVo> validationErrors = new ArrayList<ErrorTextVo>();
		List<CoffeeBean> listCoffeBean = null;
		List<Coffee> listCoffe = new ArrayList<Coffee>();
		Coffee coffee = null;
		if (name != null) {

			listCoffeBean = coffeeBeanDao.findByName(CoffeeBean.class, name);

			for (CoffeeBean coffeeBean : listCoffeBean) {
				coffee = new Coffee();
				coffee.setId(coffeeBean.getId());
				coffee.setMsg(coffeeBean.getMsg());
				coffee.setName(coffeeBean.getName());
				coffee.setQuantity(coffeeBean.getQuantity());
				listCoffe.add(coffee);
			}
			coffeeBeanResponse.setCoffeeBeanList(listCoffe);
		} else {
			validationErrors
					.add(new ErrorTextVo(
							null,
							boundle.getString(CoffeeBeanConstants.COFFE_BEAN_VALIDATION_NULL_INPUT),
							SEVERITY.INFO.toString()));
			coffeeBeanResponse.setValidationErrors(validationErrors);
		}
		return coffeeBeanResponse;
	}

}
