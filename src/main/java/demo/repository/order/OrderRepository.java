package demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entities.OrderEntity;



@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	
	
}