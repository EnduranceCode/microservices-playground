package demo.model.entities;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity (name = "TB_PEDIDO")  
public class OrderEntity {  
		 
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id", nullable=false)
	  private Long id;
	  	  
	  
	  @Column(name="codigo", nullable=false, unique=true)  
      private String codigo;
	  
	  
	  @Column(name="data", nullable=false)
	 // @Temporal(TemporalType.DATE)
	  @JsonFormat(pattern="dd/MM/yyyy")
      private  LocalDate data;
      
	  @Column(name="valor_total", nullable=false)  
      private Double valorTotal;
                  
      @ManyToOne
      @JoinColumn(name = "id_cliente")      
      private CustomerSupplier cliente;
      

      @Formula(
      "(Select max(d.id) from TB_PEDIDO_PRODUTOS d WHERE d.pedido_id = id AND d.situacao <> 'ENTREGUE')"
      )      
      @JsonIgnore(true)
      private Long idItemEmAndamento;
      
      

      @Transient    	      
      private String logisticaSituacao;

      @PostLoad
      private void postLoad() {
    	  
    	  this.logisticaSituacao = this.idItemEmAndamento == null ? "FINALIZADA" : "INCOMPLETA";
      }

      /* OU SO O METODO SEM ATRIBUTO
      @Transient
      public String getLogisticaFinalizada() {
		  
    	  return this.idItemEmAndamento == null ? "Sim" : "Não";
    	  
      }  
      */
      public String getLogisticaSituacao() {
    	  return this.logisticaSituacao;
      }
      
 
      //@OneToMany(mappedBy = "pedido", targetEntity = PedidoProdutosEntidade.class)
      //private List<PedidoProdutosEntidade> itens;
  	

      
      
      
	public String getCodigo() {
		return codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public CustomerSupplier getCliente() {
		return cliente;
	}

	public void setCliente(CustomerSupplier cliente) {
		this.cliente = cliente;
	}


	public Long getIdItemEmAndamento() {
		return idItemEmAndamento;
	}


	public void setIdItemEmAndamento(Long idItemEmAndamento) {
		this.idItemEmAndamento = idItemEmAndamento;
	}




	
	
    /*
	public List<PedidoProdutosEntidade> getItens() {
		return itens;
	}

	public void setItens(List<PedidoProdutosEntidade> itens) {
		this.itens = itens;
	}
	*/
      
	      
      
}