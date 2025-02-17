package com.yedam.app.board.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardControl {
	
	private BoardService boardService;
	
	@Autowired
	public BoardControl(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/boardList")
	public String boardMain(Model model) {
		List<BoardVO> list = boardService.boardList();
		model.addAttribute("boardList",list);
		return "board/boardMain";
	}
	@GetMapping("/boardInsert")
	public String boardInsert(Model model,BoardVO boaraVO) {
		return "board/boardInsert";
	}
//	@PostMapping("/boardInsert")
//	@ResponseBody
//	public int fileInsert (@RequestPart BoardVO boardVO,@RequestPart MultipartFile[] files){
//		System.out.println("board : " + boardVO);
//		System.out.println("files : "+ files);
//
//		return 1;
//	}
	 @PostMapping("/boardInsert")
	    public String testFile(@ModelAttribute BoardVO boardVO) {
//	        System.out.println("Title: " + boardVO.getBoardTitle());
//	        System.out.println("Content: " + boardVO.getBoardContent());
//	        MultipartFile[] files = boardVO.getFiles();
//	        if (files != null) {
//	            for (MultipartFile file : files) {
//	                System.out.println("File Name: " + file.getOriginalFilename());
//	            }
//	        } else {
//	            System.out.println("No files uploaded");
//	        }
		 String url = "";
		  int result = boardService.boardInsert(boardVO);
		  if(result > 0 ) {
			  url = "redirect:/boardList";
		  }else {
			  url = "redirect:boardInsert";
		  }
		 return url;
	        
	    }
	 @GetMapping("/sign")
	    public String showSignaturePage(Model model) {
	        return "sign/sign";
	    }

	 @PostMapping("/saveSignature")
	    public String saveSignature(@RequestParam("signatureData") String signatureData, Model model) {
	        try {
	            // 이미지 데이터에서 Base64 접두사 제거
	            String base64Image = signatureData.split(",")[1];
	            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

	            // 저장할 디렉토리 경로
	            String directoryPath = "D:/upload/signatures";
	            File directory = new File(directoryPath);

	            // 디렉토리가 존재하지 않으면 생성
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }

	            // 파일 경로 설정
	            String filePath = directoryPath + "/signature.png";
	            try (OutputStream stream = new FileOutputStream(filePath)) {
	                stream.write(imageBytes);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return "redirect:/boardList";
	    }
}
