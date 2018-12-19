package es.hubiqus.inventario.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.model.dao.AlumnoDao;
import es.hubiqus.inventario.model.dao.DaoException;


@Repository
public class AlumnoDaoImpl implements AlumnoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Alumno alumno) throws DaoException {

		try {
			sessionFactory.getCurrentSession().save(alumno);
		}catch(Exception e) {
			throw new DaoException(e);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> findByNombre() throws DaoException {
		List<Alumno> res=null;
		
		try {
			String hql="FROM Alumno";
			res=sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception e) {
			throw new DaoException(e);
		}

		return res;
	}

	@Override
	public void update(Alumno alumno) throws DaoException {
		try{
			sessionFactory.getCurrentSession().update(alumno);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

	@Override
	public Alumno findById(int id) throws DaoException {
		Alumno res=null;
		try {
			res=(Alumno) sessionFactory.getCurrentSession().get(Alumno.class, id);
		}catch(Exception e) {
			throw new DaoException(e);
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> findByNombre(String apellido) throws DaoException {
		List<Alumno> res=null;
		
		try {
			String hql="FROM Alumno a WHERE a.apellido LIKE :apellido";
			res=sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("apellido", "%" + apellido+ "%").list();
		}catch(Exception ex) {
			throw new DaoException(ex);
		}
		return res;
	}

	@Override
	public void delete(Alumno alumno) throws DaoException {
		try {
			sessionFactory.getCurrentSession().delete(alumno);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
	}
}
