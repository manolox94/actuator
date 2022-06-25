package com.actuator.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/myapp")
public class RestControl {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/rest")
	public List<Object> getCountries(){
		String url = "http://jsonplaceholder.typicode.com/posts";
		Object[] objects = restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(objects);
		
	}
}
