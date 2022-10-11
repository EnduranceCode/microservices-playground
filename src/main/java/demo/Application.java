package demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.reactive.ReactiveManagementWebSecurityAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;




/* RETIRA INICIALIZAÇÃO DAS DEPENENCIAS DE SEGURANÇA SECURITY (auto configuration) 
 * (spring-boot-starter-security, e do spring-boot-starter-actuator)o mesmo pode ser feito no application.yml
 * (o mesmo pode ser feito no application.yml) 
 * */
//@SpringBootApplication(exclude={SecurityAutoConfiguration.class}) // sem actuator 
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	
    	new SpringApplication(Application.class).run(args);
    	    	
    	System.out.println("<<< Demo Microservices: WebAPI eCommerce started >>>");
    }
       
	
}

