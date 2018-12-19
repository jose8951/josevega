package es.hubiqus.inventario.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.hubiqus.inventario.model.Padre;
import es.hubiqus.inventario.model.dao.PadreDao;
import es.hubiqus.inventario.service.PadreSvc;
import es.hubiqus.inventario.service.SvcException;

@Service
@Transactional
public class PadreSvcImpl implements PadreSvc{

	@Autowired
	private PadreDao dao;
	
	@Transactional (propagation =Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void guardar(Padre padre) throws SvcException {
		try {
			dao.save(padre);
		}catch(Exception e) {
			throw new SvcException(e);
		}
		
	}

	@Override
	public Iterable<Padre> listar() throws SvcException {
		Iterable<Padre> res=null;
		try {
			res=dao.findByNombre();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		
		return res;
	}

	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Padre padre) throws SvcException {
		try {
			dao.update(padre);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		
	}
}
