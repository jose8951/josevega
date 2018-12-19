package es.hubiqus.inventario.model.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.inventario.model.Usuario;
import es.hubiqus.inventario.model.dao.DaoException;
import es.hubiqus.inventario.model.dao.UsuarioDao;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Usuario findByUsernameAndPassword(String username, String password) throws DaoException {
		Usuario res=null;
		
		try {
			String hql = "FROM Usuario u WHERE u.username  =:username AND u.password  =:password";
			res = (Usuario) sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("username", username).setParameter("password", password).uniqueResult();
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
		return res;
	}

}
