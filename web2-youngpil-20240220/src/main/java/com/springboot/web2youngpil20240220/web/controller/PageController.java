package com.springboot.web2youngpil20240220.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PageController {

	@GetMapping("/index")
	public String index() {
		return "hello";
	}
	
	@ResponseBody
	@GetMapping("api/v1/username")
	public String getUsername() {
		return "youngpil";
	}
	
}
