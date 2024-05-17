		package com.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//
//		Map<String, Object> errorsMap = new HashMap<>();
//
//		ex.getBindingResult().getFieldErrors().forEach(f -> errorsMap.put(f.getField(), f.getDefaultMessage() +" naveen"));
//		return new ResponseEntity<Object>(errorsMap, HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleStudentNotFoundException(RuntimeException exception) {
//	        return ResponseEntity
//	                .status(HttpStatus.OK)
//	                .body(exception.getMessage());
		return new ResponseEntity<Object>("okok", HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public void handleException() {

		System.out.println("Exception handler");

	}
}
