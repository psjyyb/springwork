package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class ParamController {
	// QueryString(질의 문자열) : key=value&key=value&....
	// method 상관없다(get,post)
	// content-type : application/x-www-form=urlencoded

	// QueryString => 커맨드 객체 : 클래스 타입 (EmpVO)
	@RequestMapping(path = "comobj", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		String result = "";
		result += "path : / comobj\n";
		result += "\t empid : " + empVO.getEmpid();
		result += "\t empname: " + empVO.getEmpname();
		result += "\t hiredate: " + empVO.getHiredate();
		return result;
	}

	// QueryString => @ResquestParam : 기본타입, 단일값 (String, Integer)
	@RequestMapping(path = "reqparam", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String requestParam(
			String empname, // 생략가능(값을 넘기지 않아도 된다)
			@RequestParam Integer empid, // 필수(값을 필수적으로 넘겨야 된다)
			@RequestParam(name = "message", defaultValue = "No message", required = true) String msg) {
		String result = ""; 
		result += "path : / reqparam\n";
		result += "\t empid : " + empid;
		result += "\t empname: " + empname;
		result += "\t message: " + msg;
		return result;
	}
	@RequestMapping(path={"path/{id}/{pwd}","path/{id}"})
	@ResponseBody
	public String pathVariable(@PathVariable String id,
								@PathVariable(name ="pwd",required=false)String password) {
		// pathVariable 기본값 설정
		if(password ==null) {
			password="1111";
		}
		String result = ""; 
		result += "path : /path/{id}/{pwd}\n";
		result += "\t id : " + id;
		result += "\t password : " + password;
		return result;
	}
	//@RequestBody : JSON 포맷, 배열 or 객체
	// Method : POST,PUT,
	// Content-type : application/json
	
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {
		String result = ""; 
		result += "path : /resbody\n";
		result += "\t empid : " + empVO.getEmpid();
		result += "\t empname : " + empVO.getEmpname();
		result += "\t hiredate : " + empVO.getHiredate();
		return result;
	}
	@PostMapping("resbodyList")
	@ResponseBody
	public String requestBodyList (@RequestBody List<EmpVO> list) {
		String result = ""; 
		result += "path : /resbodyList\n";
		for(EmpVO empVO :list) {
		result += "\t empid : " + empVO.getEmpid();
		result += "\t empname : " + empVO.getEmpname();
		result += "\t hiredate : " + empVO.getHiredate();
		result +="\n";
		}
		return result;
	}
}
