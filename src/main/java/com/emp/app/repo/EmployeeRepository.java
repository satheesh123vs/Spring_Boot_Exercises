package com.emp.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.app.model.Employee;
/**
 * This is the repo class for employee application.
 */

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
