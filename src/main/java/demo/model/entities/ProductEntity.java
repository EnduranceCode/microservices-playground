package demo.model.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity (name = "TB_PRODUTO")  
public class ProductEntity {  
		      
	  @Id
	  @Column(name="codigo", nullable=false, unique=false)  
      private String codigo;
      
      @Column(name="nome", nullable=false)
      private String nome;

      @Column(name="especificacao", nullable=false)
      private String especificacao;

      @Column(name="categoria", nullable=false)
      private String categoria;

      @Column(name="preco", nullable=false)
      private Double preco;
      
      @ManyToOne
      @JoinColumn(name = "id_fornecedor")      
      private SupplierEntity fornecedor;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public SupplierEntity getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(SupplierEntity fornecedor) {
		this.fornecedor = fornecedor;
	}
      
	
      
      

      
}