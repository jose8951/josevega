package es.hubiqus.inventario.model.dao;

import java.util.List;

import es.hubiqus.inventario.model.Padre;

public interface PadreDao {
	/**
	 * Guardar un elemento
	 * @param padre elemento a guardar
	 * @throws DaoException error al guardar
	 */
	public void save(Padre padre) throws DaoException;
	
	
	/**
	 * Lista todos los elementos
	 * @return lista completa de los elementos
	 * @throws DaoException
	 */
	public List<Padre> findByNombre() throws DaoException;
	
	/**
	 * Actualizar un elemento
	 * @param padre elemento a actualizar
	 * @throws DaoException 
	 */
	public void update(Padre padre) throws DaoException;
}
