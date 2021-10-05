package com.phucvh.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.phucvh.model.Employee;

public class PutWithExchangeExample {
	static final String URL_UPDATE_EMPLOYEE = "http://localhost:8080/employee";
	static final String URL_EMPLOYEE_PREFIX = "http://localhost:8080/employee";

	public static void main(String[] args) {

		String empNo = "E01";

		Employee updateInfo = new Employee(empNo, "Tom", "Cleck");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		RestTemplate restTemplate = new RestTemplate();

		// Dữ liệu đính kèm theo yêu cầu.
		HttpEntity<Employee> requestBody = new HttpEntity<>(updateInfo, headers);

		// Gửi yêu cầu với phương thức PUT.
		restTemplate.exchange(URL_UPDATE_EMPLOYEE, HttpMethod.PUT, requestBody, Void.class);

		String resourceUrl = URL_EMPLOYEE_PREFIX + "/" + empNo;

		Employee e = restTemplate.getForObject(resourceUrl, Employee.class);

		if (e != null) {
			System.out.println("(Client side) Employee after update: ");
			System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
		}
	}
}
