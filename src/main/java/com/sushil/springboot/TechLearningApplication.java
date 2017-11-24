package com.sushil.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.sushil.springboot","com.sushil.springboot.controller"})
public class TechLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechLearningApplication.class, args);
		System.out.println("Inside main method");
	}
}
