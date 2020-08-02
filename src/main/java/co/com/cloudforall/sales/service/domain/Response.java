package co.com.cloudforall.sales.service.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response<T> {

	@JsonProperty("statusCode")
	@JsonInclude(Include.NON_NULL)
	private int statusCode;

	@JsonProperty("statusDescription")
	@JsonInclude(Include.NON_NULL)
	private String statusDescription;

	@JsonProperty("date")
	@JsonInclude(Include.NON_NULL)
	private LocalDateTime localDate;

	@JsonProperty("payload")
	@JsonInclude(Include.NON_NULL)
	private T payload;

}