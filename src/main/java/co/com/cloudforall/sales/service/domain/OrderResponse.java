package co.com.cloudforall.sales.service.domain;

import java.time.LocalDateTime;

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
public class OrderResponse {

	@ApiModelProperty(value = "Order id invoice")
	@JsonInclude(Include.NON_NULL)
	private String idInvoice;

	@ApiModelProperty(value = "Product delivery site")
	@JsonInclude(Include.NON_NULL)
	private String deliverySite;

	@ApiModelProperty(value = "Order preorder")
	@JsonInclude(Include.NON_NULL)
	private String totalPurchases;

	@ApiModelProperty(value = "Order date")
	@JsonInclude(Include.NON_NULL)
	private LocalDateTime date;
}
