package com.example.productcrudAPI;

import com.example.productcrudAPI.model.Product;
import com.example.productcrudAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductcrudApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductcrudApiApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception{
		Product product1= new Product();

		product1.setPname("RAM");
		product1.setPdescription("Outer Part");
		productRepository.save(product1);

		Product product2=new Product();

		product2.setPname("CPU Cabin");
		product2.setPdescription("Outer Part");
		productRepository.save(product2);

	}
}
