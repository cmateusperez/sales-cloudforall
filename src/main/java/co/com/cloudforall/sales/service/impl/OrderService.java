package co.com.cloudforall.sales.service.impl;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cloudforall.sales.repository.OrderDetailRepository;
import co.com.cloudforall.sales.repository.OrderRepository;
import co.com.cloudforall.sales.repository.PreOrderRepository;
import co.com.cloudforall.sales.repository.ProductRepository;
import co.com.cloudforall.sales.repository.entity.DeliverySite;
import co.com.cloudforall.sales.repository.entity.Order;
import co.com.cloudforall.sales.repository.entity.OrderDetail;
import co.com.cloudforall.sales.repository.entity.PreOrder;
import co.com.cloudforall.sales.repository.entity.Product;
import co.com.cloudforall.sales.service.IOrderService;
import co.com.cloudforall.sales.service.domain.OrderRequest;
import co.com.cloudforall.sales.service.domain.OrderResponse;
import co.com.cloudforall.sales.util.exception.ResourceNotFoundException;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	PreOrderRepository preOrderRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public OrderResponse add(OrderRequest orderRequest) {

		PreOrder preOrder = preOrderRepository.findById(orderRequest.getIdPreOrder())
				.orElseThrow(() -> new ResourceNotFoundException("", "", null));
		Product product = productRepository.findById(orderRequest.getIdProducto())
				.orElseThrow(() -> new ResourceNotFoundException("", "", null));
		DeliverySite deliverySiteDefault = DeliverySite.builder().id(1).build();
		Order order = Order.builder().deliverySite(deliverySiteDefault).idInvoice(UUID.randomUUID()).preOrder(preOrder)
				.build();
		Order orderSaved = orderRepository.save(order);
		OrderDetail orderDetail = OrderDetail.builder().order(orderSaved).product(product)
				.quantity(orderRequest.getQuantity()).build();
		orderDetailRepository.save(orderDetail);
		String totalPurchases = getTotalPurchases(product.getPrice(), orderRequest.getQuantity());
		OrderResponse orderResponse = OrderResponse.builder().idInvoice(orderSaved.getIdInvoice().toString())
				.deliverySite(orderSaved.getDeliverySite().getName()).date(LocalDateTime.now())
				.totalPurchases(totalPurchases).build();
		return orderResponse;
	}

	private String getTotalPurchases(Double price, Integer quantity) {
		Double totalPurchase = price * quantity;
		return formatCurrency(totalPurchase);
	}

	private String formatCurrency(Double value) {
		DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
		return "$" + dFormat.format(value);
	}

	@Override
	public List<OrderResponse> getAll() {
		return null;
	}

}
