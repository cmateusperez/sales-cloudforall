package co.com.cloudforall.sales.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_detail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne( )
	private Order order;

	@ManyToOne( )
	private Product product;

	private Integer quantity;
}
