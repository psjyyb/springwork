package com.yedam.app.rent.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.rent.service.RentService;
import com.yedam.app.rent.service.RentVO;

@Controller
public class RentController {
	
	private RentService rentS;
	
	@Autowired
	public RentController(RentService rentS) {
		this.rentS = rentS;
	}
	@GetMapping("rentList")
	public String rentList(Model model) {
		List<RentVO> list = rentS.rentList();
		model.addAttribute("rents", list);
		return "book/rentList";
	}
}
