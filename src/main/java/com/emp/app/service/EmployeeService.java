package com.emp.app.service;

import java.util.List;

import com.emp.app.model.Employee;


public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getList();

}
