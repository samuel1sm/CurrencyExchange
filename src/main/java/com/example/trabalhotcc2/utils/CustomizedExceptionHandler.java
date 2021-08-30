package com.example.trabalhotcc2.utils;

import com.example.trabalhotcc2.utils.exeptions.CurrencyNotExistentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler  extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CurrencyNotExistentException.class)
	public final ResponseEntity<ExceptionResponseEntity> handleCurrencyNotExistentException(CurrencyNotExistentException ex,
																		   WebRequest request){
		ExceptionResponseEntity response = new ExceptionResponseEntity(ex.toString(), request.getDescription(false));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
