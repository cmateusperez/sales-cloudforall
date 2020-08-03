package co.com.cloudforall.sales.service;

import java.util.List;

import co.com.cloudforall.sales.service.domain.OrderRequest;
import co.com.cloudforall.sales.service.domain.OrderResponse;

public interface IOrderService {

	OrderResponse add(OrderRequest orderRequest);
	
	List<OrderResponse> getAll();

}