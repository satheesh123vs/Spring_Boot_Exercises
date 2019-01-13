package com.emp.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.app.model.Employee;
import com.emp.app.repo.EmployeeRepository;

/**
 * This is the Service class for Employee application
 * 
 * @author satheesh
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Employee save(Employee employee) {
		LOGGER.debug("Creating {}", employee);
		return repository.save(employee);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> getList() {
		LOGGER.debug("Retrieving the list of all users");
		return repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee fetchEmployeeDetailsById(Long employeeId) {
		if (null != employeeId) {
			return repository.findOne(employeeId);
		}
		return null;
	}

	@Override
	public void deleteAllInBatch() {
		try {
			repository.deleteAllInBatch();
			LOGGER.debug("deleting the all  employee records");
		} catch (Exception e) {
			LOGGER.debug("Exception in deleting the employee records" + e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteEmployeeDetailsById(Long employeeId) {
		if (null != employeeId) {
			repository.delete(employeeId);
		}
	}

}
