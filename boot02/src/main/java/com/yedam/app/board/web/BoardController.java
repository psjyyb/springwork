package com.yedam.app.board.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Value("${file.upload.path}") // 실행되는 시점에 환경변수에 접근하여 값을 가져온다 (운영체제에 따라 바뀌는값을 알아서 찾아 넣어준다)
	private String uploadPath;
	
	private BoardService boardService;
	
	@Autowired
	public BoardController (BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.boardList();
		model.addAttribute("boards",list);
		return "board/boardList";
		// classpath:/templates/ board/boardList .html
		// classpath: = src/main/resources		  서브픽스
	}
	
	// 단건조회 : URI - boardInfo / PARAMETER - BoardVO(QueryString)
		//          RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO boardVO, Model model) {
		BoardVO bvo = boardService.boardInfo(boardVO);
		model.addAttribute("board",bvo);
		return "board/boardInfo";
	}
	
	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO(QueryString)
	//             RETURN - 단건조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO, @RequestPart MultipartFile images) {
		if(images!=null) {
			String fileName = images.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String uniqueFileName = uuid + "_" + fileName;
			String saveName = uploadPath + File.separator + uniqueFileName;
			Path savePath = Paths.get(saveName);
			boardVO.setImage(uniqueFileName);
			try {
				images.transferTo(savePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		System.out.println(boardVO);
		int result = boardService.insertBoard(boardVO);
		return "redirect:boardInfo?boardNo=" + result;
	}

	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO(QueryString)
	//               RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdate(BoardVO boardVO,Model model) {
		BoardVO bvo = boardService.boardInfo(boardVO);
		model.addAttribute("board",bvo);
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO(JSON)
	//             RETURN - 수정결과 데이터(Map)
	@PostMapping("boardUpdate")
	@ResponseBody // AJAX
	public Map<String,Object> boardUpdate(@RequestBody BoardVO boardVO){
		System.out.println(boardVO);
		return boardService.updateBoard(boardVO);
	}

	// 삭제 - 처리 : URI - boardDelete / PARAMETER - Integer
	//             RETURN - 전체조회 다시 호출
	// @RequestParam  -> 값을 필수로 넣어야 한다.
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam Integer boardNo) {
		boardService.deleteBoard(boardNo);
		return "redirect:boardList";
	}
}
