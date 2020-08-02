package co.com.cloudforall.sales.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.com.cloudforall.sales.service.domain.ProductDTO;
import co.com.cloudforall.sales.service.domain.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface IProductController {

	@ApiOperation(value = "Create credit card")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	ResponseEntity<Response<ProductDTO>> add(ProductDTO productDTO);

	@ApiOperation(value = "Query product type list")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Not content", response = Response.class),
			@ApiResponse(code = 206, message = "Bussines error", response = Response.class),
			@ApiResponse(code = 400, message = "Bad request", response = Response.class),
			@ApiResponse(code = 404, message = "Not found", response = Response.class),
			@ApiResponse(code = 500, message = "Internal server error", response = Response.class) })
	ResponseEntity<Response<List<ProductDTO>>> getAll();

}