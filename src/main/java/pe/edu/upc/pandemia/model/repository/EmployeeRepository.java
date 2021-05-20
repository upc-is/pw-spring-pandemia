package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByLastNameAndFirstName(String lastName, String firstName);
	
	// JPQL
	@Query("SELECT e FROM Employee e WHERE UPPER(e.lastName) LIKE CONCAT(UPPER(:lastName),'%') AND UPPER(e.firstName) LIKE CONCAT(UPPER(:firstName),'%') ")
	List<Employee> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName);
}
