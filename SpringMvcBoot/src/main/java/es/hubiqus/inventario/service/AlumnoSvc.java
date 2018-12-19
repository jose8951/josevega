package es.hubiqus.inventario.service;

import es.hubiqus.inventario.model.Alumno;

public interface AlumnoSvc {
	/**
	 * Guardar un elemento	 
	 * @param alumno a guardar
	 * @throws SvcException error al guardar
	 */
	public void guardar(Alumno alumno) throws SvcException;

	/**
	 * lista de todos los elementos	  
	 * @return lista completa de los elementos
	 * @throws SvcException
	 */
	public Iterable<Alumno> listar() throws SvcException;

	/**
	 * actualizar un elemento	 
	 * @param alumno elemento a actualizar
	 * @throws SvcException
	 */
	public void modificar(Alumno alumno) throws SvcException;

	/**
	 * filtrado por id 
	 * @param id clave a buscar
	 * @return alumno encontrado en caso contrario null
	 * @throws SvcException
	 */
	public Alumno buscar(int id) throws SvcException;

	/**
	 * Filtrado por apellido
	 * @param apellido clave a filtrar
	 * @return lista del resultado filtrado por apellido
	 * @throws SvcException
	 */
	public Iterable<Alumno> findByNombre(String apellido) throws SvcException;
	/**
	 * Borrado por elemento
	 * @param alumno clave  a filtrar
	 * @throws SvcException
	 */
	public void eliminar(Alumno alumno) throws SvcException;
}
