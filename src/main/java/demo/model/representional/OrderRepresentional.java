package demo.model.representional;


import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import demo.model.entities.OrderEntity;


public class OrderRepresentional extends ResourceSupport { //RepresentationModel<OrderEntity> {  
		
	private OrderEntity content;

	public OrderEntity getContent() {
		return content;
	}
	
		
	public void setContent(OrderEntity content) {
		this.content = content;
	}

	public static OrderRepresentional build(OrderEntity content, Link... link) {
		
		OrderRepresentional instance = new OrderRepresentional();
		instance.setContent(content);
		instance.add(link);		
		return instance;		
	}



}