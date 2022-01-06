package com.example.rest.webservices.restfulwebservices;
//import com.example.rest.webservices.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import com.example.rest.webservices.helloworldbean.ControllerClass;
//@ComponentScan(basePackages= {"com.example.rest.webservices.helloworldbean"})
//@ComponentScan(basePackages= {"com.example.rest.webservices.restfulwebservices.wikiController"})
@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}
