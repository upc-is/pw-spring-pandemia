package pe.edu.upc.pandemia.service.crud;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
	List<T> getAll() throws Exception; 	// Obtener todos los elementos
	Optional<T> findById(ID id) throws Exception; // Buscar por Id
	T create(T entity) throws Exception; // Graba el entity (Repository->BD) 
	T update(T entity) throws Exception; // Actualiza el entity (Repository->BD)
	void deleteById(ID id) throws Exception; // Elimina el entity (Repository->BD)
}
