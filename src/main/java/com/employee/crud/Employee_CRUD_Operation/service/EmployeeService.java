package com.employee.crud.Employee_CRUD_Operation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.crud.Employee_CRUD_Operation.entity.Employee;
import com.employee.crud.Employee_CRUD_Operation.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById(Long id) {
	    employeeRepository.deleteById(id);
	}
	
	 public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	 }
 
 
}
