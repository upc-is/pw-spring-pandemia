package pe.edu.upc.pandemia.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.pandemia.model.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
