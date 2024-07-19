package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service // => @Transactional, AOP
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper){
		this.boardMapper=boardMapper;
	}
	
	@Override
	public List<BoardVO> boardList() {
		return boardMapper.selectboardAll();
	}

	@Override
	public BoardVO boardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int result = boardMapper.insertBoardInfo(boardVO);
		return result == 1 ? boardVO.getBoardNo() : -1;
	}

	@Override
	public Map<String, Object> updateBoard(BoardVO boardVO) {
		Map<String,Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = boardMapper.updateBoardInfo(boardVO);
		if(result > 0) {
			isSuccessed=true;
			
		}
		map.put("result", isSuccessed);
		map.put("target", boardVO);
		
		return map;
	}

	@Override
	public int deleteBoard(int boardNo) {
		
		return boardMapper.deleteBoardInfo(boardNo);
	}

}
