package demo.entities.finance;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_FIN_PAYMENT")
public class PaymentEntity  {   

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name = "orderId")
	private Long orderId;
	
	@Column(name = "fiscal_number")
	private String fiscalNumber;
	
	@Column(name="order_value", nullable=false)
	@JsonProperty("value")
	private Double orderValue;

	@Column(name="autorization_dt", nullable=false)
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private  LocalDateTime autorizationDateTime;

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

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	public LocalDateTime getAutorizationDateTime() {
		return autorizationDateTime;
	}

	public void setAutorizationDateTime(LocalDateTime autorizationDateTime) {
		this.autorizationDateTime = autorizationDateTime;
	}
}
