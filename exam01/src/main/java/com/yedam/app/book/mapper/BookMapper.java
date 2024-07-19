package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;

public interface BookMapper {
	 
	// 도서목록
	public List<BookVO> selectBookList();
	
	// 도서등록
	public int insertBookInfo(BookVO bookVO);
	
	// 도서번호 조회
	public int findLastBookNo();
	
}
