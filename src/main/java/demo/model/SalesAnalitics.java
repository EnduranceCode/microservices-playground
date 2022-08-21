package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface SalesAnalitics  {   

	public String getAggregate();
		
	public double getAmount();
	
	

}