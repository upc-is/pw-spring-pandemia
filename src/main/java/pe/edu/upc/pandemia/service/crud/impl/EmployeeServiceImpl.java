package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.repository.EmployeeRepository;
import pe.edu.upc.pandemia.service.crud.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public JpaRepository<Employee, Integer> getRepository() {
		return employeeRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employee> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		return employeeRepository.findByLastNameAndFirstName(lastName, firstName);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employee> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName)
			throws Exception {
		return employeeRepository.findByLastNameStartingWithAndFirstNameStartingWith(lastName, firstName);
	}

}
