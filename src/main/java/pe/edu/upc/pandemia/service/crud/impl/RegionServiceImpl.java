package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Transactional(readOnly = true)
	@Override
	public List<Region> getAll() throws Exception {
		return regionRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Region> findById(Integer id) throws Exception {
		return regionRepository.findById(id);
	}

	@Transactional
	@Override
	public Region create(Region entity) throws Exception {
		return regionRepository.save(entity);
	}

	@Transactional
	@Override
	public Region update(Region entity) throws Exception {
		return regionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		regionRepository.deleteById(id);
	}

}
