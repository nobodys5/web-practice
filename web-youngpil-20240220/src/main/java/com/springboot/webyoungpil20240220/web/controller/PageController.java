package com.springboot.webyoungpil20240220.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

	@GetMapping("/index")
	public String index() {
		return "hello";
	}
	
	//viewResolver 안거치고 데이터를 보여줌
	@ResponseBody
	@GetMapping("api/v1/username")
	public String getUserName() {
		return "youngpil";
	}
}
