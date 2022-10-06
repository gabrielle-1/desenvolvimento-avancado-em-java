package com.devsuperior.demolazy.entities;

import com.devsuperior.demolazy.dto.EmployeeDTO;
import com.devsuperior.demolazy.util.Convertible;

import javax.persistence.*;

@Entity
@Table(name = "tb_employee")
public class Employee implements Convertible<EmployeeDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public Employee() {
	}

	public Employee(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public EmployeeDTO convert() {
		return new EmployeeDTO(this);
	}
}
