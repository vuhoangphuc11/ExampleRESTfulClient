package com.phucvh.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.phucvh.model.Employee;

public class postForObject {
	
	static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";
	
	public static void main(String[] args) {
		
		Employee employee = new Employee("E20","Phuc","Cleck");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
		headers.setContentType(MediaType.APPLICATION_XML);
		
		RestTemplate restTemplate = new RestTemplate();  
		
		HttpEntity<Employee> requestBody = new HttpEntity<>(employee, headers);
		
		//Employee e = restTemplate.postForObject(URL_CREATE_EMPLOYEE, requestBody, Employee.class);
		
		ResponseEntity<Employee> e = restTemplate.exchange(URL_CREATE_EMPLOYEE, HttpMethod.POST, requestBody, Employee.class);

		if(e.getStatusCode() != HttpStatus.OK) {
			System.out.println("Khong thanh cong");
		}else {
			System.out.println("Employee: "+ e.getBody().getEmpName());
		}
		
		}
	
}
