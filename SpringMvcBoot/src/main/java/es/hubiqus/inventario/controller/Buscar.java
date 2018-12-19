package es.hubiqus.inventario.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.inventario.service.AlumnoSvc;



/**
 * Clase para buscar los alumnos 
 * @author jose vega
 *
 */
@Controller
@RequestMapping(value = "/buscar")
public class Buscar {
	@Autowired
	private AlumnoSvc svc;

	//@Autowired
	//private PadreSvc pSvc;

	//@Autowired
	//private ProfesorSvc fSvc;

	//@Autowired
	//private MessageSource messages;
	
	
	/**
	 * metodo para dar formato a la fecha
	 * @param binder
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	/**
	 * 
	 * @param apellido busca por apellido en la tabla alumno
	 * @param model
	 * @return si todo esta correcto devuelve listauno.jsp en caso contrario muestra error
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String view(@RequestParam String apellido, Model model) {
		try {
			model.addAttribute("lista", svc.findByNombre(apellido));		
			
			return "listauno";
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "error";
		}
	}
}
