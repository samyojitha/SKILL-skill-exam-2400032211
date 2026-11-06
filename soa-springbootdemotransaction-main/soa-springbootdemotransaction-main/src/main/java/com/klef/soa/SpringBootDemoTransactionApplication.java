package com.klef.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoTransactionApplication.class, args);
		System.out.println("Demo Transaction is Running...!!!");
	}

}
