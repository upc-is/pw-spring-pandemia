package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.pandemia.model.entity.Location;
import pe.edu.upc.pandemia.model.repository.LocationRepository;
import pe.edu.upc.pandemia.service.crud.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public JpaRepository<Location, Integer> getRepository() {
		return locationRepository;
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
