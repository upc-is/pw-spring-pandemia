package pe.edu.upc.pandemia.service.crud;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.JobHistory;
import pe.edu.upc.pandemia.model.entity.JobHistoryId;

public interface JobHistoryService extends CrudService<JobHistory, JobHistoryId> {
	List<JobHistory> findByEmployee(Employee employee) throws Exception;
}
