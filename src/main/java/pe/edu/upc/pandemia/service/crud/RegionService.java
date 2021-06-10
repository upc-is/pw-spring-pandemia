package pe.edu.upc.pandemia.service.crud;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Region;

public interface RegionService extends CrudService<Region, Integer> {
	List<Region> findByName(String name)  throws Exception;
	List<Region> findByNameStartingWith(String name)  throws Exception;
}
