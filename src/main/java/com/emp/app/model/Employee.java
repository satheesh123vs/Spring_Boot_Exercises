package com.emp.app.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {
	
	/**
	 * Id:Specifies the primary key of an entity. 
	 * GeneratedValue:Provides for the specification of generation strategies for the values of primary keys. 
	 * strategy:The primary key generation strategy that the persistence provider must use to generate the annotated entity primary key.
	 * GenerationType:Defines the types of primary key generation strategies.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	@NotNull
	@Size(max = 64)
	@Column(name = "name", nullable = false)
	private String employeeName;
	
	@NotNull
	@Size(max = 64)
	@Column(name = "department", nullable = false)
	private String department;

	@NotNull
	@Size(max = 64)
	@Column(name = "designation", nullable = false)
	private String designation;

	private Double salary;

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", employeeId)
				.add("name", employeeName).add(department, department)
				.add(designation, designation).add("salary", salary).toString();
	}
}
