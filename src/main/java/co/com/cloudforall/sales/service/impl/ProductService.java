package co.com.cloudforall.sales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cloudforall.sales.repository.ProductRepository;
import co.com.cloudforall.sales.repository.entity.Product;
import co.com.cloudforall.sales.service.IProductService;
import co.com.cloudforall.sales.service.domain.ProductDTO;
import co.com.cloudforall.sales.util.mapper.ProductMapper;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductMapper productMapper;

	@Override
	public ProductDTO add(ProductDTO productDTO) {
		Product product = productMapper.productDTOtoProduct(productDTO);
		Product productUpdated = productRepository.save(product);
		ProductDTO productSaved = productMapper.productToProductDTO(productUpdated);
		return productSaved;
	}

	@Override
	public List<ProductDTO> getAll() {
		List<Product> products = productRepository.findAll();
		return productMapper.productsToProductsDTO(products);
	}

}
