package demo.controler;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.entities.OrderEntity;
import demo.service.OrderService;


@RestController  
@RequestMapping("/api/humman-resources")  
public class RestRhControler {

	
	@RequestMapping("/salaries") 	
	public String getSalaries() {

		return "<<<<<<<<<<< Salaries Report >>>>>>>>>>>";
	}
	
	@RequestMapping("/hire") 	
	public String getHire() {

		return "<<<<<<<<<<<<< Interview and Hire new colaborators >>>>>>>>>>>";
	}


}



