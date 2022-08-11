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
import demo.model.representional.OrderRepresentional;
import demo.service.OrderService;
import io.swagger.annotations.ApiOperation;



@RestController  
@Component
//@Secured("ROLE_ADMIN")
@RequestMapping("/api")  
public class OrderControler {

	
	/* TESTE WITHOUT BROWSER:  curl -X GET "http://localhost:8083/api/orders" -H "accept: application/json" */
	
	
	@Autowired 
	private OrderService orderService;


	@ApiOperation("Retrieve all Orders")  	  
	@RequestMapping(value="/orders", method = RequestMethod.GET, produces = "application/json")	
	//@LogEnabled
	public ResponseEntity<Resources<OrderRepresentional>> orders() {
							 
		List<OrderEntity> orders = this.orderService.getOrders();		
		//orders.stream().forEach(o -> o.add(linkTo(methodOn(OrderControler.class).order(o.getId())).withSelfRel()));
			
		if (orders ==  null)		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		if (orders.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		// RESPONSE BASED ON HATEOAS SPECIFICATION
		
		List<OrderRepresentional> list = new ArrayList<OrderRepresentional>();										
		orders.stream().forEach(o -> list.add(OrderRepresentional.build(o, linkTo(methodOn(OrderControler.class).order(o.getId())).withSelfRel(), linkTo(methodOn(OrderItemsControler.class).order(o.getId())).withRel("getItems") )));
						
		Link link = linkTo(methodOn(OrderControler.class).orders()).withSelfRel();
		Resources<OrderRepresentional> representational = new Resources<OrderRepresentional>(list, link);

		
		// SUCCESS
		return new ResponseEntity<>(representational,HttpStatus.OK);
	}
	
	
	
	/* WITHOUT HATEOAS
	@ApiOperation("Retrieve all Orders")  	  
	@RequestMapping(value="/orders", method = RequestMethod.GET)	
	//@LogEnabled
	public ResponseEntity<List<OrderEntity>> orders() {
		
					 
		List<OrderEntity> resource = this.orderService.getOrders();
		
		
		if (resource ==  null)		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		if (resource.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
		
		// SUCCESS
		return new ResponseEntity<>(resource,HttpStatus.OK);
	}
	*/

	

	@ApiOperation("Create one Order")
	@RequestMapping( value="/orders", method = RequestMethod.POST)
	public ResponseEntity orderNew(@RequestBody OrderEntity order) {
				
		if (order == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				
		OrderEntity resource = this.orderService.create(order);
		
		if (resource ==  null)		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
			
		// SUCCESS
		return new ResponseEntity<>(HttpStatus.CREATED);		
	}

	
	
	@ApiOperation("Retrieve Order")
	@RequestMapping(value="/orders/{id}", method = RequestMethod.GET)	
	public ResponseEntity<OrderEntity> order(@PathVariable Long id) {

		
		if (id == null || id == 0)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		Optional<OrderEntity> resource =  this.orderService.getOrder(id);
		
		
		if (resource ==  null)		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		if ((!resource.isPresent() || resource.get() == null))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
		
		// SUCCESS
		return new ResponseEntity<>(resource.get(),HttpStatus.OK);
	}
	
	
	@ApiOperation("Replace the content of an Order")
	@RequestMapping( value="/orders/{id}", method = RequestMethod.PUT)
	public ResponseEntity orderUpdate(@PathVariable Long id, @RequestBody OrderEntity order) {
		
		if (order == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		if (id == null || id == 0)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		order.setId(id);		
		OrderEntity resource = this.orderService.update(order);
				
		if (resource ==  null)		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		// SUCCESS		
		if (!resource.getId().equals(id))
			return new ResponseEntity<>(HttpStatus.CREATED);
				
		// SUCCESS
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@ApiOperation("Update parts of an Order")
	@RequestMapping(value="/orders/{id}", method = RequestMethod.PATCH)
	public ResponseEntity orderUpdatePartial(@PathVariable Long id, @RequestBody OrderEntity order) {
				
		if (order == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		if (id == null || id == 0)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		order.setId(id);
	 	OrderEntity resource = this.orderService.process(id, order);
		
		
		if (resource ==  null)		
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		// SUCCESS
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@ApiOperation("Delete an Order")
	@RequestMapping(value="/orders/{id}", method = RequestMethod.DELETE)
	public ResponseEntity orderDelete(@PathVariable Long id) {
		
		if (id == null || id == 0)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
						
		if (!this.orderService.delete(id))
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		// SUCCESS
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		/*
		return ResponseEntity.ok()
		        .header("Custom-Header", "foo")
		        .body("Custom header set");
		        */
		
	}





}



