package com.yedam.app.board.service;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

public interface BoardService {
	
	// 게시글 목록
	List<BoardVO> boardList();
	
	// 게시글 등록
	int boardInsert(@ModelAttribute BoardVO boardVO);
	
	// 사진 등록
	int fileInsert(MultipartFile files);

}
