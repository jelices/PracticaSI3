package actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.BaseDatos;
import modelo.Subvencion;
import modelo.filtroBusqueda;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import forms.BuscarForm;

public class BuscarAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		BuscarForm forma=(BuscarForm)form;
		String[] palabras=forma.getTitulo().split(",");
		HttpSession sesion=request.getSession(true);
		ArrayList<Subvencion>subvenciones=BaseDatos.busquedaSubvenciones(palabras, forma.getCategoria(), forma.getAmbito(), forma.getLugar());
		if(forma.getAmbito().equals("0"))
			filtroBusqueda.filtrar(subvenciones, forma.getLugar());
		sesion.setAttribute("busqueda", subvenciones);
		sesion.setAttribute("principal", "busqueda.jsp");
		return mapping.findForward("success");
	}
}
