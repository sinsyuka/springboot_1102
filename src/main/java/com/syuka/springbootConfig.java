package com.syuka;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.syuka.mapper")
@ComponentScan(basePackages = {"com.syuka.controller"})
public class springbootConfig {
}
