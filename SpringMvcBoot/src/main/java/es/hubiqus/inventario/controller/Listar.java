package es.hubiqus.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.service.AlumnoSvc;

/**
 * Clase que muestra un listado de la tabla alumno
 * @author jose vega
 *
 */
@Controller
public class Listar {

	@Autowired
	private AlumnoSvc svc;	
	
	/**
	 * 
	 * @param model
	 * @return cuando encuentra la tabla la muestra en mostrarLista.jsp
	 */
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	 public String execute(Model model){
    	try {
    		
			model.addAttribute("lista", svc.listar());			
		
			return "mostrarLista";
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "error";
		}
    }
	
}
