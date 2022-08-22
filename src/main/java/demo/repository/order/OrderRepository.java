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
	
	
	
	
	// NOTA: NÃO FUNCIONOU COM JPQL E A CLASSE SalesAnalitics
	//@Query("Select new demo.model.SalesAnalitics(product.name, SUM(totalValue)) from OrderItemEntity  GROUP BY product.name")
	
	
	// NOTA: COM JSQL houve erro para identificar items.product 
	//@Query("Select items.product.name, SUM(totalValue) from Order group by items.product.name")
	
	
	
	/* NOTA: FUNCIONA, MAS COM RETORNO List<Object>
	 * Se tentar usar a classe SalesAnalitics ocorre erro na mapeamento: 
	 * No converter found capable of converting from type [org.springframework.data.jpa.repository.query.AbstractJpaQuery$TupleConverter$TupleBackedMap] to type [demo.model.SalesAnalitics]
	*/
	//@Query(nativeQuery = true, value = "select c.name as aggregate, sum(a.total_value) as amount from TB_ORDER a join TB_ORDER_ITEMS b on (b.order_id = a.id) join TB_PRODUCT c on (c.code = b.product_code) group by c.name")	
	//public List<Object> aggregatedSalesByProduct2();
	
	
	/* NOTA: com quey nativa, só funciona se o retorno for uma interface (neste caso ISalesAnalitics).
	 */
	@Query(nativeQuery = true, value = "select c.name as aggregate, sum(a.total_value) as amount from TB_ORDER a join TB_ORDER_ITEMS b on (b.order_id = a.id) join TB_PRODUCT c on (c.code = b.product_code) group by c.name")
	public List<ISalesAnalitics> aggregatedSalesByProduct();
	
	
	//public Double aggregatedSalesByProduct(Date startDate, Date endDate);

	
	
}