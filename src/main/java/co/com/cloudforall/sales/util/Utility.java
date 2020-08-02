package co.com.cloudforall.sales.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import co.com.cloudforall.sales.service.domain.Response;

public class Utility {
	
	public static <T> Response<T> buildResponse(T payload) {
		int statusCode;
		String statusDesc = null;
		if (payload == null) {
			statusCode = HttpStatus.NO_CONTENT.value();
			statusDesc = HttpStatus.NO_CONTENT.getReasonPhrase();
		} else {
			statusCode = HttpStatus.OK.value();
			statusDesc = HttpStatus.OK.getReasonPhrase();
		}
		return new Response<T>(statusCode, statusDesc, LocalDateTime.now(), payload);
	}

}
