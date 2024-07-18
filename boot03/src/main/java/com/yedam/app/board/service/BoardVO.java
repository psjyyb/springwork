package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private Integer boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	private Date updatedate;
	private String image;
	
}
