package demo.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.model.entities.OrderEntity;
import demo.model.entities.OrderItemEntity;
import demo.model.representional.OrderRepresentional;
import demo.service.OrderItemsService;
import demo.service.OrderService;
import io.swagger.annotations.ApiOperation;



@RestController  
@Component
//@Secured("ROLE_ADMIN")
@RequestMapping("/api")  
public class OrderItemsControler {

	@Autowired 
	private OrderItemsService orderItemsService;
	
	
	@ApiOperation("Retrieve Order Items")
	@RequestMapping(value="/orders/{orderId}/items", method = RequestMethod.GET)	
	public ResponseEntity<List<OrderItemEntity>> order(@PathVariable Long orderId) {
		
		if (orderId == null || orderId == 0)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		List<OrderItemEntity> resource =  this.orderItemsService.getOrders(orderId);
		
		
		if (resource ==  null)		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		if ((resource == null))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
		
		// SUCCESS
		return new ResponseEntity<>(resource,HttpStatus.OK);
	}
	
	

}



