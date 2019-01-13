package com.emp.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.emp.app.model.Employee;

/**
 * @author satheesh
 *
 */
@Component
public interface EmployeeService {

	/**
	 * Mehothod to save employee details
	 * 
	 * @param employee
	 * @return employee
	 */
	Employee save(Employee employee);

	/**
	 * Mehothod to delete all employee details
	 * 
	 */
	void deleteAllInBatch();

	/**
	 * Mehothod to fetch all employee details
	 * 
	 * @return employee
	 */
	List<Employee> getList();

	/**
	 * Method to fetch employee details using employee Id Retrieves an entity by
	 * its id.
	 * 
	 * 
	 * @return employee
	 */
	Employee fetchEmployeeDetailsById(Long employeeId);

	/**
	 * Method to delete employee details using employee Id Retrieves an entity
	 * by its id.
	 * 
	 */
	void deleteEmployeeDetailsById(Long employeeId);

}
