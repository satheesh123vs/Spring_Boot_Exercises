package com.emp.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emp.app.constants.EmployeeConstants;
import com.emp.app.constants.EmployeeConstants.SEVERITY;
import com.emp.app.model.Employee;
import com.emp.app.model.EmployeeDTO;
import com.emp.app.model.ErrorTextVo;
import com.emp.app.response.EmployeeResponse;
import com.emp.app.service.EmployeeService;

/**
 * Controller class for Employee application
 * 
 * @author satheesh
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	List<ErrorTextVo> errors = new ArrayList<ErrorTextVo>();

	final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	EmployeeResponse employeeResponse = null;

	EmployeeDTO employeeRequest = null;

	Employee employee = null;

	ModelMapper modelMapper = new ModelMapper();

	ResourceBundle boundle = ResourceBundle.getBundle("EmployeeProperties");

	/**
	 * This method is the Rest WS endpoint to fetch all Employee details.
	 * returns the employee details in response.
	 * 
	 * @param employeeRequest
	 * @return employeeResponse
	 */
	@RequestMapping(value = "/fetchAll", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public EmployeeResponse listEmployees() {
		employeeResponse = new EmployeeResponse();
		List<Employee> employees = null;
		try {
			employees = employeeService.getList();
		} catch (Exception e) {
			logger.error(e.getMessage());
			buildException(e.getMessage(), SEVERITY.ERROR);
		}
		// Mapping employee record fetched from db to employee response object.
		List<EmployeeDTO> employeeList = employees.stream()
				.map(employee -> convertToDto(employee))
				.collect(Collectors.toList());
		employeeResponse.setEmployeeList(employeeList);
		return employeeResponse;
	}

	/**
	 * This method is the Rest WS endpoint to fetch Employee details using the
	 * id of employee. returns the employee details in response.
	 * 
	 * @param employeeRequest
	 * @return employeeResponse
	 */
	@RequestMapping(value = "{employeeId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public EmployeeResponse fetchEmployeeDetailsById(
			@PathVariable Long employeeId) {
		employeeResponse = new EmployeeResponse();
		if (employeeId == null) {
			String nullInputMessage = boundle
					.getString(EmployeeConstants.EMPLOYEE_VALIDATION_NULL_INPUT);
			logger.error(nullInputMessage);
			buildException(nullInputMessage, SEVERITY.DEBUGG);
		} else {
			try {
				employee = employeeService.fetchEmployeeDetailsById(employeeId);
				logger.info(employee.getEmployeeName());
			} catch (Exception e) {
				logger.error(e.getMessage());
				buildException(e.getMessage(), SEVERITY.ERROR);
			}
			if (null != employee) {
				EmployeeDTO employeeResponseObj = modelMapper.map(employee,
						EmployeeDTO.class);
				employeeResponse.getEmployeeList().add(employeeResponseObj);
			}
		}
		return employeeResponse;
	}

	/**
	 * This method is the Rest WS endpoint to save Employee details. returns the
	 * saved employee details in response.
	 * 
	 * @param employeeRequest
	 * @return employeeResponse
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeResponse saveEmployee(
			@RequestBody EmployeeDTO employeeRequest) {
		employeeResponse = new EmployeeResponse();
		Employee employee = null;
		modelMapper = new ModelMapper();
		if (employeeRequest == null) {
			String nullInputMessage = boundle
					.getString(EmployeeConstants.EMPLOYEE_VALIDATION_NULL_INPUT);
			logger.error(nullInputMessage);
			buildException(nullInputMessage, SEVERITY.DEBUGG);
		} else {
			employee = modelMapper.map(employeeRequest, Employee.class);
			try {
				employee = employeeService.save(employee);
			} catch (Exception e) {
				logger.error(e.getMessage());
				buildException(e.getMessage(), SEVERITY.ERROR);
			}
			if (null != employee) {
				employeeRequest = modelMapper.map(employeeRequest,
						EmployeeDTO.class);
				employeeResponse.getEmployeeList().add(employeeRequest);
			}
		}
		return employeeResponse;
	}

	/**
	 * This method is the Rest WS endpoint to delete all Employee details.
	 * 
	 */
	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void list1Employees() {
		employeeResponse = new EmployeeResponse();
		try {
			employeeService.deleteAllInBatch();
		} catch (Exception e) {
			logger.error(e.getMessage());
			buildException(e.getMessage(), SEVERITY.ERROR);
		}
	}

	/**
	 * This method is the Rest WS endpoint to fetch Employee details using the
	 * id of employee. returns the employee details in response.
	 * 
	 * @param employeeRequest
	 * @return employeeResponse
	 */
	@RequestMapping(value = "{employeeId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public EmployeeResponse deleteEmployeeDetailsById(
			@PathVariable Long employeeId) {
		employeeResponse = new EmployeeResponse();
		if (employeeId == null) {
			String nullInputMessage = boundle
					.getString(EmployeeConstants.EMPLOYEE_VALIDATION_NULL_INPUT);
			logger.error(nullInputMessage);
			buildException(nullInputMessage, SEVERITY.DEBUGG);
		} else {
			try {
				employeeService.deleteEmployeeDetailsById(employeeId);
			} catch (Exception e) {
				logger.error(e.getMessage());
				buildException(e.getMessage(), SEVERITY.ERROR);
			}
			if (null != employee) {
				EmployeeDTO employeeResponseObj = modelMapper.map(employee,
						EmployeeDTO.class);
				employeeResponse.getEmployeeList().add(employeeResponseObj);
			}
		}
		return employeeResponse;
	}

	/**
	 * mapping employee record to employee response object.
	 * 
	 * @param employee2
	 * @return employeeRequest
	 */
	private EmployeeDTO convertToDto(Employee employee2) {
		employeeRequest = new EmployeeDTO();
		employeeRequest = modelMapper.map(employee2, EmployeeDTO.class);
		return employeeRequest;
	}

	/**
	 * building Exception
	 * 
	 * @param error
	 * 
	 * @param exception
	 * @return response with exception.
	 */

	private EmployeeResponse buildException(String exceptionMessage,
			SEVERITY error) {
		employeeResponse = new EmployeeResponse();
		errors = new ArrayList<ErrorTextVo>();
		errors.add(new ErrorTextVo(null, exceptionMessage, error.toString()));
		employeeResponse.setErrors(errors);
		return employeeResponse;
	}
}
