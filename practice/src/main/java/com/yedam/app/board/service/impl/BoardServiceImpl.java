package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper){
		this.boardMapper = boardMapper;
	}

	@Override
	public List<BoardVO> boardList() {
		return boardMapper.selectBoardList();
	}
	@Override
	public int boardInsert(BoardVO boardVO) {
		return boardMapper.insertboard(boardVO);
	}
	@Override
	public int fileInsert(BoardVO boardVO, MultipartFile[] files) {
		System.out.println("boardVO :"+boardVO);
		System.out.println("files : "+files);
		
		return boardMapper.insertFile(boardVO,files);
	}
}
