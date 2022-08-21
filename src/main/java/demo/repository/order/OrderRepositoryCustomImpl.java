package demo.repository.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import demo.model.SalesAnalitics;

import demo.model.entities.OrderEntity;


@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Override
	public List<SalesAnalitics> aggregatedSalesByCustomer(Date startDate, Date endDate) {
		

		/*
		List<Object[]> arrayResultSet = entityManager.createQuery("Select customer.name as aggregate, SUM(totalValue) as amount from Order group by customer.name").getResultList();
		
		List<SalesAnalitics> list = new ArrayList<SalesAnalitics>();
				
		for (Object[] item : arrayResultSet) {			
			list.add(new SalesAnalitics((String)item[0],(double)item[1]));
		}
		return list;
		*/
				
				
		return (List<SalesAnalitics>) entityManager.createQuery("SELECT new demo.model.SalesAnalitics(customer.name, SUM(totalValue)) from Order group by customer.name").getResultList();
		
		// query nativa
		//return (List<SalesAnalitics>) entityManager.createNativeQuery("Select 'OK' as aggregate, SUM(total_value) as amount from tb_order group by 1").getResultList();
		
			
		     //     .setParameter("startDate", startDate)
		          //.setParameter("endDate", endDate);
		         
		    
	}
	
}