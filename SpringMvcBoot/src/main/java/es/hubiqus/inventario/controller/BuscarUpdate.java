package es.hubiqus.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.inventario.service.AlumnoSvc;
import es.hubiqus.inventario.service.PadreSvc;
import es.hubiqus.inventario.service.ProfesorSvc;

/**
 * Clase para actualizar los datos de la tabla alumno
 * @author jose vega
 */
@Controller
public class BuscarUpdate {
	@Autowired
	private AlumnoSvc svc;
	
	@Autowired
	private PadreSvc pSvc;
	
	@Autowired
	private ProfesorSvc fSvc;
	
	/**
	 * 
	 * @param id parámetro para realizar la búsqueda
	 * @param model
	 * @return si todo es correcto va a la página mostrarUpdate.jsp y muestra los datos
	 */
	@RequestMapping(value="/buscarUpdate", method=RequestMethod.GET)
	public String execute(@RequestParam int id, Model model) {
		try {
			model.addAttribute("alumno", svc.buscar(id));
			model.addAttribute("listap", pSvc.listar());
			model.addAttribute("listaf", fSvc.listar());
			
			return "mostrarUpdate";
		}catch(Exception e){
			model.addAttribute("error",e);
			return "error";
		}
		
		
		
	}
}
