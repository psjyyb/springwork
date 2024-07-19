package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService{
	
	private BookMapper bookM;
	
	@Autowired
	public BookServiceImpl(BookMapper bookMapper) {
		this.bookM = bookMapper;
	}
	
	@Override
	public List<BookVO> bookList() {
		return bookM.selectBookList();
	}
	
	@Override
	public int insertBook(BookVO bookVO) {
		int result = bookM.insertBookInfo(bookVO);
		return result == 1 ? bookVO.getBookNo() : -1;
	}
	@Override
	public int findLastNo() {
		return bookM.findLastBookNo();
	}

}
