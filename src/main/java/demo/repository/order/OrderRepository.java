package demo.repository.order;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.model.ISalesAnalitics;
import demo.model.SalesAnalitics;
import demo.model.entities.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>, OrderRepositoryCustom {

	
	// Query method injected by JPA, based on naming method strategy
	public List<OrderEntity> findByTotalValueGreaterThan(Double value);
	
	// Query method injected by JPA, based on naming method strategy  
	public List<OrderEntity> findByIdOrderByTotalValueAsc(Long id);
	
	

	// COM JSQL houve erro para identificar items.product
	//@Query("Select items.product.name, SUM(totalValue) from Order group by items.product.name")
	
	//new demo.model.SalesAnalitics(customer.name, SUM(totalValue))
	@Query(nativeQuery = true, value = "select c.name as aggregate, sum(a.total_value) as amount from TB_ORDER a join TB_ORDER_ITEMS b on (b.order_id = a.id) join TB_PRODUCT c on (c.code = b.product_code) group by c.name")
	public List<ISalesAnalitics> aggregatedSalesByProduct();
	
	//public Double aggregatedSalesByProduct(Date startDate, Date endDate);

	
	
}