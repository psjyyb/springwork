package com.yedam.app.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Controller
public class BookController {
	
	private BookService bookS;
	
	@Autowired
	public BookController(BookService bookS) {
		this.bookS = bookS;
	}
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bookS.bookList();
		model.addAttribute("books",list);
		return "book/bookList";
	}
	
	@GetMapping("bookInsert")
	public String lastBookNo(Model model) {
		int lno = bookS.findLastNo();
		System.out.println(lno);
		model.addAttribute("lastNo",lno);
		return "book/bookInsert";
	}
	@PostMapping("bookInsert")
	public String inserBook(BookVO bookVO) {
		int result = bookS.insertBook(bookVO);
		
		return "redirect:bookList";
	}
}
