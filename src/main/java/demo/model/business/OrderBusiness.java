package demo.model.business;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import demo.model.entities.OrderEntity;
import demo.model.repository.OrderRepository;


@Service
public class OrderBusiness {


	    @Autowired
	    OrderRepository repo;

		public OrderBusiness() {
		
		}

		public OrderRepository getRepo() {
			return repo;
		}
		
		
		
		public List<OrderEntity> getOrders() {
			
			 return this.getRepo().findAll();			
		}
		
		
		public Optional<OrderEntity> getOrder(Long orderId) {
			
			 return this.getRepo().findById(orderId);			
		}
		
		
		
		public OrderEntity create(OrderEntity order) {
						
			// to be sure that it will cause a new resource
			 //order.setCodigo(null);
			
			 return this.getRepo().save(order);			
		}
		
		
		public OrderEntity update(OrderEntity order) {
			
			 return this.getRepo().save(order);			
		}
		
		
		public OrderEntity process(Long id, OrderEntity patchOrder) {
			
			
			Optional<OrderEntity> oldVersion = this.getOrder(id);
					 
			 
			if ((!oldVersion.isPresent() || oldVersion.get() == null))
				return null;
			
			
			OrderEntity order = oldVersion.get();
			

			if (!ObjectUtils.isEmpty(patchOrder.getCustomer())) {
				
				if (!ObjectUtils.isEmpty(patchOrder.getCustomer().getId()))
					order.getCustomer().setId(patchOrder.getCustomer().getId());
			}
			
			if (!ObjectUtils.isEmpty(patchOrder.getCode()))
				order.setCode(patchOrder.getCode());
						
			if (!ObjectUtils.isEmpty(patchOrder.getDate()))
				order.setDate(patchOrder.getDate());
			
			if (!ObjectUtils.isEmpty(patchOrder.getTotalValue()))
				order.setTotalValue(patchOrder.getTotalValue());
			
			 return this.getRepo().save(order);			
		}
		
		
		public boolean delete(Long id) {
						
		    this.getRepo().deleteById(id);
		    
			return true;			
		}
	

}
