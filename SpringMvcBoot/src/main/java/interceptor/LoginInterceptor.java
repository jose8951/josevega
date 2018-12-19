package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import es.hubiqus.inventario.model.Usuario;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	
	public static final String ATT_USER = "sessionUser";
	private static final String INDEX = "index.jsp"; 
	private static final String LOGIN = "/login";
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
				
		String uri=request.getRequestURI();
		Usuario usuario=(Usuario)
				request.getSession().getAttribute(ATT_USER);
		
		
		if(usuario==null) {
			if(!uri.endsWith(INDEX) && !uri.endsWith(LOGIN)) {
				response.sendRedirect(INDEX);
				return false;
			}
		}
		return true;
		
		
	}
}
