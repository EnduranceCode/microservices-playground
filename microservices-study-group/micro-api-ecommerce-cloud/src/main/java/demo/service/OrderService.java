package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.entities.OrderEntity;
import demo.model.PaymentOrderDTO;
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

	//@Transactional
	public OrderEntity processOrder(OrderEntity order) {
			
		/******  create orde *****/
		order.setStatus("SUBMITTED");
		order = this.repository.saveAndFlush(order);		
		
		System.out.println("Email Submited: Dear " + order.getCustomer().getName() + " Your order " + order.getCode() + " was receveid on 2022/XX/XX ");
		//OrderEntity order = this.repository.findById(orderPost.getId()).get();
				
		/***** call FINANCE service (SYNCHRONOUSLY) *****/
		
		PaymentOrderDTO requestFinance = new PaymentOrderDTO();
		requestFinance.setOrderId(order.getId());
		requestFinance.setFiscalNumber(order.getCustomer().getFiscalNumber());
		requestFinance.setValue(order.getTotalAmount());
						
		RestTemplate restTemplate = new RestTemplate();	
		ResponseEntity<PaymentOrderDTO> responseFinance = restTemplate.postForEntity(servicePaymentURI, requestFinance, PaymentOrderDTO.class);		
		
		if (responseFinance.getBody().getApproved()) {
			
			// update order status
			order.setStatus("PAYMENT_APPROVED");
			this.update(order);
			
			// SEND EMAIL AND SMS TO CUSTOMERS			
			System.out.println("Email Payment: Dear " + order.getCustomer().getName() + " Paymment for your order " + order.getCode() + " was processed.");	
		}
		
		/****** call LOGISTIC SERVICE service (SYNCHRONOUSLY)  *****/
		/* TO DO 
		 * 
		 * */		
		boolean callLogisticOk = true;
		
		if (callLogisticOk) {
			
			// update order status
			order.setStatus("DELIVERY_SCHEDULED");
			this.update(order);
			
			// SEND EMAIL AND SMS TO CUSTOMERS	
			System.out.println("Email Delivery: Dear " + order.getCustomer().getName() + " Your order " + order.getCode() + " was will be delivery before 2022/XX/XX ");
		}
		
		return order;
	}
}
