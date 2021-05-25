package pe.edu.upc.pandemia.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.model.entity.Job;
import pe.edu.upc.pandemia.model.repository.JobRepository;
import pe.edu.upc.pandemia.service.crud.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;
	
	@Override
	public JpaRepository<Job, String> getRepository() {
		return jobRepository;
	}

}
