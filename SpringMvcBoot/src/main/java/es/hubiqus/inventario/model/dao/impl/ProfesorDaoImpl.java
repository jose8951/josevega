package es.hubiqus.inventario.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.inventario.model.Profesor;
import es.hubiqus.inventario.model.dao.DaoException;
import es.hubiqus.inventario.model.dao.ProfesorDao;

@Repository
public class ProfesorDaoImpl implements ProfesorDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Profesor profesor) throws DaoException {

		try {
			sessionFactory.getCurrentSession().save(profesor);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	@Override
	public List<Profesor> findByNombre() throws DaoException {
	List<Profesor> res=null;
		
		try {
			String hql="FROM Profesor";
			res=sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception e) {
			throw new DaoException(e);
		}

		return res;
	}

	@Override
	public void update(Profesor profesor) throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(profesor);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}
}
