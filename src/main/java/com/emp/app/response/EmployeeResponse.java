package com.emp.app.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.emp.app.model.EmployeeDTO;
import com.emp.app.model.ErrorTextVo;

@XmlRootElement(name = "employeeResponse")
public class EmployeeResponse {

	private List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
	List<ErrorTextVo> errors = null;

	public List<EmployeeDTO> getEmployeeList() {
		return employeeList;
	}

	@XmlElement(name = "employee")
	public void setEmployeeList(List<EmployeeDTO> employeeList) {
		this.employeeList = employeeList;
	}

	public List<ErrorTextVo> getErrors() {
		return errors;
	}

	@XmlElement(name = "Errors")
	public void setErrors(List<ErrorTextVo> errors) {
		this.errors = errors;
	}
}