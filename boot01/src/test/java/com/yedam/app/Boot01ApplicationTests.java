package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	
	@Autowired
	EmpMapper empMapper;
	
	@Test
	void contextLoads() {
		assertNotNull(empMapper);
	}
//	@Test
//	void selectEmpAll() {
//		// 전체조회
//		List<EmpVO> list = empMapper.selectEmpAll();
//		assertTrue(!list.isEmpty());	
//	}
//	@Test
//	void selectEmpInfo() {
//		EmpVO evo = new EmpVO();
//		evo.setEmpid(114);
//		
//		EmpVO fvo = empMapper.selectEmpInfo(evo);
//		assertEquals(fvo.getEmpname(),"Den");
//	}
	@Test
	void insertEmpInfo() {
		EmpVO evo = new EmpVO();
		evo.setEmpname("sangnamja");
		evo.setDeptid(40);
		evo.setSal(1001);
		
		int insert = empMapper.insertEmpInfo(evo);
		//assertTrue(insert>0);
		System.out.println(evo.getEmpid());
		assertEquals(evo.getEmpid(), 204);
	}

//	@Test
//	void delteEmpInfo() {
//		int result = empMapper.deleteEmpInfo(2);
//		assertTrue(result>0);
//	}
}
