package actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.BaseDatos;
import modelo.Usuario;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import forms.EditarForm;

public class EditarUsuarioAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		EditarForm forma=(EditarForm) form;
		HttpSession sesion=request.getSession(true);
		
		if(sesion.getAttribute("listaUsuarios")==null)
		{
			sesion.setAttribute("error", "Error en la sesion");
			sesion.setAttribute("atras", "modificarUsuario");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		if(forma.getIndiceEntero()<0)
		{
			sesion.setAttribute("error", "Usuario no seleccionado");
			sesion.setAttribute("atras", "modificarUsuario");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		ArrayList<Usuario> listaUsuarios=(ArrayList<Usuario>)sesion.getAttribute("listaUsuarios");
		sesion.removeAttribute("listaUsuarios");
		Usuario u=listaUsuarios.get(forma.getIndiceEntero());
		if(forma.getAccion().equals("borrar"))
		{
			if(BaseDatos.borrarUsuario(u))
			{
				sesion.setAttribute("mensaje", "Usuario eliminado");
			    sesion.setAttribute("principal", "exito.jsp");
				return mapping.findForward("deleteSuccessful");
			}
		}
		else if(forma.getAccion().equals("editarPerfil"))
		{
			sesion.setAttribute("usuarioAEditar", u);
			sesion.setAttribute("principal", "cambiarPerfil.jsp");
			return mapping.findForward("editarPerfil");
		}
		else if(forma.getAccion().equals("cambiarInformes"))
		{
			sesion.setAttribute("usuarioAEditar", u);
			sesion.setAttribute("principal", "cambiarInformes.jsp");
			return mapping.findForward("cambiarInformes");
		}
			sesion.setAttribute("error", "Error desconocido");
			sesion.setAttribute("atras", "cambiarPerfil");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
	}
}
