package co.com.cloudforall.sales.service;

import java.util.List;

import co.com.cloudforall.sales.service.domain.ProductDTO;

public interface IProductService {

	ProductDTO add(ProductDTO productDTO);

	List<ProductDTO> getAll();

}