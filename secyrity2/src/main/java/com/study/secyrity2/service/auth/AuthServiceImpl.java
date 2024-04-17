package com.study.secyrity2.service.auth;

import org.springframework.stereotype.Service;

import com.study.secyrity2.domain.user.UserRepository;
import com.study.secyrity2.web.dto.UsernameCheckReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	
	@Override
	public boolean checkUsername(UsernameCheckReqDto usernameCheckReqDto) throws Exception {
		return userRepository.finduserByUsername(usernameCheckReqDto.getUsername()) == null;
	}

	@Override
	public boolean signup() throws Exception {
		return false;
	}

}
