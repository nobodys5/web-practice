package com.springboot.web2youngpil20240220.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMRespDto<T> {

	private int code;
	private String message;
	private T data;
	
}
