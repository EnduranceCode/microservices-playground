package demo.repository.order;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.entities.OrderEntity;


@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderEntity> aggregatedSalesByCustomer(Date startDate, Date endDate) {
		
		     return (List<OrderEntity>) entityManager.createQuery("")
		          .setParameter("startDate", startDate)
		          .setParameter("endDate", endDate);
		         
		    
	}
	
}