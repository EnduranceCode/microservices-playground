package demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration 
public class Application {

    public static void main(String[] args) {
    	
    	new SpringApplication(Application.class).run(args);
    	    	
    	System.out.println("<<< Demo Microservices: WebAPI eCommerce started >>>");
    }
       
	
}

