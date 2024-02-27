package com.springboot.web2youngpil20240220.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestRespDto {

	private String username;
	private String password;
	
	
}
