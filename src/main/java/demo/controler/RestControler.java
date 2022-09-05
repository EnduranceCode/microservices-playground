package demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.entities.OrderEntity;
import demo.service.OrderService;


@RestController  
@RequestMapping("/api")  
public class RestControler {

	
	@Autowired 
	private OrderService orderService;

	
	/* BASIC REST CRUD OPERATIONS */ 
  	  
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<OrderEntity> getOrders() {
		
		List<OrderEntity> orders = this.orderService.getOrders();	

		return orders;
	}
	
	
	@RequestMapping(value="/orders/{id}", method = RequestMethod.GET)	
	@ResponseStatus(HttpStatus.OK)
	public OrderEntity getOrder(@PathVariable Long id) {
	
		OrderEntity resource = this.orderService.getOrder(id);			
		
		return resource;
	}

	
	@RequestMapping( value="/orders", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void setOrder(@RequestBody OrderEntity order) {
	
		
		this.orderService.create(order);		
		
		// try it in order to call finance microservice
		//this.orderService.processOrder(order);
				
	}


	@RequestMapping( value="/orders/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void setOrder(@PathVariable Long id, @RequestBody OrderEntity order) {
		
		this.orderService.update(order);				

	}


	@RequestMapping(value="/orders/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeOrder(@PathVariable Long id) {
		
		this.orderService.delete(id);
						
	}
	
	/* BASIC REST CRUD OPERATIONS */ 
	

	
	
	
	


}



