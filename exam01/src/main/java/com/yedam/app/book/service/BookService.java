package com.yedam.app.book.service;

import java.util.List;

public interface BookService {

	// 도서목록 
	public List<BookVO> bookList();
	
	// 도서등록
	public int insertBook(BookVO bookVO);
	
	// 도서번호 조회
	public int findLastNo();
}
