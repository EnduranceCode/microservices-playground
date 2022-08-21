package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.entities.ProductEntity;
import demo.repository.order.ProductRepository;



@Service
public class ProductService {


	    @Autowired
	    private ProductRepository repository;

		
		public ProductEntity getProduct(String code) {
						
			 return this.repository.findByCode(code);			
		}

		

}
