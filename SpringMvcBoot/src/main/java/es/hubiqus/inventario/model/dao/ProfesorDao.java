package es.hubiqus.inventario.model.dao;

import java.util.List;

import es.hubiqus.inventario.model.Profesor;

public interface ProfesorDao {
	/**
	 * Guardar un elemento
	 * @param alumno elemento a guardar
	 * @throws DaoException error al guardar
	 */
	public void save(Profesor profesor) throws DaoException;
	
	/**
	 * lista todos los elementos
	 * @return lista completa de los elemeentos
	 * @throws DaoException 
	 */
	public List<Profesor> findByNombre() throws DaoException;
	
	/**
	 * Actualizar un elemento
	 * @param profesor elemento a actualizar  
	 * @throws DaoException 
	 */
	public void update(Profesor profesor) throws DaoException;
	
}
