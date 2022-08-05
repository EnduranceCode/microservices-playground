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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity (name = "TB_PEDIDO_PRODUTOS")  
public class OrderItemEntity {  
		
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="id", nullable=false)
      private Long id;
	  
	  
	  @Column(name="situacao", nullable=false)  
      private String situacao;
	  	  
	  
	  @Column(name="quantidade", nullable=false)  
      private Integer quantidade;
	  
	  
	  @Column(name="preco", nullable=false)  
      private Double preco;
	  
	  @Column(name="valor", nullable=false)  
      private Double valor;
	  
	  
      @ManyToOne
      @JoinColumn(name = "produto_codigo")      
      private ProductEntity produto;
      
                  
      @ManyToOne
      //@JoinColumn(name = "pedido_codigo", referencedColumnName="codigo", nullable=false)
      @JoinColumn(name = "pedido_id", nullable=false)
      @JsonIgnore(true)
      private OrderEntity pedido;


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


	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public OrderEntity getPedido() {
		return pedido;
	}


	public void setPedido(OrderEntity pedido) {
		this.pedido = pedido;
	}




	public ProductEntity getProduto() {
		return produto;
	}




	public void setProduto(ProductEntity produto) {
		this.produto = produto;
	}

      
	
      
 	
      
      
      
}