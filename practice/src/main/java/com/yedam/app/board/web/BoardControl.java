package com.yedam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardControl {
	
	private BoardService boardService;
	
	@Autowired
	public BoardControl(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/")
	public String boardMain(Model model) {
		List<BoardVO> list = boardService.boardList();
		model.addAttribute("boardList",list);
		return "board/boardMain";
	}
	@GetMapping("/boardInsert")
	public String boardInsert(Model model,BoardVO boaraVO) {
		return "board/boardInsert";
	}
}
