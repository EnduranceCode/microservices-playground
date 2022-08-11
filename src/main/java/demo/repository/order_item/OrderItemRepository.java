package demo.repository.order_item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.entities.OrderItemEntity;



@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
	
	
	public List<OrderItemEntity> findByOrderIdOrderByProductCode(Long orderId);
	
	public List<OrderItemEntity> findByOrderCodeOrderById(String orderCode);
	

	 
}