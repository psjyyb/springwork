package com.yedam.app.rent.service;

import lombok.Data;

@Data
public class RentVO {
	private Integer bookNo;
	private String bookName;
	private Integer rentTo;
	private Integer rentCnt;
}
