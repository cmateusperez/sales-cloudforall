package co.com.cloudforall.sales.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.cloudforall.sales.service.domain.OrderRequest;
import co.com.cloudforall.sales.service.domain.OrderResponse;
import co.com.cloudforall.sales.service.domain.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface IOrderController {

	@ApiOperation(value = "Create order")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	ResponseEntity<OrderResponse> add(OrderRequest orderRequest);
	
	@ApiOperation(value = "Query order type list")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	ResponseEntity<List<OrderResponse>> getAll();

}