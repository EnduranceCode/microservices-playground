package demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.entities.OrderItemEntity;



public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
	
	
	public List<OrderItemEntity> findByPedidoCodigoOrderById(String pedido_codigo);
	 
}