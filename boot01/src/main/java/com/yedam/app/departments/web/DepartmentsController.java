package com.yedam.app.departments.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.departments.service.DepartmentsService;
import com.yedam.app.departments.service.DepartmentsVO;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class DepartmentsController {
	@Autowired
	DepartmentsService deptService;
	
	// 전체조회
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DepartmentsVO> list = deptService.deptList();
		model.addAttribute("deptList",list);
		return "dept/list";
	}
	
	// 단건조회
	@GetMapping("deptInfo")
	public String deptInfo(DepartmentsVO deptVO, Model model) {
		System.out.println(deptVO);
		DepartmentsVO dvo = deptService.deptInfo(deptVO);
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
		int did = deptService.deptInsert(deptVO);
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
	public String deptUpdateForm(@RequestParam Integer deptid,
						Model model) {
		DepartmentsVO deptVO = new DepartmentsVO();
		deptVO.setDepartmentId(deptid);

		DepartmentsVO findVo = deptService.deptInfo(deptVO);
		model.addAttribute("deptInfo",findVo);
		
		return "dept/update";
	}
	// 수정 기능
	@PostMapping("deptUpdate")
	@ResponseBody // => AJAX 
	public Map<String, Object> deptUpdateAJAXJSON(@RequestBody DepartmentsVO deptVO){
		return deptService.deptUpdate(deptVO);
	}
	// 수정 기능
	
	// 삭제 기능
	@GetMapping("deptDelete")
	public String empDelete(DepartmentsVO deptVO) {
		deptService.deptDelte(deptVO);
		return "redirect:deptList";
	}
}
