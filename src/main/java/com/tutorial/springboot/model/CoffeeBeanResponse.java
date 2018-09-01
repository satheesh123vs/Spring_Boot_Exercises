package com.tutorial.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tutorial.springboot.service.ErrorTextVo;

@XmlRootElement(name = "coffeeBeanResponse")
public class CoffeeBeanResponse {

	private List<Coffee> coffeeBeanList = new ArrayList<Coffee>();
	List<ErrorTextVo> validationErrors = null;

	public List<Coffee> getCoffeeBeanList() {
		return coffeeBeanList;
	}

	@XmlElement(name = "coffeeBean")
	public void setCoffeeBeanList(List<Coffee> coffeeBeanList) {
		this.coffeeBeanList = coffeeBeanList;
	}

	public List<ErrorTextVo> getValidationErrors() {
		return validationErrors;
	}

	@XmlElement(name = "Errors")
	public void setValidationErrors(List<ErrorTextVo> validationErrors) {
		this.validationErrors = validationErrors;
	}
}