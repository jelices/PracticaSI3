package actions;

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
import org.apache.struts.chain.contexts.ServletActionContext;

import forms.SubvencionForm;

public class NuevaSubvencionAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession sesion=request.getSession(true);
		SubvencionForm forma=(SubvencionForm) form;
		Subvencion sub = new Subvencion(forma.getTitulo(), forma.getCategoria(), forma.getCondiciones(), forma.getAmbito(), forma.getObjeto(), forma.getLugar());
		if(BaseDatos.guardarSubvencion(sub))
		{
			generarPDF.generarPDF(sub, request.getSession().getServletContext().getRealPath("/"));
			sesion.setAttribute("mensaje", "Subvencion creada");
	    	sesion.setAttribute("principal", "exito.jsp");
	    	return mapping.findForward("success");
		}
		sesion.setAttribute("error", "Error al guardar en la base de datos");
    	sesion.setAttribute("atras", "nuevaSubvencion.jsp");
    	sesion.setAttribute("principal", "error.jsp");
    	return mapping.findForward("failure");
	}
}
