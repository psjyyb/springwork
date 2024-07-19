package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	
	// 전체조회
	public List<BoardVO> selectboardAll();
	
	// 단건조회 : 조건 - no 
	public BoardVO selectBoardInfo(BoardVO boardVo);
	
	// 등록 : 대상 - boardNo, boardTitle, boardContent, boardWriter, regdate, image
	public int insertBoardInfo(BoardVO boardVo);
	
	// 수정 : 대상 - boardTitle, boardContent, boardWriter, updatedate, image
	public int updateBoardInfo(BoardVO boardVo);

	// 삭제 : 조건 - no 
	public int deleteBoardInfo(int boardNo);
}
