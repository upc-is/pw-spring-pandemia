package pe.edu.upc.pandemia.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.model.entity.Language;
import pe.edu.upc.pandemia.model.repository.LanguageRepository;
import pe.edu.upc.pandemia.service.crud.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;
	
	@Override
	public JpaRepository<Language, Integer> getRepository() {
		return languageRepository;
	}

}
