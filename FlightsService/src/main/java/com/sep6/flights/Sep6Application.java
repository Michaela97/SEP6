package com.sep6.flights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Sep6Application {

	public static WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("https://flights-service-buki55n7ba-lz.a.run.app");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Sep6Application.class, args);
		corsConfigurer();
	}

}
