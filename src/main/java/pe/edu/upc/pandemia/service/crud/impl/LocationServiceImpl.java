package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.pandemia.model.entity.Location;
import pe.edu.upc.pandemia.model.repository.LocationRepository;
import pe.edu.upc.pandemia.service.crud.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Location> getAll() throws Exception {
		return locationRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Location> findById(Integer id) throws Exception {
		return locationRepository.findById(id);
	}

	@Transactional
	@Override
	public Location create(Location entity) throws Exception {
		return locationRepository.save(entity);
	}

	@Transactional
	@Override
	public Location update(Location entity) throws Exception {
		return locationRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		locationRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Location> findByCity(String city) throws Exception {
		return locationRepository.findByCity(city);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Location> findByStateProvince(String stateProvince) throws Exception {
		return locationRepository.findByStateProvince(stateProvince);
	}

}
