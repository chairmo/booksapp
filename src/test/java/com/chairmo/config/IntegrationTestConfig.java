package com.chairmo.config;

import com.chairmo.BooksappApplication;
import com.chairmo.dump.SpringJPABootstrap;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type =
        FilterType.ASSIGNABLE_TYPE, value = SpringJPABootstrap.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BooksappApplication.class)},
        basePackages = {"com.chairmo.service"})
public class IntegrationTestConfig {
}
