package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesAnalitics  {   

	
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


		public SalesAnalitics(String aggregate, double amount) {
			super();
			this.aggregate = aggregate;
			this.amount = amount;
		}
	
	

}