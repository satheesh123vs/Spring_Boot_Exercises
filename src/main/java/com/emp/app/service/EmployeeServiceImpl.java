package com.emp.app.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.app.model.Employee;
import com.emp.app.repo.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository repository;

    @Inject
    public EmployeeServiceImpl(final EmployeeRepository repository) {
        this.repository = repository;
    }

   
    @Transactional
    public Employee save(Employee employee) {
        LOGGER.debug("Creating {}", employee);
        return repository.save(employee);
    }

  
    @Transactional(readOnly = true)
    public List<Employee> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return repository.findAll();
    }

}
