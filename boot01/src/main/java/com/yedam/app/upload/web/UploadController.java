package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {
	@Value("${file.upload.path}") // 실행되는 시점에 환경변수에 접근하여 값을 가져온다 (운영체제에 따라 바뀌는값을 알아서 찾아 넣어준다)
	private String uploadPath = "D:/upload";

	@GetMapping("formUpload")
	public void formUploadPage() {

	}

	@PostMapping("uploadForm") // 중요!! 변수명(images)은 form의 name 속성을 따라가야한다.
	public String formUploadFile(@RequestPart MultipartFile[] images) {
		for (MultipartFile image : images) {
			log.warn(image.getContentType());
			log.warn(image.getOriginalFilename());
			log.warn(String.valueOf(image.getSize()));
			// 1.원래 파일이름
			String fileName = image.getOriginalFilename();

			// 2.실제로 저장할 경로 생성 : 서버에 업로드 경로 + 파일이름
			String saveName = uploadPath + File.separator + fileName;
			log.debug("saveName : " + saveName);

			Path savePath = Paths.get(saveName);
			// separator == /

			// 3.파일 작성(파일 업로드)
			try {
				image.transferTo(savePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "formUpload";
	}
}
