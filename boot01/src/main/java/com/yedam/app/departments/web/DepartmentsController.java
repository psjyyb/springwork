package com.yedam.app.departments.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.departments.mapper.DepartmentsMapper;
import com.yedam.app.departments.service.DepartmentsVO;

@Controller
public class DepartmentsController {
	@Autowired
	DepartmentsMapper deptMapper;
	
	// 전체조회
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DepartmentsVO> list = deptMapper.selectDepartmetnsAll();
		model.addAttribute("deptList",list);
		return "dept/list";
	}
	
	// 단건조회
	@GetMapping("deptInfo")
	public String deptInfo(DepartmentsVO deptVO, Model model) {
		DepartmentsVO dvo = deptMapper.selectDepartmentsInfo(deptVO);
		model.addAttribute("deptInfo",dvo);
		return "dept/info";
	}
	
	// 등록
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	
	// 등록 기능
	@PostMapping("deptInsert")
	public String deptInsertProcess(DepartmentsVO deptVO) {
		int did = deptMapper.insertDept(deptVO);
		String url = null;
		if(did > -1) {
			url = "redirect:deptInfo?departmentId="+did;
		}else {
			url = "redirect:deptList";
		}
		return url;
	}
	// 수정 화면
	@GetMapping("deptUpdate")
	public String deptUpdateForm(DepartmentsVO deptVO) {
		return "dept/update";
	}
	// 수정 기능
	@PostMapping("deptUpdate")
	public String deptUpdateProcess(DepartmentsVO deptVO) {
		int did = deptMapper.updateDept(deptVO.getDepartmentId(), deptVO);
		String url = null;
		if(did > -1) {
			url= "redirect:deptInfo?departmentId="+did;
		}else {
			url = "redirect:deptList";
		}
		return url;
	}
	// 수정 기능
	
	// 삭제 기능
	@PostMapping("deptDelete")
	public String deptDelete(DepartmentsVO deptVO) {
		int did = deptMapper.deleteDept(deptVO.getDepartmentId());
		String url = null;
		if(did > -1) {
			url="redirect:deptList";
		}else {
			url= "redirect:deptInfo?departmentId="+did;
		}
		return url;
	}
}
