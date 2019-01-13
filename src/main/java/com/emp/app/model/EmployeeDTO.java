package com.emp.app.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class EmployeeDTO {

	private Long employeeId;

	private String employeeName;
	
	private String department;

	private String designation;
	
	private Double salary;

	public Long getEmployeeId() {
		return employeeId;
	}
	@XmlElement
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	@XmlElement
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}
	@XmlElement
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}
	@XmlElement
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String getDepartment() {
		return department;
	}
	@XmlElement
	public void setDepartment(String department) {
		this.department = department;
	}
}
