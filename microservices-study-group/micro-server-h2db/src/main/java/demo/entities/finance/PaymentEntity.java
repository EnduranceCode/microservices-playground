package demo.entities.finance;

import java.math.BigDecimal;
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

	@Column(name="total_value", nullable=false)
	@JsonProperty("total_value")
	private BigDecimal totalValue;

	@Column(name="authorization_dt", nullable=false)
	@JsonFormat(pattern="dd/MM/yyyy hh:mm")
	private  LocalDateTime authorizationDateTime;

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

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public LocalDateTime getAuthorizationDateTime() {
		return authorizationDateTime;
	}

	public void setAuthorizationDateTime(LocalDateTime authorizationDateTime) {
		this.authorizationDateTime = authorizationDateTime;
	}
}
