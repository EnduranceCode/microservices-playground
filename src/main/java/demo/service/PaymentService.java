package demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.entities.PaymentEntity;
import demo.model.PaymentOrderDTO;
import demo.repository.order.PaymentRepository;



@Service
public class PaymentService {


	@Autowired
	private PaymentRepository repository;
	

	public List<PaymentEntity> getPayments() {

		return this.repository.findAll();			
	}


	public PaymentEntity getPayment(Long paymentId) {

		return this.repository.findById(paymentId).get();			
	}


	public PaymentEntity create(PaymentEntity Payment) {

		return this.repository.save(Payment);			
	}


	public PaymentEntity update(PaymentEntity payment) {

		return this.repository.save(payment);			
	}


	public boolean delete(Long id) {

		this.repository.deleteById(id);

		return true;			
	}

	
	
	
	public PaymentOrderDTO processPayment(PaymentOrderDTO paymentOrderDTO) {
			
		// create Payment
		PaymentEntity paymentEntity = new PaymentEntity();		
		paymentEntity.setOrderId(paymentOrderDTO.getOrderId());
		paymentEntity.setFiscalNumber(paymentOrderDTO.getFiscalNumber());	
		paymentEntity.setValue(paymentOrderDTO.getValue());
		paymentEntity.setAutorizationDateTime(LocalDateTime.now());
		paymentEntity = this.repository.save(paymentEntity);
						
		
		/********  CALL EXTERNAL CREDIT CARD OPERATOR ******/
				
		// SIMULATES A BAD PERFORMANCE PROCESS DURATION
		
		System.out.println("WAITING FOR EXTERNAL SERVICE PAYMENT ....");	
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("PAYMENT AUTHORIZATION RESPONSE");
	    
		/*********/
	    	
	   
	    paymentOrderDTO.setAproved(true);
	    
		return paymentOrderDTO;		
	}

		
	



}
