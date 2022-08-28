package demo.entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_PAYMENT")
public class PaymentEntity  {   

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name = "orderId")
	private Long orderId;
	
	@Column(name = "fiscal_number")
	private String fiscalNumber;
	
	
	@Column(name="value", nullable=false)
	@JsonProperty("value")
	private Double value;

	@Column(name="autorization_dt", nullable=false)
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private  LocalDate autorizationDateTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getFiscalNumber() {
		return fiscalNumber;
	}

	public void setFiscalNumber(String fiscalNumber) {
		this.fiscalNumber = fiscalNumber;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public LocalDate getAutorizationDateTime() {
		return autorizationDateTime;
	}

	public void setAutorizationDateTime(LocalDate autorizationDateTime) {
		this.autorizationDateTime = autorizationDateTime;
	}





}