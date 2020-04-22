package com.training.apisearchaddress.utils;

import com.training.apisearchaddress.model.errormessage.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

/**
 * Class điều khiển hiển thị thông báo lỗi
 */
@RestControllerAdvice
public class Common {
	
	/**
	 * Method xử lý IndexOutOfBoundsException, NoHandlerFoundException
	 *
	 * @return thông báo lỗi
	 */
	@ExceptionHandler({
		IndexOutOfBoundsException.class,
		NoHandlerFoundException.class
	})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage showError404() {
		//Tạo thông báo lỗi rồi trả về
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setError(404);
		errorMessage.setError_description("Cố gắng thao tác một tài nguyên không tồn tại.");
		return errorMessage;
	}
	
	/**
	 * Method xử lý các Exception khác
	 *
	 * @return thông báo lỗi
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage showError500() {
		//Tạo thông báo lỗi rồi trả về
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setError(500);
		errorMessage.setError_description("Một lỗi xảy ra ở phía máy chủ.");
		return errorMessage;
	}
	
	/**
	 * Method xử lý ConstraintViolationException
	 *
	 * @return thông báo lỗi
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage showError400() {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setError(400);
		errorMessage
			.setError_description("Thiếu thông số bắt buộc, giá trị không hợp lệ hoặc request không đúng định dạng.");
		return errorMessage;
	}
}
