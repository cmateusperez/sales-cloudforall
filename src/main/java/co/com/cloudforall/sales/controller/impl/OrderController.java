package co.com.cloudforall.sales.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.cloudforall.sales.controller.IOrderController;
import co.com.cloudforall.sales.service.IOrderService;
import co.com.cloudforall.sales.service.domain.OrderRequest;
import co.com.cloudforall.sales.service.domain.OrderResponse;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController implements IOrderController {

	@Autowired
	IOrderService orderService;

	@Override
	@ResponseBody
	@PostMapping("/add")
	public ResponseEntity<OrderResponse> add(@RequestBody OrderRequest orderRequest) {
		OrderResponse orderResponse = orderService.add(orderRequest);
		return ResponseEntity.ok().body(orderResponse);
	}
	
	@Override
	@ResponseBody
	@PostMapping("/getAll")
	public ResponseEntity<List<OrderResponse>> getAll() {
		List<OrderResponse> orderResponses = orderService.getAll();
		return ResponseEntity.ok().body(orderResponses);
	}

}
