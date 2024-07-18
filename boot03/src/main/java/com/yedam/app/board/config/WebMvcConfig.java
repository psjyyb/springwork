package com.yedam.app.board.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Value("${file.upload.path}") // 실행되는 시점에 환경변수에 접근하여 값을 가져온다 (운영체제에 따라 바뀌는값을 알아서 찾아 넣어준다)
	private String uploadPath ; // 위에 벨류 값에 이름과 같아서 해당 필드를 찾아서 값을 넣어준다..?

	// 경로 등록
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")  //URL
		.addResourceLocations("file:///"+uploadPath,""); // 실제 경로
	}
}
