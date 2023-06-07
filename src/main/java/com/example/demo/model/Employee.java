package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.Column;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name="department")
	private String department;
	
	@Column(name="salary")
	private String salary;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="dob")
	private String dob;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Employee(long id, String name, String department, String salary, String gender, String dob) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.gender = gender;
		this.dob = dob;
	}

	public Employee() {
		super();
		
	}
	
	
}
	
	