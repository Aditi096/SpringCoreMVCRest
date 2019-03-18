package com.cg.product.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.product.exceptions.ProductNotFoundException;
import com.cg.product.responses.CustomResponse;


@ControllerAdvice
public class ProductExceptionAspect {
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<CustomResponse> handleProductExceptionAspect(Exception e) {
		CustomResponse response= new CustomResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
}
