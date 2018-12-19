package es.hubiqus.inventario.service;

import es.hubiqus.inventario.model.Usuario;

public interface UsuarioSvc {
	/**
	 * Filtar por usuario
	 * @param usuario elemento a filtrar
	 * @return usario encontrado si no lo encuentra null
	 * @throws SvcException
	 */
	public Usuario identificar(Usuario usuario)throws SvcException;
}
