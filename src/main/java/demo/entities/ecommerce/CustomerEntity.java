package demo.entities.ecommerce;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "TB_ECOM_CUSTOMER")
public class CustomerEntity {  
		      
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)	   
      @Column(name="id", nullable=false)
      private Long id;
      
      @Column(name="fiscal_number", nullable=false, unique=false)
      private String fiscalNumber;

      @Column(name="name", nullable=false)
      private String name;

      private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFiscalNumber() {
		return fiscalNumber;
	}

	public void setFiscalNumber(String fiscalNumber) {
		this.fiscalNumber = fiscalNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
      
      

      
      
}