package co.com.cloudforall.sales.util.mapper;

import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import co.com.cloudforall.sales.repository.entity.Order;
import co.com.cloudforall.sales.repository.entity.OrderDetail;
import co.com.cloudforall.sales.service.domain.OrderResponse;
import co.com.cloudforall.sales.util.Constants;

@Mapper
public interface OrderMapper {

	@Mappings({ @Mapping(target = "idInvoice", source = "idInvoice", qualifiedByName = "stringToUUID"),
			@Mapping(target = "deliverySite", source = "deliverySite.name"),
			@Mapping(target = "totalPurchases", source = "orderDetails", qualifiedByName = "calculateTotalPurchases") })
	OrderResponse ordertToOrderResponse(Order order);

	List<OrderResponse> ordersToOrderResponse(List<Order> orders);

	@Named("stringToUUID")
	public static UUID stringToUUID(String input) {
		return UUID.fromString(input);
	}

	@Named("UUIDToString")
	public static String UUIDToString(UUID input) {
		return input.toString();
	}

	@Named("calculateTotalPurchases")
	public static String calculateTotalPurchases(List<OrderDetail> orderDetails) {
		Double result = orderDetails.stream().map((details) -> details.getQuantity() * details.getProduct().getPrice())
		.collect(Collectors.summingDouble(Double::doubleValue));
		return formatCurrency(result);
	}
	
	private static String formatCurrency(Double value) {
		DecimalFormat dFormat = new DecimalFormat(Constants.CURRENCY_FORMAT);
		return "$" + dFormat.format(value);
	}
}
