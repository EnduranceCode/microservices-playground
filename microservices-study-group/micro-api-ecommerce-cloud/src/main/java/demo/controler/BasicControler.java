package demo.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController   
public class BasicControler {
	
	  	  
	@RequestMapping("/") 	
	public String getBasic() {

		return "Hello World - My Fist Spring Boot Web Response !!!";
	}

	@RequestMapping("/page-sucess") 	
	public String getSucess() {

		return "Basic Login suceeded !!!!!!!!!!!!!!!!!!!!!!!!";
	}

	
	
}



