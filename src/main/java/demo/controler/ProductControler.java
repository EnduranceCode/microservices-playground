package demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.model.entities.OrderItemEntity;
import demo.model.entities.ProductEntity;
import demo.service.OrderItemsService;
import demo.service.ProductService;
import io.swagger.annotations.ApiOperation;



@RestController  
@Component
//@Secured("ROLE_ADMIN")
@RequestMapping("/api")  
public class ProductControler {

	@Autowired ProductService productService;
	
	
	@ApiOperation("Retrieve Product")
	@RequestMapping(value="/products/{code}", method = RequestMethod.GET)
	public ResponseEntity<ProductEntity> product(@PathVariable String code) {
		
		if (code == null || code.equals(0))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
		ProductEntity resource = null;
		try {
			 resource =  this.productService.getProduct(code);	
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		if ((resource == null))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
		// SUCCESS
		return new ResponseEntity<>(resource,HttpStatus.OK);
	}
	
	

}



