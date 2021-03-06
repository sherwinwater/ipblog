package com.simon.blog.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/includes/head").setViewName("includes/head");
		registry.addViewController("/includes/header").setViewName("includes/header");
		registry.addViewController("/includes/footer").setViewName("includes/footer");
		registry.addViewController("/includes/content").setViewName("includes/content");
		registry.addViewController("/includes/aside").setViewName("includes/aside");
		registry.addViewController("/login").setViewName("user/login");
	}

}
