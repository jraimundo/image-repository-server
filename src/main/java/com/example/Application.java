package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public ServletRegistrationBean jerseyServlet() {
//		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
//		// our rest resources will be available in the path /rest/*
//		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
//		return registration;
//	}
}
