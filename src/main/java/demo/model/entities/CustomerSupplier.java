package demo.model.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity (name = "TB_CLIENTE")  
public class CustomerSupplier {  
		      
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)	   
      @Column(name="id", nullable=false)
      private Long id;
      
      @Column(name="cpf", nullable=false, unique=false)
      private String cpf;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public void setEmail(String email) {
		this.email = email;
	}
      

      
      
}