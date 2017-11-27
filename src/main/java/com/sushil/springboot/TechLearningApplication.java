package com.sushil.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author sushilkhera
 *
 */
@SpringBootApplication(scanBasePackages= {"com.sushil.springboot",
		"com.sushil.springboot.controller",
		"com.sushil.springboot.config",
		"com.sushil.springboot.service",
		"com.sushil.springboot.service.impl",
		"com.sushil.springboot.repo"
})
public class TechLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechLearningApplication.class, args);
		System.out.println("Inside main method");
	}
}
