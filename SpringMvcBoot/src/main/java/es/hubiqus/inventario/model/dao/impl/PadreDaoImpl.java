package es.hubiqus.inventario.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.inventario.model.Padre;
import es.hubiqus.inventario.model.dao.DaoException;
import es.hubiqus.inventario.model.dao.PadreDao;


@Repository
public class PadreDaoImpl implements PadreDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Padre padre) throws DaoException {

		try {
			sessionFactory.getCurrentSession().save(padre);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	@Override
	public List<Padre> findByNombre() throws DaoException {
	List<Padre> res=null;
		
		try {
			String hql="FROM Padre";
			res=sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception e) {
			throw new DaoException(e);
		}

		return res;
	}

	@Override
	public void update(Padre padre) throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(padre);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}
}
