package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService {
	
	// 전체조회
	public List<BoardVO>boardList();
	
	// 단건조회
	public BoardVO boardInfo(BoardVO boardVO);
	// 등록
	public int insertBoard(BoardVO boardVO);
	// 수정 
	public Map<String,Object> updateBoard(BoardVO boardVO);
	// 삭제
	public int deleteBoard(int boardNo);
	
	public String uploadFile(MultipartFile file);
	}
