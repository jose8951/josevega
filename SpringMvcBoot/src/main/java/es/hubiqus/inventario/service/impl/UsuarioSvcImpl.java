package es.hubiqus.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.hubiqus.inventario.model.Usuario;
import es.hubiqus.inventario.model.dao.UsuarioDao;
import es.hubiqus.inventario.service.SvcException;
import es.hubiqus.inventario.service.UsuarioSvc;



@Service
@Transactional
public class UsuarioSvcImpl implements UsuarioSvc{

	@Autowired
	private UsuarioDao dao;
	
	
	public Usuario identificar(Usuario usuario) throws SvcException {
		Usuario res=null;
		
		try {
			res=dao.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
		} catch (Exception e) {
			throw new SvcException(e);
		}
		
		return res;
	}
}
