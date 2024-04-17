package com.study.security20240312youngpil.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.study.security20240312youngpil.handler.exception.CustomValidationApiException;
import com.study.security20240312youngpil.web.dto.CMRespDto;

@RestController
@ControllerAdvice//컨트롤러전체를 여기서다잡아준다.
public class RestControllerExceptionHandler {

	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<?> validationApiException(CustomValidationApiException e) {
		return ResponseEntity.badRequest().body(new CMRespDto<>(-1, e.getMessage() + "hihi", e.getErrorMap()));
	}
}
