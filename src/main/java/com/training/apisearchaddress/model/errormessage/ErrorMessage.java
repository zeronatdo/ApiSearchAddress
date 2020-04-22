package com.training.apisearchaddress.model.errormessage;

import lombok.Data;

/**
 * Entity thông báo lỗi
 */
@Data
public class ErrorMessage {
	
	private int error;
	
	private String error_description;
}
