package demo.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController  
@RequestMapping("/")  
public class BasicControler {
	
	  	  
	@RequestMapping	
	public String getBasic() {

		return "Hello World - My Fist Spring Boot Web Response !!!";
	}
	
	
	
}



