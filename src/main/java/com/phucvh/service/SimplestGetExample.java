package com.phucvh.service;

import org.springframework.web.client.RestTemplate;

public class SimplestGetExample {

	static final String URL_EMPLOYEES = "http://localhost:8080/employees";

	static final String URL_EMPLOYEES_XML = "http://localhost:8080/employees.xml";
	static final String URL_EMPLOYEES_JSON = "http://localhost:8080/employees.json";

	public static void main(String[] args) {

		try {
			
			RestTemplate restTemplate = new RestTemplate();

			String result = restTemplate.getForObject(URL_EMPLOYEES, String.class);

			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
