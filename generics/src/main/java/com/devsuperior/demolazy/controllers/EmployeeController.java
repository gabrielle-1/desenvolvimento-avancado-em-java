package com.devsuperior.demolazy.controllers;

import com.devsuperior.demolazy.entities.Employee;
import com.devsuperior.demolazy.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.demolazy.dto.EmployeeDTO;
import com.devsuperior.demolazy.services.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
		EmployeeDTO obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll(){
		List<EmployeeDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
