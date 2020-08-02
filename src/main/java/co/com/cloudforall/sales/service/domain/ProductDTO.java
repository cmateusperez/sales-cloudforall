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
public class ProductDTO {

	@ApiModelProperty(value = "Product id")
	@JsonInclude(Include.NON_NULL)
	private Integer id;

	@ApiModelProperty(value = "Product name")
	@JsonInclude(Include.NON_NULL)
	private String name;

	@ApiModelProperty(value = "Product description")
	@JsonInclude(Include.NON_NULL)
	private String description;

}
