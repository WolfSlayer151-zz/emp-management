package com.employee.controller;

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

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAll()
	{
		return ResponseEntity.ok(employeeservice.findAll());
	}
	
	@GetMapping("/{id}") //C0m3@Sept3mb3r
	public ResponseEntity<Employee> findById(@PathVariable Long id)
	{
		return ResponseEntity.ok(employeeservice.findById(id).orElse(null));
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addAll(@RequestBody Employee emp)
	{
		return ResponseEntity.ok(employeeservice.save(emp));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody Employee employee)
	{
		return ResponseEntity.ok(employeeservice.save(employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> delete(@PathVariable Long id)
	{
		employeeservice.findById(id).ifPresent(employeeservice::delete);
		return ResponseEntity.ok().build();
	}

}
