package demo.repository.order;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import demo.model.entities.OrderEntity;


@Repository
public interface OrderRepositoryCustom  {
	
	
	public List<OrderEntity> aggregatedSalesByCustomer(Date startDate, Date endDate);
	
	 
}