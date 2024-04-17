package com.study.security20240312youngpil.service.auth;

import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.security20240312youngpil.domain.user.User;
import com.study.security20240312youngpil.domain.user.UserRepository;
import com.study.security20240312youngpil.web.dto.SignupReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override								//id가 들어옴
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User userEntity = null;
		try {
			System.out.println(username);
			userEntity = userRepository.findUserByUsername(username);
			System.out.println("service: " +userEntity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(username);
		}
		
		if( userEntity == null) {
			throw new UsernameNotFoundException(username + "사용자 이름은 사용할 수 없습니다.");
		}
		
//		if(!username.equals("test")) {
//			System.out.println("test");
//			throw new UsernameNotFoundException(username + "사용자 이름은 사용할 수 없습니다."); 
//		}
//		System.out.println("hi");
//		UserDetails userDetails = new UserDetails() {
//			
//			@Override
//			public boolean isEnabled() {
//				// TODO Auto-generated method stub
//				return true;
//			}
//			
//			@Override
//			public boolean isCredentialsNonExpired() {
//				// TODO Auto-generated method stub
//				return true;
//			}
//			
//			@Override
//			public boolean isAccountNonLocked() {
//				// TODO Auto-generated method stub
//				return true;
//			}
//			
//			@Override
//			public boolean isAccountNonExpired() {
//				// TODO Auto-generated method stub
//				return true;
//			}
//			
//			@Override
//			public String getUsername() {
//				// TODO Auto-generated method stub
//				return "test";
//			}
//			
//			@Override
//			public String getPassword() {
//				// TODO Auto-generated method stub
//				return new BCryptPasswordEncoder().encode("1234");
//			}
//			
//			@Override
//			public Collection<? extends GrantedAuthority> getAuthorities() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		
//		return userDetails;
		return new PrincipalDetails(userEntity);
	}

//	public boolean addUser() {
//		User user = User.builder()
//					.user_name("홍길동")
//					.user_email("honghong@gmail.com")
//					.user_id("abcd")
//					.user_password(new BCryptPasswordEncoder().encode("1234"))
//					.user_roles("ROLE_USER, ROLE_MANAGER")
//					.build();
//		
//		try {
//			userRepository.save(user);
//		} catch (Exception e) {
//			return false;
//		}
//		return true;
//	}
	
	public boolean addUser(SignupReqDto signupReqDto) throws Exception{
		return userRepository.save(signupReqDto.toEntity()) > 0;
	}
}
