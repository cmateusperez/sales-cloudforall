package co.com.cloudforall.sales.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cloudforall.sales.repository.DeliverySiteRepository;
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
import co.com.cloudforall.sales.util.Constants;
import co.com.cloudforall.sales.util.exception.ResourceNotFoundException;
import co.com.cloudforall.sales.util.mapper.OrderMapper;

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

	@Autowired
	private DeliverySiteRepository deliverySiteRepository;

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<OrderResponse> getAll() {
		return orderMapper.ordersToOrderResponse(orderRepository.findAll());
	}

	@Override
	public OrderResponse add(OrderRequest orderRequest) {
		PreOrder preOrder = queryPreOrder(orderRequest);
		Product product = queryProduct(orderRequest);
		DeliverySite deliverySiteDefault = queryDeliverySite();
		Order order = createOrUpdateOrder(orderRequest, preOrder, product, deliverySiteDefault);
		return orderMapper.ordertToOrderResponse(order);
	}

	private DeliverySite queryDeliverySite() {
		return deliverySiteRepository.findById(1).orElseThrow();
	}

	private Order createOrUpdateOrder(OrderRequest orderRequest, PreOrder preOrder, Product product,
			DeliverySite deliverySiteDefault) {
		Order order = queryOrder(preOrder).orElse(Order.builder().deliverySite(deliverySiteDefault)
				.idInvoice(UUID.randomUUID()).preOrder(preOrder).build());
		OrderDetail orderDetail = OrderDetail.builder().order(order).product(product)
				.quantity(orderRequest.getQuantity()).build();
		order.addDetail(orderDetail);
		orderRepository.save(order);
		return order;
	}

	private Optional<Order> queryOrder(PreOrder preOrder) {
		return orderRepository.findByPreOrderId(preOrder.getId());
	}

	private Product queryProduct(OrderRequest orderRequest) {
		Product product = productRepository.findById(orderRequest.getIdProduct()).orElseThrow(
				() -> new ResourceNotFoundException(Constants.PRODUCT, Constants.ID, orderRequest.getIdProduct()));
		return product;
	}

	private PreOrder queryPreOrder(OrderRequest orderRequest) {
		PreOrder preOrder = preOrderRepository.findById(orderRequest.getIdPreOrder()).orElseThrow(
				() -> new ResourceNotFoundException(Constants.PRE_ORDER, Constants.ID, orderRequest.getIdPreOrder()));
		return preOrder;
	}

}
