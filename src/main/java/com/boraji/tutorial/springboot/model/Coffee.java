package com.boraji.tutorial.springboot.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coffee")
public class Coffee {

	private Long id;
	String name;
	Integer quantity;
	String msg;

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	@XmlElement
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getMsg() {
		return msg;
	}

	@XmlElement
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Coffee(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public Coffee() {
		super();
	}

}