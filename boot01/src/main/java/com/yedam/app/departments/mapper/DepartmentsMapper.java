package com.yedam.app.departments.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.departments.service.DepartmentsVO;

public interface DepartmentsMapper {
	// 전체조회
	public List<DepartmentsVO> selectDepartmetnsAll();
	// 단건조회
	public DepartmentsVO selectDepartmentsInfo(DepartmentsVO dvo);
	// 등록
	public int insertDept(DepartmentsVO dvo);
	// 수정
	public int updateDept(@Param("id")int deptId ,@Param("dept") DepartmentsVO dvo);
	// 삭제
	public int deleteDept(int deptId);
}
