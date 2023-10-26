package com.employee.crud.Employee_CRUD_Operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.crud.Employee_CRUD_Operation.entity.Employee;
import com.employee.crud.Employee_CRUD_Operation.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
 private EmployeeService employeeService;
 
	
	//get All Employee records
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//get Employee by id
	@GetMapping("/get/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	//save Employee record
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		
		Employee existingEmployee = employeeService.getEmployeeById(id);
		if(existingEmployee != null) {
			
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());
			
			return employeeService.saveEmployee(existingEmployee);

 		}
		return employeeService.saveEmployee(existingEmployee);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable Long id) {
		
	employeeService.deleteEmployeeById(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAllEmployees() {
		employeeService.deleteAllEmployees();
	}
}
