package demo.model.entities;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity  
@Table(name = "TB_ORDER")
public class OrderEntity {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Long id;


	@Column(name="code", nullable=false, unique=true)  
	private String code;


	@Column(name="date", nullable=false)
	// @Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	private  LocalDate date;

	@Column(name="total_value", nullable=false)  
	private Double totalValue;

	@ManyToOne
	@JoinColumn(name = "customer_id")      
	private CustomerEntity customer;


	@Formula(
			"(Select max(d.id) from TB_ORDER_ITEMS d WHERE d.order_id = id AND d.status <> 'DELIVERED')"
			)      
	@JsonIgnore(true)
	private Long hasItemNotDelivered;


	@Transient    	      
	private String status;

	@PostLoad
	private void postLoad() {

		this.status = this.hasItemNotDelivered == null ? "CLOSED" : "PENDING";
	}

	public String getStatus() {
		return status;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Long getIdItemEmAndamento() {
		return hasItemNotDelivered;
	}

	public void setIdItemEmAndamento(Long idItemEmAndamento) {
		this.hasItemNotDelivered = idItemEmAndamento;
	}

	public void setLogisticaSituacao(String logisticaSituacao) {
		this.status = logisticaSituacao;
	}





	
	
	

	//@OneToMany(mappedBy = "pedido", targetEntity = PedidoProdutosEntidade.class)
	//private List<PedidoProdutosEntidade> itens;




	/*
	public List<PedidoProdutosEntidade> getItens() {
		return itens;
	}

	public void setItens(List<PedidoProdutosEntidade> itens) {
		this.itens = itens;
	}
	 */



}