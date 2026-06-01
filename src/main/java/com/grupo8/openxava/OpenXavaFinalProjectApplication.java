package com.grupo8.openxava;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.openxava.chat.ChatEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.openxava.naviox.web.NaviOXFilter;

@SpringBootApplication(scanBasePackages = "com.grupo8.openxava")
@ServletComponentScan(basePackages = { "org.openxava", "com.openxava" })
public class OpenXavaFinalProjectApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(OpenXavaFinalProjectApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(OpenXavaFinalProjectApplication.class);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.jsp");
    }

    @Bean
    public FilterRegistrationBean<NaviOXFilter> naviOXFilter() {
        FilterRegistrationBean<NaviOXFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new NaviOXFilter());
        registration.setName("naviox");
        registration.addUrlPatterns("*.jsp", "/modules/*", "/phone/index.jsp", "/m/*");
        registration.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD));
        return registration;
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        ServerEndpointExporter exporter = new ServerEndpointExporter();
        exporter.setAnnotatedEndpointClasses(ChatEndpoint.class);
        return exporter;
    }

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory();
    }
}
