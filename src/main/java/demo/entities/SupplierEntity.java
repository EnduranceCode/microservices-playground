package demo.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity (name = "TB_FORNECEDOR")  
public class SupplierEntity {  
		      
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="id", nullable=false)
      private Long id;
      
      @Column(name="cnpj", nullable=false, unique=false)
      private String cnpj;

      @Column(name="nome", nullable=false)
      private String nome;
      
      @Column(name="email", nullable=false)
      private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emaio) {
		this.email = email;
	}
      

      
      
}