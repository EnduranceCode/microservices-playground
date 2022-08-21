package demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.ISalesAnalitics;
import demo.model.SalesAnalitics;
import demo.model.entities.OrderEntity;
import demo.repository.order.OrderRepository;


@Service
public class OrderService {


	    @Autowired
	    private OrderRepository repository;

		public OrderService() {
		
		}
		
		
		/* CRUD OPERATIONS */
		
		public List<OrderEntity> getOrders() {
			
			 return this.repository.findAll();			
		}
		
		
		public Optional<OrderEntity> getOrder(Long orderId) {
			
			 return this.repository.findById(orderId);			
		}
		
		
		
		public OrderEntity create(OrderEntity order) {
						
			// to be sure that it will cause a new resource
			 //order.setCodigo(null);
			
			 return this.repository.save(order);			
		}
		
		
		public OrderEntity update(OrderEntity order) {
			
			 return this.repository.save(order);			
		}
		
		
		public OrderEntity processUpdate(Long id, OrderEntity patchOrder) {
			
			
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
			
			 return this.repository.save(order);			
		}
		
		
		public boolean delete(Long id) {
						
		    this.repository.deleteById(id);
		    
			return true;			
		}
		
		
		/* FIM CRUD OPERATIONS */
		
		
		
		
		
		/* ADVANCED OPERATIONS */
		
		
		public List<ISalesAnalitics> getSalesByProduct() {
			
			 return this.repository.aggregatedSalesByProduct();			
		}
		
		public List<SalesAnalitics> getSalesByCustomer() {
			
			 return this.repository.aggregatedSalesByCustomer(null, null);			
		}
		
		
		
		
		
		
		
		
	

}
