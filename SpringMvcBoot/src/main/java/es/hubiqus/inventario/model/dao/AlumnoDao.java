package es.hubiqus.inventario.model.dao;

import java.util.List;

import es.hubiqus.inventario.model.Alumno;


public interface AlumnoDao {
	
	/**
	 * Guardar un elemento
	 * @param alumno elemento a guardar
	 * @throws DaoException error al guardar
	 */
	public void save(Alumno alumno) throws DaoException;
	
	/**
	 * lista todos los alumnos
	 * @return devuelve la lista
	 * @throws DaoException 
	 */
	public List<Alumno> findByNombre() throws DaoException;
	
	/**
	 * Actualizar un elemento
	 * @param alumno elemento que vamos a actualizar
	 * @throws DaoException 
	 */
	public void update(Alumno alumno) throws DaoException;
	
	/**
	 * 
	 * @param id filtro por id
	 * @return devuelve un elemento por id a buscar
	 * @throws DaoException 
	 */
	public Alumno findById(int id) throws DaoException;
	
	/**
	 * Filtrado por apellido 
	 * @param apellido clave a buscar
	 * @return devuelve  una lista 
	 * @throws DaoException 
	 */
	public List<Alumno> findByNombre(String apellido) throws DaoException;
	/**
	 * Borra un elemento
	 * @param alumno a borrar por el elemento 
	 * @throws DaoException 
	 */
	public void delete(Alumno alumno) throws DaoException;
}
