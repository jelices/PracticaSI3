package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.BaseDatos;
import modelo.Subvencion;
import modelo.Usuario;
import modelo.generarPDF;
import modelo.Usuario.Privilegio;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import forms.SubvencionForm;

public class ModificarSubvencionAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		SubvencionForm forma=(SubvencionForm) form;
		HttpSession sesion=request.getSession(true);
		if((sesion.getAttribute("usuario")==null)||(((Usuario)sesion.getAttribute("usuario")).getTipoUsuario()!=Privilegio.administrador))
		{
			sesion.setAttribute("error", "Error en la sesion");
			sesion.setAttribute("atras", "cambiarSubvencion");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		if(sesion.getAttribute("subvencionAEditar")==null)
		{
			sesion.setAttribute("error", "Error en la sesion");
			sesion.setAttribute("atras", "cambiarSubvencion");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		Subvencion s=(Subvencion) sesion.getAttribute("subvencionAEditar");
		s.setTitulo(forma.getTitulo());
		s.setCategoria(forma.getCategoria());
		s.setCondiciones(forma.getCondiciones());
		s.setAmbito(forma.getAmbito());
		s.setObjeto(forma.getObjeto());
		s.setLugar(forma.getLugar());
		if(BaseDatos.modificarSubvencion(s)){
			generarPDF.borrarPDF(s, request.getSession().getServletContext().getRealPath("/"));
			generarPDF.generarPDF(s, request.getSession().getServletContext().getRealPath("/"));
			sesion.setAttribute("mensaje", "Subvencion modificada");
	    	sesion.setAttribute("principal", "exito.jsp");
	    	return mapping.findForward("success");
		}
		sesion.setAttribute("error", "Fallo al actualizar la base de datos");
		sesion.setAttribute("atras", "cambiarSubvencion");
		sesion.setAttribute("principal", "error.jsp");
		return mapping.findForward("failure");
	}
}
