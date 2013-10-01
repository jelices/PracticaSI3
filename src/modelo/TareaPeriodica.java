package modelo;

public class TareaPeriodica {
	public void hacer() {
		generarEmails g=new generarEmails();
		g.generarEmails(BaseDatos.getListaUsuarios(), BaseDatos.getListaNuevasSubvenciones());
		BaseDatos.envejecerSubvenciones();
	}

}
