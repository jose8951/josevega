package es.hubiqus.inventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador para el cambio de idioma,
 * simplemente redirige a página de inicio
 * @author 
 */
@Controller
public class Inicio {

	@RequestMapping(value="/inicio", method=RequestMethod.GET)
    public String execute(Model model){
		return "index";
    }

}
