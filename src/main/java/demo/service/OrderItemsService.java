package demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import demo.model.entities.OrderEntity;
import demo.model.entities.OrderItemEntity;
import demo.repository.order_item.OrderItemRepository;



@Service
public class OrderItemsService {


	    @Autowired
	    private OrderItemRepository repository;

		
		public List<OrderItemEntity> getOrders(Long orderId) {
						
			 return this.repository.findByOrderIdOrderByProductCode(orderId);			
		}

		

}
