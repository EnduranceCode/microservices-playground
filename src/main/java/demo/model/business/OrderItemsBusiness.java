package demo.model.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import demo.model.repository.OrderItemRepository;



@Service
public class OrderItemsBusiness {


	    @Autowired
	    OrderItemRepository repo;

		public OrderItemsBusiness() {
		
		}

		public OrderItemRepository getRepo() {
			return repo;
		}
		
		

}
