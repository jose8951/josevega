package es.hubiqus.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.inventario.service.AlumnoSvc;

/**
 * Clase para mostrar una lista a actualizar
 * @author jose vega
 *
 */
@Controller
public class ListaUpdate {

	@Autowired
	private AlumnoSvc svc;
	
	
	/**
	 * 
	 * @param apellido parametro para buscar en la tabla
	 * @param model
	 * @return si lo encuentra por apellido va a la página listaUpdate.jsp y muestra el alumnos a modificar
	 */
	@RequestMapping(value="/listaUpdate", method=RequestMethod.GET)
	public String updateAlumno(@RequestParam String apellido, Model model) {
		try {
			model.addAttribute("lista", svc.findByNombre(apellido));
			return "listaUpdate";
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "error";
		}	
		
	}
}
