package com.ksimeo.givorost.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.ksimeo.givorost.admin.web.controllers", "com.ksimeo.givorost.api.services",
        "com.ksimeo.givorost.impl.services", "com.ksimeo.givorost.api.services", "com.ksimeo.givorost.admin.validators",
        "com.ksimeo.givorost.api.dao", "com.ksimeo.givorost.impl.dao" })
//@Import({ SecurityConfig.class })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        rb.setBasenames(new String[] { "messages/messages", "messages/validation" });
        return rb;
    }
}