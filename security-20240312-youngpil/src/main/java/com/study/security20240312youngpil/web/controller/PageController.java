package com.study.security20240312youngpil.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.security20240312youngpil.service.auth.PrincipalDetails;

@Controller
public class PageController {

	@GetMapping({"/","/index"})				//프린시펄디테일스 가져와주는 어노테이션
	public String loadIndex(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		model.addAttribute("principal",principalDetails);
		return "index";
	}
	@GetMapping("/auth/signin")
	public String loadSignin() {
		return "auth/signin";
	}
	@GetMapping("/auth/signup")
	public String loadSignup() {
		return "auth/signup";
	}
	@GetMapping("/mypage")
	public String loadMypage() {
		return "mypage";
	}
}
