package demo.entities.ecommerce;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Order")  
@Table(name = "TB_ECOM_ORDER")
public class OrderEntity  {   
	
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

	@Column(name = "total_amount", nullable = false)
	@JsonProperty("total_amount")
	private BigDecimal totalAmount;
	
	//@Transient
	@Column(name="status", nullable=true)  
	private String status;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	
	// OBS: TENTATIVAs DE COLUNA LAZY: NO H2 não teve efeito, mesmo com lazy a lista sempre é carregada (TODO: teste com mysql)
	@OneToMany
	/*
	@OneToMany(fetch = FetchType.LAZY)	
	@ElementCollection(fetch = FetchType.LAZY)
	@Lazy
		
    @JoinColumn(name = "order_id", referencedColumnName="id", nullable=true)
    //@JsonIgnore(true)
	private List<OrderItemEntity> items;
	 */
	
	/*
	@Formula(
			"(Select max(d.id) from TB_ORDER_ITEMS d WHERE d.order_id = id AND d.status <> 'DELIVERED')"
			)      
	@JsonIgnore(true)
	private Long hasItemNotDelivered;

	@PostLoad
	private void postLoad() {

		this.status = this.hasItemNotDelivered == null ? "CLOSED" : "PENDING";
	}
	*/
	
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

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public void setLogisticaSituacao(String logisticaSituacao) {
		this.status = logisticaSituacao;
	}

	/*
	public List<OrderItemEntity> getItems() {
		return items;
	}

	public void setItems(List<OrderItemEntity> items) {
		this.items = items;
	}
	*/

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
