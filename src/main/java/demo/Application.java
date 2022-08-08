package demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import demo.annotation.*;


@SpringBootApplication
@EnableAutoConfiguration 
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
    	
    	new SpringApplication(Application.class).run(args);
    	    	
    	System.out.println("<<< Demo Microservices: WebAPI eCommerce started >>>");
    }
       
	
}

