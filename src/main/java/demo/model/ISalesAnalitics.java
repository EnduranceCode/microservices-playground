package demo.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface ISalesAnalitics  {   


	public String getAggregate();
	
	public double getAmount();


}