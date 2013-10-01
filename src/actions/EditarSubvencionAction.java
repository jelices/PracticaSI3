package actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.BaseDatos;
import modelo.Subvencion;
import modelo.generarPDF;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import forms.EditarForm;

public class EditarSubvencionAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		EditarForm forma=(EditarForm) form;
		HttpSession sesion=request.getSession(true);
		
		if(sesion.getAttribute("listaSubvenciones")==null)
		{
			sesion.setAttribute("error", "Error en la sesion");
			sesion.setAttribute("atras", "modificarSubvencion");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		if(forma.getIndiceEntero()<0)
		{
			sesion.setAttribute("error", "Subvencion no seleccionada");
			sesion.setAttribute("atras", "modificarSubvencion");
			sesion.setAttribute("principal", "error.jsp");
			return mapping.findForward("failure");
		}
		ArrayList<Subvencion> listaSubvenciones=(ArrayList<Subvencion>)sesion.getAttribute("listaSubvenciones");
		sesion.removeAttribute("listaSubvenciones");
		Subvencion s=listaSubvenciones.get(forma.getIndiceEntero());
		if(forma.getAccion().equals("borrar"))
		{
			if(BaseDatos.borrarSubvencion(s))
			{
				generarPDF.borrarPDF(s, request.getSession().getServletContext().getRealPath("/"));
				sesion.setAttribute("mensaje", "Subvencion eliminada");
			    sesion.setAttribute("principal", "exito.jsp");
				return mapping.findForward("deleteSuccessful");
			}
		}
		else if(forma.getAccion().equals("modificar"))
		{
			sesion.setAttribute("subvencionAEditar", s);
			sesion.setAttribute("principal", "cambiarSubvencion.jsp");
			return mapping.findForward("modificarSubvencion");
		}
		sesion.setAttribute("error", "Error desconocido");
		sesion.setAttribute("atras", "cambiarPerfil");
		sesion.setAttribute("principal", "error.jsp");
		return mapping.findForward("failure");
	}
}
