package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import demo.repository.order_item.OrderItemRepository;



@Service
public class OrderItemsService {


	    @Autowired
	    OrderItemRepository repo;

		public OrderItemsService() {
		
		}

		public OrderItemRepository getRepo() {
			return repo;
		}
		
		

}
