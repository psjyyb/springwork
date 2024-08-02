package com.yedam.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginUserVO implements UserDetails {
	private UserVO userVO;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority(userVO.getRoleName()));
		return auths;
	}

	@Override
	public String getPassword() {

		return userVO.getPassword();
	}

	@Override
	public String getUsername() {

		return userVO.getLoginId();
	}

	@Override
	public boolean isAccountNonExpired() { // 계정만료되지않았는지

		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 계정이잠기지 않았는지

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 계정패스워드가 만료되지않았는디

		return true;
	}

	@Override
	public boolean isEnabled() { // 계정사용가능한지

		return true;
	}

}
