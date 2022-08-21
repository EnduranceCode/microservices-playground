package demo.repository.order;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import demo.model.SalesAnalitics;


@Repository
public interface OrderRepositoryCustom  {
	
	
	public List<SalesAnalitics> aggregatedSalesByCustomer(Date startDate, Date endDate);
	//public Double aggregatedSalesByCustomer(Date startDate, Date endDate);
	
	 
}