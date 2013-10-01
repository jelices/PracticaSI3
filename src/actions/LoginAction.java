package actions;

import modelo.BaseDatos;
import modelo.Usuario;
import modelo.Usuario.Privilegio;

import org.apache.struts.action.*;

import forms.LoginForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		Usuario user;
		// Recuperamos la forma
		LoginForm formL = (LoginForm) form;
		// Obtenemos el nombre introducido por el usuario
		String nombre = formL.getNombre();
		String password = formL.getPassword();
		HttpSession sesion= request.getSession(true);
		// Hacemos una instancia del modelo
		user=BaseDatos.comprobarLogin(nombre, password);
		if(user.getTipoUsuario()!=Privilegio.visitante)
		{
			sesion.setAttribute("usuario", user);
			return mapping.findForward("success");
		}
		else
		{
			sesion.setAttribute("usuario", user);
			sesion.setAttribute("error", "El usuario no existe");
			sesion.setAttribute("atras", "home");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
	}
}
