package demo.repository.order;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.model.entities.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>, OrderRepositoryCustom {

	
	// Query method injected by JPA, based on naming method strategy
	public List<OrderEntity> findByTotalValueGreaterThan(Double value);
	
	// Query method injected by JPA, based on naming method strategy  
	public List<OrderEntity> findByIdOrderByTotalValueAsc(Long id);
	
	
	// TODO: write the expected query
	@Query("Select id, code, date, totalValue from Order")
	public List<OrderEntity> aggregatedSalesByProduct(Date startDate, Date endDate);

	
	
}