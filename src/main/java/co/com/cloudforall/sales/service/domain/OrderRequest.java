package co.com.cloudforall.sales.service.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

	@ApiModelProperty(value = "Order preorder")
	@JsonInclude(Include.NON_NULL)
	private Integer idPreOrder;

	@ApiModelProperty(value = "Order id product")
	@JsonInclude(Include.NON_NULL)
	private Integer idProduct;

	@ApiModelProperty(value = "Order id product")
	@JsonInclude(Include.NON_NULL)
	private Integer quantity;

}
