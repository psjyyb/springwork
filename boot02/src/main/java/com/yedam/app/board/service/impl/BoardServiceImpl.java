package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service // => @Transactional, AOP
public class BoardServiceImpl implements BoardService{
	@Value("${file.upload.path}") // 실행되는 시점에 환경변수에 접근하여 값을 가져온다 (운영체제에 따라 바뀌는값을 알아서 찾아 넣어준다)
	private String uploadPath;
	
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
	@Override
	public String uploadFile(MultipartFile file) {
		return null;
	}
}
