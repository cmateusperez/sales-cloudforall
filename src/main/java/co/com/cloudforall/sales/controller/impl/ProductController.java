package co.com.cloudforall.sales.controller.impl;

import static co.com.cloudforall.sales.util.Utility.buildResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.cloudforall.sales.controller.IProductController;
import co.com.cloudforall.sales.service.IProductService;
import co.com.cloudforall.sales.service.domain.ProductDTO;
import co.com.cloudforall.sales.service.domain.Response;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductController implements IProductController {

	@Autowired
	IProductService productService;

	@Override
	@ResponseBody
	@PostMapping("/add")
	public ResponseEntity<Response<ProductDTO>> add(@RequestBody ProductDTO productDTODetail) {
		ProductDTO productDTO = productService.add(productDTODetail);
		Response<ProductDTO> response = buildResponse(productDTO);
		return ResponseEntity.ok().body(response);
	}

	@Override
	@ResponseBody
	@GetMapping("/getAll")
	public ResponseEntity<List<ProductDTO>> getAll() {
		List<ProductDTO> response = productService.getAll();
		return ResponseEntity.ok().body(response);
	}

}
