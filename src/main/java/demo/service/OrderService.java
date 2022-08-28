package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.model.entities.OrderEntity;
import demo.repository.order.OrderRepository;


@Service
public class OrderService {


	@Autowired
	private OrderRepository repository;
	
	
	@Value("${app.services.payment.uri}")
	private String servicePaymentURI;


	public List<OrderEntity> getOrders() {

		return this.repository.findAll();			
	}


	public OrderEntity getOrder(Long orderId) {

		return this.repository.findById(orderId).get();			
	}


	public OrderEntity create(OrderEntity order) {

		return this.repository.save(order);			
	}


	public OrderEntity update(OrderEntity order) {

		return this.repository.save(order);			
	}


	public boolean delete(Long id) {

		this.repository.deleteById(id);

		return true;			
	}

	
	
	
	public OrderEntity processOrder(OrderEntity order) {
			
		// create order
		order = this.repository.save(order);
			
		
		// call payment service (SYNCHRONOUSLY)
		RestTemplate restTemplate = new RestTemplate();		
		HttpEntity<OrderEntity> request = new HttpEntity<>(order);
		
		//ResponseEntity<OrderEntity> objReturned = restTemplate.postForEntity(servicePaymentURI, request, OrderEntity.class);		
		ResponseEntity<OrderEntity> objReturned = restTemplate.getForEntity(servicePaymentURI + "5", OrderEntity.class);
		
		
		// call logistic service (SYNCHRONOUSLY)		
		/* TO DO 
		 * CALL LOGISTIC SERVICE
		 * */
		
		
		// SEND EMAIL AND SMS TO CUSTOMERS
		System.out.println("Email: Dear " + order.getCustomer().getName() + " Paymment for your order " + order.getCode() + " was processed.");
		System.out.println("Email: Dear " + order.getCustomer().getName() + " Your order " + order.getCode() + " was will be delivery before 2022/XX/XX ");
		
		
		return order;
		
	}

		
	



}
