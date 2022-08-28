package demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import demo.model.PaymentOrderDTO;

import demo.service.PaymentService;


@RestController   
public class RestControler {

	
	@Autowired 
	private PaymentService paymentService;


	@RequestMapping(value="/", method = RequestMethod.GET)	
	@ResponseStatus(HttpStatus.OK)
	public String getTest() {
		
		return "Test Finance Service";
	}

	
	@RequestMapping( value="/order-payment", method = RequestMethod.POST)
	public ResponseEntity<PaymentOrderDTO> setPayment(@RequestBody PaymentOrderDTO orderPaymentDTO) {
				
		 orderPaymentDTO = this.paymentService.processPayment(orderPaymentDTO);
		
		return new ResponseEntity<>(orderPaymentDTO,HttpStatus.OK);		
	}



}



