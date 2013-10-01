package actions;

import modelo.BaseDatos;

import org.apache.struts.action.*;

import forms.Registro1Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Registro1Action extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		// Recuperamos la forma
		Registro1Form forma = (Registro1Form) form;
		// Obtenemos el nombre introducido por el usuario
		String nombre = forma.getNombre();
		String password =forma.getPassword();
		String password2 =forma.getPassword2();
		HttpSession sesion=request.getSession(true);
		if(BaseDatos.existeLogin(nombre))
		{
			sesion.setAttribute("error", "El usuario ya existe");
			sesion.setAttribute("atras", "nuevoUsuario");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		else if(password2.equals(password))
		{
			
			sesion.setAttribute("user", nombre);
			sesion.setAttribute("password", password);
			sesion.setAttribute("principal", "nuevoUsuario2.jsp");
			return mapping.findForward("success");
		}
		else
		{
			sesion.setAttribute("error", "Los password no coinciden");
			sesion.setAttribute("atras", "nuevoUsuario");
			String atras=null;
			
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
			
	}
}
