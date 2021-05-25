package pe.edu.upc.pandemia.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.model.entity.Country;
import pe.edu.upc.pandemia.model.repository.CountryRepository;
import pe.edu.upc.pandemia.service.crud.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public JpaRepository<Country, String> getRepository() {
		return countryRepository;
	}
}
