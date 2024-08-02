package com.yedam.app.departments.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.departments.mapper.DepartmentsMapper;
import com.yedam.app.departments.service.DepartmentsService;
import com.yedam.app.departments.service.DepartmentsVO;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

	private DepartmentsMapper deptMapper;

	@Autowired
	public DepartmentsServiceImpl(DepartmentsMapper deptMapper) {
		this.deptMapper = deptMapper;
	}

	@Override
	public List<DepartmentsVO> deptList() {
		return deptMapper.selectDepartmetnsAll();
	}

	@Override
	public DepartmentsVO deptInfo(DepartmentsVO deptVO) {
		return deptMapper.selectDepartmentsInfo(deptVO);
	}

	@Override
	public int deptInsert(DepartmentsVO deptVO) {
		int result = deptMapper.insertDept(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> deptUpdate(DepartmentsVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;

		int result = deptMapper.updateDept(deptVO.getDepartmentId(), deptVO);
		if (result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		return map;
	}

	@Override
	public Map<String, Object> deptDelte(DepartmentsVO deptVO) {
		Map<String, Object> map = new HashMap<>();

		int result = deptMapper.deleteDept(deptVO.getDepartmentId());

		if (result == 1) {
		}
		map.put("deptId", deptVO.getDepartmentId());
		return map;
	}

}
