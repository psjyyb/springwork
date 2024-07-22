package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	
	// 게시글 목록
	List<BoardVO> selectBoardList();
}
