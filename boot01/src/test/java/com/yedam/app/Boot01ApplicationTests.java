package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.aaa.service.AaaService;
import com.yedam.app.departments.mapper.DepartmentsMapper;
import com.yedam.app.departments.service.DepartmentsVO;
import com.yedam.app.emp.mapper.EmpMapper;

@SpringBootTest
class Boot01ApplicationTests {

	@Autowired
	EmpMapper empMapper;

//	@Test
//	void contextLoads() {
//		assertNotNull(empMapper);
//	}
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
//	@Test
//	void insertEmpInfo() {
//		EmpVO evo = new EmpVO();
//		evo.setEmpname("sangnamja");
//		evo.setDeptid(40);
//		evo.setSal(1001);
//		
//		int insert = empMapper.insertEmpInfo(evo);
//		//assertTrue(insert>0);
//		System.out.println(evo.getEmpid());
//		assertEquals(evo.getEmpid(), 2);
//	}
	// @Test
//	   void updateEmpInfo() {
//	      //수정 1.단건조회 => 2.업데이트
//	      //1-1) 조회 조건
//	      EmpVO empVO = new EmpVO();
//	      empVO.setEmpid(2);
//	      
//	      //1-2) 실제 조회
//	      EmpVO findVO = empMapper.selectEmpInfo(empVO);//1.여기까지 조회
//	      findVO.setEmpname("Kang");//2.여기부터 업데이트 / 가져오겠다(set)
//	      findVO.setMgr(114);
//	      
//	      //2.업데이트
//	      int result = empMapper.updateEmpInfo(findVO.getEmpid(), findVO);
//	      assertEquals(1, result);
//	   }
//	@Test
//	void delteEmpInfo() {
//		int result = empMapper.deleteEmpInfo(2);
//		assertTrue(result>0);
//	}

//	@Autowired
//	DepartmentsMapper deptMapper;
//	
//	@Test
//	void contextLoads() {
//		assertNotNull(deptMapper);
//	}
//	@Test
//	void selectDepartmetnsAll() {
//	List<DepartmentsVO> list = deptMapper.selectDepartmetnsAll();
//	for(DepartmentsVO dept : list){
//		System.out.println(dept);
//		}
//	}
//	@Test
//	void selectDeptInfo() {
//		DepartmentsVO dvo = new DepartmentsVO();
//		dvo.setDepartmentId(10);
//		
//		DepartmentsVO findDept = deptMapper.selectDepartmentsInfo(dvo);
//		System.out.println("단건조회"+findDept);
//	}
//	@Test
//	void insertDept() {
//		DepartmentsVO dvo = new DepartmentsVO();
//		dvo.setDepartmentName("sangnamja");
//		dvo.setLocationId(1800);
//		dvo.setManagerId(205);
//		int result = deptMapper.insertDept(dvo);
//		 System.err.println(result+"등록");
//	}
//	@Test
//	void updateDept() {
//		DepartmentsVO dvo = new DepartmentsVO();
//		dvo.setDepartmentName("sangnamja");
//		dvo.setLocationId(1800);
//		dvo.setManagerId(205);
//		int result = deptMapper.updateDept(270, dvo);
//		System.out.println(result+"수정");
//	}
//	@Test 
//	void deleteDept() {
//		int result = deptMapper.deleteDept(271);
//		System.out.println(result+"삭제");
//	}

	@Autowired
	AaaService aaaService;

	@Test
	public void transactional() {
		aaaService.insert();
	}
}
