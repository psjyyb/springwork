package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@Transactional
	@Override
	public int boardInsert(@ModelAttribute BoardVO boardVO) {
		int tResult = 0;
		int mResult = boardMapper.insertboard(boardVO);
		MultipartFile[] files = boardVO.getFiles();
		 if (files != null) {
	            for (MultipartFile file : files) {
	            	tResult +=fileInsert(file);
	                System.out.println("File Name: " + file.getOriginalFilename());
	            }
	        } else {
	            System.out.println("No files uploaded");
	        }
		return tResult+mResult;
	}
	@Override
	public int fileInsert(MultipartFile file) {
		System.out.println("files : "+file.getOriginalFilename());
		System.out.println(file.getContentType());
		return boardMapper.insertFile(file);
	}
}
