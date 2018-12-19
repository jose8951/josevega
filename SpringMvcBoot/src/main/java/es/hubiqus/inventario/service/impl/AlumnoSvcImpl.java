package es.hubiqus.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.model.dao.AlumnoDao;
import es.hubiqus.inventario.service.AlumnoSvc;
import es.hubiqus.inventario.service.SvcException;

@Service
@Transactional
public class AlumnoSvcImpl implements AlumnoSvc{


	@Autowired
	private AlumnoDao dao;

	@Transactional (propagation =Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void guardar(Alumno alumno) throws SvcException {
		try {
			dao.save(alumno);
		}catch(Exception e) {
			throw new SvcException(e);
		}	
	}

	@Override
	public Iterable<Alumno> listar() throws SvcException {
		Iterable<Alumno> res=null;
		try {
			res=dao.findByNombre();
		} catch (Exception e) {
			throw new SvcException(e);
		}
		
		return res;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Alumno alumno) throws SvcException {
		try {
			dao.update(alumno);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
	}

	@Override
	public Alumno buscar(int id) throws SvcException {
		Alumno res = null;
		try {
			res=dao.findById(id);
		}catch(Exception e) {
			throw new SvcException(e);
		}
		return res;
	}

	@Override
	public Iterable<Alumno> findByNombre(String apellido) throws SvcException {
		
		Iterable<Alumno> res = null;
		
		try{
			res = dao.findByNombre(apellido);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void eliminar(Alumno alumno) throws SvcException {
		try {
			alumno =buscar(alumno.getId());
			dao.delete(alumno);
		}catch(Exception ex){
			throw new SvcException(ex);
		}
		
	}
}
