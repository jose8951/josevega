package es.hubiqus.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.inventario.model.Profesor;
import es.hubiqus.inventario.model.dao.ProfesorDao;
import es.hubiqus.inventario.service.ProfesorSvc;
import es.hubiqus.inventario.service.SvcException;


@Service
@Transactional
public class ProfesorSvcImpl implements ProfesorSvc{

	
	@Autowired
	private ProfesorDao dao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Profesor profesor) throws SvcException {

		try {
			dao.save(profesor);
		} catch (Exception e) {
			throw new SvcException(e);
		}

	}

	@Override
	public Iterable<Profesor> listar() throws SvcException {
		Iterable<Profesor> res = null;
		try {
			res = dao.findByNombre();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

		return res;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Profesor profesor) throws SvcException {

		try {
				dao.update(profesor);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

	}
}
