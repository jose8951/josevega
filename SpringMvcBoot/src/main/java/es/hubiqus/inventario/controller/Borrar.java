package es.hubiqus.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.service.AlumnoSvc;

/**
 * Clase para borrar datos de alumno
 * @author jose vega
 *
 */
@Controller
public class Borrar {

	@Autowired
	private AlumnoSvc svc;
	
	
	/**
	 * 
	 * @param id datos de id alumno
	 * @param model
	 * @return si todo esta correcto regresa borradoOk.jsp página confirmado borrado
	 */
	@RequestMapping(value="/borrar", method=RequestMethod.GET)
	public String borrar(@RequestParam int id, Model model) {
		try {
			Alumno a=new Alumno();
			a.setId(id);
			
			svc.eliminar(a);
			return "borradoOk";
			
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "error";
		}
		
		
	}
}
