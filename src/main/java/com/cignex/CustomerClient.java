package com.cignex;

import org.springframework.web.client.RestTemplate;

import com.cignex.model.Customer;

public class CustomerClient {

	public static void main(String[] args) {
		String url="http://localhost:8080/customer/pinal";
		RestTemplate restTemplate=new RestTemplate();
		Customer entity=restTemplate.getForObject(url, Customer.class);
		System.out.println(entity.getAge());
	}
}
