package com.springboot.web2youngpil20240220.web.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web2youngpil20240220.web.dto.TestRespDto;
import com.springboot.web2youngpil20240220.web.dto.TestRespDto.TestRespDtoBuilder;

@RestController
@RequestMapping("/api/v1") // 전체설정
public class ApiTestController {

	@GetMapping("/test")
	public String getTest() {
		return "test data";
	}
	
	
	
	//responsbody 어노테이션있을때 json 자동변형
//	@GetMapping("/userTest")
//	public TestRespDto getUserTest() {
//		return TestRespDto.builder()
//				.username("gildong")
//				.password("1234")
//				.build();
//	
//	}
	@PostMapping("/userTest")
	public TestRespDto getUserTest() {
		return TestRespDto.builder()
				.username("gildong")
				.password("1234")
				.build();
	
	}
	
//	@GetMapping("/userLogin")
//	public String getUserLogin(@RequestParam("name")String name, @RequestParam("password") int password) {
//		return name + password;
//	}
	
	/*
	 * @RequestParam -> 파람으로 값을 보낼때 매개변수에서 받는 용도
	 * @RequestParam("name") -> 키값("name")을 잡아줘야함.
	 * String name에서 name에 벨류 값이 들어옴(자료형은 @RequestParam이 잡아줌)
	 * @RequestParam, 소괄호 안에 키값 생략 가능
	 */
	
	@GetMapping("/userLogin")
	public String getUserLogin(String name,  int password) {
		return name + password;
	}
	
	
	
	 
	
	/*
	 * api/v1/userTest 겟요청을 보냄
	 * 메소드명 getUserTest
	 * return gildong/1234 인 객체 리턴
	 */
}
