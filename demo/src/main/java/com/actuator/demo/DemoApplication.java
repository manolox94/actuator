package com.actuator.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("http://localhost:9000/hello-world", String.class);
		Object[] objects = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", Object[].class);
		List responsList = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", List.class);
//		List responsList9 = restTemplate.getForObject("http://localhost:9000/hello-world", List.class);

		
		Greeting post = restTemplate.getForObject("http://localhost:9000/hello-world", Greeting.class);
		
		
		System.out.println(response);
		System.out.println(objects.getClass());
		System.out.println(post.getContent());

//		System.out.println(responsList9.size());

	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
