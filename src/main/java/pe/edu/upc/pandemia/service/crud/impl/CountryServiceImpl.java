package pe.edu.upc.pandemia.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.pandemia.model.entity.Country;
import pe.edu.upc.pandemia.model.repository.CountryRepository;
import pe.edu.upc.pandemia.service.crud.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Country> getAll() throws Exception {
		return countryRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Country> findById(String id) throws Exception {
		return countryRepository.findById(id);
	}

	@Transactional
	@Override
	public Country create(Country entity) throws Exception {
		return countryRepository.save(entity);
	}

	@Transactional
	@Override
	public Country update(Country entity) throws Exception {
		return countryRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(String id) throws Exception {
		countryRepository.deleteById(id);		
	}

}
