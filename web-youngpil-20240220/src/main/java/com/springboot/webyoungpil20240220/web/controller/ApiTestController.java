package com.springboot.webyoungpil20240220.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webyoungpil20240220.web.dto.TestRespDto;

@RestController // reponsbody와 controller 합쳐놓은것
@RequestMapping("/api/v1")//전체 설정해주는 어노테이션
public class ApiTestController {
	private String title;
	private TestRespDto TestRespDto;
	
	@GetMapping("/test")
	public String getTest() {
		return "test data";
	}
	
//	@GetMapping("/userTest")
//	public TestRespDto getUserTest() {
//		return TestRespDto;
//	}
	
//	@GetMapping("/userLogin") 
//	public String getUserLogin(@RequestParam("name") String name, @RequestParam("password") int password) {
//		return name + password;
//	}
	/*
	 * @RequestParam -> 파람으로 값을 보낼때 매개변수에서 받는 용도
	 * @RequestParam("name")->  키값("name")을 잡아줘야함.
	 * String name에서 name에 벨류 값이 들어옴(자료형은 @RequestParam이 잡아줌)
	 * @RequestParam, 소괄호 안의 키값 생략 가능
	 */
	
	@GetMapping("/userLogin")
	public String getUserLogin(String name, int password) {
		return name + password;
	}
		
}
