package es.hubiqus.inventario.model.dao;

public class DaoException extends Exception{

/**
 * Captura las Excepciones
 */
	private static final long serialVersionUID = 7535665336225804304L;

	public DaoException(Exception ex){
		super(ex);
	}

}
