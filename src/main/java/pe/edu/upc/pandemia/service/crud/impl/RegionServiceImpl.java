package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.model.repository.RegionRepository;
import pe.edu.upc.pandemia.service.crud.RegionService;

// Service tipo CRUD
@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	@Override
	public JpaRepository<Region, Integer> getRepository() {
		return regionRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Region> findByName(String name) throws Exception {		
		return regionRepository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Region> findByNameStartingWith(String name) throws Exception {
		return regionRepository.findByNameStartingWith(name);
	}
	
}
