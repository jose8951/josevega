package es.hubiqus.inventario.service;

public class SvcException extends Exception{



	/**
     * Captura las Excepciones
	 */
	private static final long serialVersionUID = -2494654029738739441L;

	public SvcException(Exception ex){
		super(ex);
	}

}
