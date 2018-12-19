package es.hubiqus.inventario.service;

import es.hubiqus.inventario.model.Profesor;

public interface ProfesorSvc {
	/**
	 * guardar un elemento
	 * @param profesor elemento a guardar
	 * @throws SvcException error al guardar 
	 */
	public void guardar(Profesor profesor) throws SvcException;
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos 
	 * @throws SvcException
	 */
	public Iterable<Profesor> listar() throws SvcException;
	/**
	 * Actualizar un elemento
	 * @param profesor elemento a actualizar
	 * @throws SvcException
	 */
	public void modificar(Profesor profesor) throws SvcException;
}
