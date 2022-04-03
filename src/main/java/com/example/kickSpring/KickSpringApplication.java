package com.example.kickSpring;

import com.example.kickSpring.filter.auth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KickSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(KickSpringApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<auth> filterRegistrationBean(){
		FilterRegistrationBean<auth> registrationBean = new FilterRegistrationBean<>();
		auth authfilter = new auth();
		registrationBean.setFilter(authfilter);
		registrationBean.addUrlPatterns("/api/db/*");
		return registrationBean;
	}
}
