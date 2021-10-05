package com.phucvh.service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetWithHeaderExample {

	static final String URL_EMPLOYEES = "http://localhost:8080/employees";

	public static void main(String[] args) {

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON}));

		// Yêu cầu trả về định dạng JSON
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("my_other_key", "my_other_value");

		// HttpEntity<String>: To get result as String.
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();

		// Gửi yêu cầu với phương thức GET, và các thông tin Headers.
		ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, HttpMethod.GET, entity, String.class);

		String result = response.getBody();

		System.out.println(result);
	}

}
