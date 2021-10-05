package com.phucvh.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.phucvh.model.Employee;

public class Post_postForEntity_Example {
	static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";

	public static void main(String[] args) {

		Employee newEmployee = new Employee("E19", "Tom", "Cleck");

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee);

		// Gửi reques với phương thức POST.
		ResponseEntity<Employee> result = restTemplate.postForEntity(URL_CREATE_EMPLOYEE, requestBody, Employee.class);

		System.out.println("Status code:" + result.getStatusCode());

		// Code = 200.
		if (result.getStatusCode() == HttpStatus.OK) {
			Employee e = result.getBody();
			System.out.println("(Client Side) Employee Created: " + e.getEmpNo());
		}

	}
}
