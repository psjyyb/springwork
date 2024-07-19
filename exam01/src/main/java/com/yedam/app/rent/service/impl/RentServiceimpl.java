package com.yedam.app.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.rent.mapper.RentMapper;
import com.yedam.app.rent.service.RentService;
import com.yedam.app.rent.service.RentVO;

@Service
public class RentServiceimpl implements RentService{
	
	private RentMapper rentM;
	
	@Autowired
	public RentServiceimpl(RentMapper rentM) {
		this.rentM = rentM;
	}
	@Override
	public List<RentVO> rentList() {
		return rentM.selectRentList();
	}
}
