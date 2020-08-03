package co.com.cloudforall.sales.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.cloudforall.sales.service.domain.OrderRequest;
import co.com.cloudforall.sales.service.domain.OrderResponse;

public interface IOrderController {

	ResponseEntity<OrderResponse> add(OrderRequest orderRequest);
	
	ResponseEntity<List<OrderResponse>> getAll();

}