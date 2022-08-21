package demo.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ISalesAnalitics  {   


	//@JsonProperty("Aggregate")
	private String aggregate;
 
	//@JsonProperty("Sales Amount")
	private double amount;

	//@JsonProperty("Aggregate")
	public String getAggregate() {
		return aggregate;
	}

	public void setAggregate(String aggregate) {
		this.aggregate = aggregate;
	}

	//@JsonProperty("Sales Amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public ISalesAnalitics(String aggregate, double amount) {
		super();
		this.aggregate = aggregate;
		this.amount = amount;
	}


}