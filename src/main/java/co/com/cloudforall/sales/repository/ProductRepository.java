package co.com.cloudforall.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cloudforall.sales.repository.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
