package com.study.secyrity2.domain.user;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	//2 user객체를 받기위해 변수선언 및, getuserroles 메소드 작성(role값 빼내오기위한용)
	private int user_code;
	private String user_name;
	private String user_email;
	private String user_id;
	private String user_password;
	private String user_roles;
	private String user_provider;
	private String user_profile_img;
	private String user_address;
	private String user_phone;
	private int user_gender;
	
	public List<String> getUserRoles() {
		if(user_roles == null || user_roles.isBlank()) {
			return new ArrayList<String>();
		}
		return Arrays.asList(user_roles.replaceAll(" ","").split(","));
	}
}
