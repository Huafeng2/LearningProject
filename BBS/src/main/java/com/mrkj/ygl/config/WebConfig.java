package com.mrkj.ygl.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

/**
 * 通过javaConfig方式配置SpringMVC
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.mrkj.ygl.*.**"})
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = Logger.getLogger(WebConfig.class);

    @Bean
    public ViewResolver viewresolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        logger.info("ViewResolver end.");
        return resolver;
    }

    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
        cmr.setUploadTempDir(new FileSystemResource("/tmp/file"));
        cmr.setMaxUploadSize(1048576);
        cmr.setMaxInMemorySize(0);
        return cmr;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJacksonHttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Bean
    public JacksonAnnotationIntrospector jacksonAnnotationIntrospector() {
        return new JacksonAnnotationIntrospector();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setAnnotationIntrospector(jacksonAnnotationIntrospector());
        return mapper;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter amga = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> ls = new ArrayList<HttpMessageConverter<?>>();
        ls.add(mappingJacksonHttpMessageConverter());
        amga.setMessageConverters(ls);
        return amga;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(objectMapper());
        return messageConverter;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // TODO Auto-generated method stub
        configurer.enable();
    }

    @Autowired
    DefaultWebSecurityManager securityManager;

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();

        aasa.setSecurityManager(securityManager);

        return aasa;
    }

}
