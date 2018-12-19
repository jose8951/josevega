package es.hubiqus.inventario.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.service.AlumnoSvc;
import es.hubiqus.inventario.service.PadreSvc;
import es.hubiqus.inventario.service.ProfesorSvc;

/**
 * Clase para guardar los datos de los alumnos
 * @author jose vega
 */
@Controller
@RequestMapping(value = "/guardar")
public class Guardar {


	@Autowired
	private AlumnoSvc svc;

	@Autowired
	private PadreSvc pSvc;

	@Autowired
	private ProfesorSvc fSvc;

	@Autowired
	private MessageSource messages;

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
	 * @param alumno de datos
	 * @param model
	 * @return muestra un formulario en  form.jsp para entrada de datos
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String view(@ModelAttribute Alumno alumno, Model model) {
		try {
			model.addAttribute("listaPadre", pSvc.listar());
			model.addAttribute("listaProfesor", fSvc.listar());

			if (alumno.getId() == null) {
				svc.guardar(alumno);
			} else {
				svc.modificar(alumno);
			}

			return "form";
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "error";
		}
	}

	/**
	 * 
	 * @param alumno Datos de alumno
	 * @param result contiene el resultado de las validaciones
	 * @param model
	 * @param locale muestra los datos del resultado por mensaje  "msg"
	 * @return si todo esta correcto devuelve form.jsp entrada de datos
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String execute(@Valid Alumno alumno,BindingResult result, Model model, Locale locale) {
		try {
			model.addAttribute("lista", svc.listar());

			if (alumno.getId() == null) {
				svc.guardar(alumno);
			} else {
				svc.modificar(alumno);
				model.addAttribute("msg", messages.getMessage("mensaje.exito.update", null, locale));
				return "modificadoOK";
			}

			model.addAttribute("msg", messages.getMessage("mensaje.exito", null, locale));

			model.addAttribute("alumno", new Alumno());
			model.addAttribute("listaPadre", pSvc.listar());
			model.addAttribute("listaProfesor", fSvc.listar());
			return "form";
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "error";
		}
	}

}
