package co.com.cloudforall.sales.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "id_invoice")
	private UUID idInvoice;

	@ManyToOne(cascade = CascadeType.ALL)
	private DeliverySite deliverySite;

	@OneToOne()
	private PreOrder preOrder;
	
	@OneToMany ( mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
	
	public void addDetail(OrderDetail detail) {
		if(orderDetails == null) {
			orderDetails = new ArrayList<OrderDetail>();
		}
		orderDetails.add(detail);
	}
}
