package com.yedam.app.board.service;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Integer boardNo;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private Integer fileNo;
	private String fileName;
	private String fileOriginalName;
	private Integer tableNo;
	private Integer fileTurn;
}
