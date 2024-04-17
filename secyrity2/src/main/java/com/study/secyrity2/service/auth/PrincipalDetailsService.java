package com.study.secyrity2.service.auth;

import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.secyrity2.domain.user.User;
import com.study.secyrity2.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
	//3 userrepository 객체 생성 -> 4 user.xml 작성
	private final UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = null;
		try {//10 userrepository에 로그인메소드에 던져준다
			userRepository.finduserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(username);
		}
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(username + "사용자 이름은 사용할 수 없습니다.");
		}
		
		//5 principaldetails 커스텀을 위해 주석처리
//		if(!username.equals("test")) {
//			throw new UsernameNotFoundException(username);
//		}
		
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
		return new PrincipalDetails(userEntity);//11 커스텀한 디테일스리턴 받는다(userentity는 예외처리 던지기용)
	}

	public boolean addUser() {//12 adduser에 빌더로 값들을 받아와서 repository 회원가입메소드에 던진다.
		User user = User.builder()
					.user_name("홍길동")
					.user_email("honghong@gmail.com")
					.user_id("abcd")
					.user_password(new BCryptPasswordEncoder().encode("1234"))
					.user_roles("ROLE_USER, ROLE_MANAGER")
					.build();
		try {
			userRepository.save(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
