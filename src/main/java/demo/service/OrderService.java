package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.entities.OrderEntity;
import demo.repository.order.OrderRepository;


@Service
public class OrderService {


	@Autowired
	private OrderRepository repository;


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






}
