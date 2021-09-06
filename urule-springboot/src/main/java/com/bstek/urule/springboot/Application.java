package com.bstek.urule.springboot;

import com.bstek.urule.console.servlet.URuleServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.http.HttpServlet;

/**
 * @author Jacky.gao
 * @since 2016年10月12日
 */
@SpringBootApplication
@ImportResource({"classpath:context.xml"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}

	@Bean
	public ServletRegistrationBean<HttpServlet> registerURuleServlet(){
		return new ServletRegistrationBean<HttpServlet>(new URuleServlet(),"/urule/*");
	}

}
