package demo.model;


import java.math.BigDecimal;

public class PaymentOrderDTO  {

	private Long orderId;
	
	private String fiscalNumber;

	private BigDecimal totalValue;
	
	private Boolean aproved = false;

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

	public Boolean getAproved() {
		return aproved;
	}

	public void setAproved(Boolean aproved) {
		this.aproved = aproved;
	}
}
