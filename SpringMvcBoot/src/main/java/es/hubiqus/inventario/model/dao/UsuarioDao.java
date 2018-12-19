package es.hubiqus.inventario.model.dao;

import es.hubiqus.inventario.model.Usuario;

public interface UsuarioDao {
	
	/**
	 * Filta por username y password
	 * @param username elemento a buscar
	 * @param password elemento a buscar
	 * @return devuelve elemento en caso contrario null
	 * @throws DaoException
	 */
	public Usuario findByUsernameAndPassword(String username, String password) throws DaoException;
}
