package pe.edu.upc.pandemia.service.crud;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Employee;

public interface EmployeeService extends CrudService<Employee, Integer> {
	List<Employee> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
	List<Employee> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName) throws Exception;
}
