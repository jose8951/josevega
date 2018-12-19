package es.hubiqus.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.inventario.service.AlumnoSvc;


/**
 * clase que  muestra lista de alumnos para borrar
 * @author jose vega
 *
 */
@Controller
public class ListaAborrar {

	@Autowired
	private AlumnoSvc svc;
	
	
	/**
	 * 
	 * @param apellido busca por apellido para borrar
	 * @param model
	 * @return si encuentra datos los muesta en listaBorrado.jsp
	 */
	@RequestMapping(value="/listaAborrar", method=RequestMethod.GET)
	public String eliminarNombre(@RequestParam String apellido, Model model) {
		try {
			model.addAttribute("lista", svc.findByNombre(apellido));
			return "listaBorrado";
		} catch (Exception e) {
			model.addAttribute("error",e);
		}
		
		return "error";
		
	}
}
