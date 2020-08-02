package co.com.cloudforall.sales;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.cloudforall.sales.repository.ProductRepository;
import co.com.cloudforall.sales.repository.entity.Product;

@SpringBootApplication
public class SalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository productRepository) {
		return args -> {
			Product product = new Product(1, "crema dental", "colgate 500 ml");
			productRepository.save(product);
		};

	}

}
