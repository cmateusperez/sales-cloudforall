package co.com.cloudforall.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.cloudforall.sales.repository.entity.PreOrder;

@Repository
public interface PreOrderRepository extends JpaRepository<PreOrder, Integer> {

}
