package com.mrkj.ygl.config;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.mrkj.ygl.*.**"}, excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
//@EnableTransactionManagement
@ImportResource(value = {"classpath:/spring-transaction.xml", "classpath:/spring-pz-shiro.xml"})
public class RootConfig {

    @Resource(name = "dataSourceDDS")
    DataSource dataSource;


    @Bean
    public JdbcTemplate jdbcTemplate() {

        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "simpleDateFormat")
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

}
