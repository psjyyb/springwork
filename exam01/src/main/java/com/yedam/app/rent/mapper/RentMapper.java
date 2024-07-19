package com.yedam.app.rent.mapper;

import java.util.List;

import com.yedam.app.rent.service.RentVO;

public interface RentMapper {
	
	// 대여현황
	public List<RentVO> selectRentList();	
}
