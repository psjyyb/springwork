package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	// 1. 암호화/복호화에 사용하는 Bean 등록
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 2. 인증 및 인가
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests() // security가 체크하는 경로 및 각 경로별 권한
				.antMatchers("/", "/all") // 경로에 대해서 처리하겠다
				.permitAll() // 로그인 정보가 없어도 접근이 가능하다.
				.antMatchers("/admin/**") // 경로
				.hasRole("ADMIN") // 권한 ROLE_ADMIN
				.antMatchers("/user/**") // 경로
				// .hasAuthority("ROLE_USER") // 권한
				.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN") // 나열된 권한중에 하나라도 가지고 있으면 접근이 가능해진다.
				.anyRequest() // 경로에 적힌것 뺴고 모든
				.authenticated() // 권한은 무시하고 인증만 되면 접근이 가능하다.
				.and().formLogin()
				// .defaultSuccessUrl("/boardList") 로그인이 성공하면 해당 경로로 페이지 이동
				.and().logout().logoutSuccessUrl("/"); // 로그 아웃되면 해당 경로로 페이지 이동
		//http.csrf().disable(); // csrf 비활성화 default 는 활성화
		return http.build();
	}

	/*
	 * // 테스트용 ) 메모리 인증 방식
	 * 
	 * @Bean InMemoryUserDetailsManager inMemoryUserDetailsService() { UserDetails
	 * user = User.builder() .username("user1")
	 * .password(passwordEncoder().encode("1234")) //.authorities("ROLE_USER")
	 * .roles("USER") // ROLE_USER .build(); UserDetails admin = User.builder()
	 * .username("admin1") .password(passwordEncoder().encode("1234"))
	 * //.authorities("ROLE_USER") .roles("ADMIN") // ROLE_USER .build(); return new
	 * InMemoryUserDetailsManager(user,admin); }
	 */
}
