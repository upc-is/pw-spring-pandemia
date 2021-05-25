package pe.edu.upc.pandemia.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.pandemia.model.entity.Department;
import pe.edu.upc.pandemia.model.repository.DepartmentRepository;
import pe.edu.upc.pandemia.service.crud.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public JpaRepository<Department, Integer> getRepository() {
		return departmentRepository;
	}

}
