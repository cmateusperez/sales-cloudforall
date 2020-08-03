package co.com.cloudforall.sales;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.cloudforall.sales.repository.DeliverySiteRepository;
import co.com.cloudforall.sales.repository.PreOrderRepository;
import co.com.cloudforall.sales.repository.ProductRepository;
import co.com.cloudforall.sales.repository.entity.DeliverySite;
import co.com.cloudforall.sales.repository.entity.PreOrder;
import co.com.cloudforall.sales.repository.entity.Product;

@SpringBootApplication
public class SalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository productRepository, DeliverySiteRepository deliverySiteRepository, PreOrderRepository preOrderRepository) {
		return args -> {
			Product firstProduct = new Product(1, "Arnes industrial", "Ajustable y resistente hasta 90 kg", 600000D);
			productRepository.save(firstProduct);
			Product secondProduct = new Product(2, "Careta Ajustable", "Ajustable y resistente hasta 90 kg", 90000D);
			productRepository.save(secondProduct);
			DeliverySite deliverySite = new DeliverySite(1, "Bodega 1 Central - Km 3 Via La Florida");
			deliverySiteRepository.save(deliverySite);
			PreOrder preOrder = new PreOrder(1, "Preventa artículo para industrias generales 20-07-2020");
			preOrderRepository.save(preOrder);
		};

	}

}
