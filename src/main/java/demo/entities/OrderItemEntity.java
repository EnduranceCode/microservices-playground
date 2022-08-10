package demo.entities;



import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_ORDER_ITEMS")  
public class OrderItemEntity {  
		
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="id", nullable=false)
      private Long id;
	  
	  
	  @Column(name="status", nullable=false)  
      private String status;
	  	  
	  
	  @Column(name="amount", nullable=false)  
      private Integer amount;
	  	  
	  @Column(name="price", nullable=false)  
      private Double price;
	  
	  @Column(name="value", nullable=false)  
      private Double value;
	  
	  
      @ManyToOne
      @JoinColumn(name = "product_code")      
      private ProductEntity product;
      
                  
      @ManyToOne
      //@JoinColumn(name = "pedido_codigo", referencedColumnName="codigo", nullable=false)
      @JoinColumn(name = "order_id", nullable=false)
      @JsonIgnore(true)
      private OrderEntity order;


	public OrderItemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	public ProductEntity getProduct() {
		return product;
	}


	public void setProduct(ProductEntity product) {
		this.product = product;
	}


	public OrderEntity getOrder() {
		return order;
	}


	public void setOrder(OrderEntity order) {
		this.order = order;
	}



      
      
      
}