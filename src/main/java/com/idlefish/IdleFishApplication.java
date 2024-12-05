package com.idlefish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.*;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.idlefish.controller")
public class IdleFishApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdleFishApplication.class, args);
	}

}
