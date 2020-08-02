package co.com.cloudforall.sales.util.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.com.cloudforall.sales.repository.entity.Product;
import co.com.cloudforall.sales.service.domain.ProductDTO;

@Mapper
public interface ProductMapper {

	Product productDTOtoProduct(ProductDTO productoDTO);

	ProductDTO productToProductDTO(Product product);

	List<ProductDTO> productsToProductsDTO(List<Product> products);

}
