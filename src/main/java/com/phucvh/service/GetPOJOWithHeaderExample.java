package com.phucvh.service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.phucvh.model.Employee;

public class GetPOJOWithHeaderExample {
	static final String URL_EMPLOYEES = "http://localhost:8080/employees";

	public static void main(String[] args) {

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
		// yêu cầu trả về định dạng XML
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.set("my_other_key", "my_other_value");

		HttpEntity<Employee[]> entity = new HttpEntity<Employee[]>(headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Employee[]> response = restTemplate.exchange(URL_EMPLOYEES, HttpMethod.GET, entity,
				Employee[].class);
		HttpStatus statusCode = response.getStatusCode();
		System.out.println("Response Status Code: " + statusCode);

		if (statusCode == HttpStatus.OK) {
			Employee[] list = response.getBody();

			if (list != null) {
				for (Employee e : list) {
					System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
				}
			}

		}
	}
}
