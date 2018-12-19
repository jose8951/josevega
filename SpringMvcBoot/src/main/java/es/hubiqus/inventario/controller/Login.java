package es.hubiqus.inventario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.hubiqus.inventario.model.Usuario;
import es.hubiqus.inventario.service.UsuarioSvc;
import interceptor.LoginInterceptor;

/**
 * Clase para autorizar login
 * @author jose vega
 */
@Controller
@SessionAttributes("sessionUser")
@RequestMapping(value = "/login")
public class Login {

	@Autowired
	private UsuarioSvc svc;
	
	/**
	 * 
	 * @param usuario de datos
	 * @param model
	 * @return vuelve a la pagina forlogin.jsp
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String view(@ModelAttribute Usuario usuario, Model model) {		
		return "formlogin";		
	}	
	
	/**
	 * 
	 * @param usuario de datos username y password
	 * @param result recoge los errores
	 * @param model
	 * @return si todo está bien entra en la página formlogin.jsp usuario registrado
	 */
	@RequestMapping(method=RequestMethod.POST)
	 public String execute(@Valid Usuario usuario, BindingResult result, Model model){
		
		try {
			if(result.hasErrors()) {
				return "formlogin";
			}else {
				usuario=svc.identificar(usuario);
				if(usuario==null) {
					result.reject("Error de contraseña");
					return "formlogin";
				}else {
					//Agregar el usuario a la sesión para el interceptor
					model.addAttribute(LoginInterceptor.ATT_USER, usuario);
					return "formDentro";
				}
			}
		} catch (Exception e) {
			result.reject("error incorrecta");
			return "error";
		}		
	}
}
