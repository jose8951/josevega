package es.hubiqus.inventario.service;

import es.hubiqus.inventario.model.Padre;

public interface PadreSvc {
	/**
	 * guardar un elemento
	 * @param padre elemento a guardar
	 * @throws SvcException error al guardar
	 */
	public void guardar(Padre padre) throws SvcException;
	/**
	 * listar todos los elementos
	 * @return lista completa de los elementos
	 * @throws SvcException
	 */
	public Iterable<Padre> listar() throws SvcException;
	
	/**
	 *  Actualizar un elemento
	 * @param padre elemento a actualizar
	 * @throws SvcException
	 */
	public void modificar(Padre padre) throws SvcException;
}
