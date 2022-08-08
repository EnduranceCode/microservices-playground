package demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.entities.OrderEntity;


public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	 
}