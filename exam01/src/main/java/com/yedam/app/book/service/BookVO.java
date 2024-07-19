package com.yedam.app.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	private Integer bookNo;    		// 도서번호
	private String bookName;   		// 도서명
	private String bookCoverimg;	// 표지
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bookDate;			// 출판일자
	private Integer bookPrice;		// 금액
	private String bookPublisher;	// 출판사
	private String bookInfo;		// 도서소개
}
