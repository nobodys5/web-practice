package com.study.secyrity2.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.study.secyrity2.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails {
	//6 userdetails 구현 커스텀하기위한용도 serialversion 생성하고 user 객체와 user를받는 생성자생성
	private User user;
	
	private static final long serialVersionUID = 8117202200498298191L;

	
	public PrincipalDetails(User user) {
		this.user = user;
	}

	@Override//7 메소드 오버라이딩 하면 grantedauthority 권한들이 생성되고 설정값걸어준다
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//8 grantedauthority에 role값들을 반복문을통해서 리턴시켜준다
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//		List<String> rolList = user.getUserRoles();
//		
//		for(String role : rolList) {
//			GrantedAuthority atuAuthority = new GrantedAuthority() {
//				
//				@Override
//				public String getAuthority() {
//					return role;
//				}
//			};
//			grantedAuthorities.add(atuAuthority);
//		}
		
		user.getUserRoles().forEach(role -> {
			grantedAuthorities.add(() -> role);
		});
		
		return grantedAuthorities;
	}

	@Override//9 password와 id user에서 get값으로 가져와서 설정값걸어준다
	public String getPassword() {
		return user.getUser_password();
	}

	@Override
	public String getUsername() {
		return user.getUser_id();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
