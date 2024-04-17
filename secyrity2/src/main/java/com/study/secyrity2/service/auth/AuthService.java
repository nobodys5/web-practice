package com.study.secyrity2.service.auth;

import com.study.secyrity2.web.dto.UsernameCheckReqDto;

public interface AuthService {

	public boolean checkUsername(UsernameCheckReqDto usernameCheckReqDto) throws Exception;
	public boolean signup() throws Exception;
}	
