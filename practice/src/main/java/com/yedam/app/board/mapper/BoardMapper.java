package com.yedam.app.board.mapper;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	
	// 게시글 목록
	List<BoardVO> selectBoardList();
	
	// 게시글 등록
	int insertboard(BoardVO boardVO);
	
	// 사진 등록
	int insertFile(MultipartFile files);
}
