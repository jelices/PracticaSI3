package modelo;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class generarEmails {

	public void generarEmails(ArrayList<Usuario>usuarios, ArrayList<Subvencion>nuevasSubvenciones)
	{
		for(int i=0;i<usuarios.size();i++)
		{
			if(usuarios.get(i).getInforme().equalsIgnoreCase("si"))
			{
				ArrayList<Subvencion> sub=subvencionesUsuario(usuarios.get(i), nuevasSubvenciones);
				enviarEmail(usuarios.get(i),sub);
			}
		}
	}

	
	private void enviarEmail(Usuario usuario, ArrayList<Subvencion> sub)
	{
		if(sub.size()>0)
		{
		try 
		{
			
			Properties props = new Properties();
			
			//Propiedades para el envio con gmail
			
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "25");
			props.put("mail.debug", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			
			
			//Propiedades para localhost
			/*
			props.setProperty("mail.smtp.host", "localhost");
			props.setProperty("mail.smtp.port", "25");
			props.setProperty("mail.smtp.user", "localhost");
			props.setProperty("mail.smtp.starttls.enable", "false");
			props.setProperty("mail.smtp.auth", "false");*/

			
			Session s = Session.getInstance(props, null);
			s.setDebug(true);
			
			MimeMessage message = new MimeMessage(s);
			message.setFrom(new InternetAddress("practicasi3@gmail.com"));
			//message.setFrom(new InternetAddress("si3_144@localhost"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario.getEmail()));
			message.setSentDate( new Date() );
			message.setSubject("Informe Semanal de Subvenciones");
			if(usuario.getFormato().equals("texto"))
			{
				String mensaje="Subvenciones de esta semana \n\n\n";
				for (int i=0; i< sub.size(); i++)
				{
					mensaje+=sub.get(i).getTitulo()+"\n";
					mensaje+="Categoría: "+sub.get(i).getCategoriaString()+"\n";
					mensaje+="Beneficiarios / condiciones para optar: "+sub.get(i).getCondiciones()+"\n";
					mensaje+="Ámbito: "+sub.get(i).getAmbitoString()+"\n";
					mensaje+="Objeto o cuantía de la subvención: "+sub.get(i).getObjeto()+"\n";
					if(sub.get(i).getAmbito().equals("3")||sub.get(i).getAmbito().equals("3"))
					mensaje+="Lugar: "+sub.get(i).getLugarString()+"\n";
				}
				message.setContent(mensaje, "text/plain");
			}
			else if(usuario.getFormato().equals("html"))
			{
				String mensaje="<h2>Subvenciones de la semana</h2>";
				for (int i=0; i< sub.size(); i++)
				{
					//anadir el link al 
					mensaje+="<p><a href=\"http://129.24.31.182:8080/PracticaSi3/pages/InfSub"+sub.get(i).getId()+".pdf\">"+sub.get(i).getTitulo()+"</a><br>";
					mensaje+="Categoría: "+sub.get(i).getCategoriaString()+"<br>";
					mensaje+="Beneficiarios / condiciones para optar: "+sub.get(i).getCondiciones()+"<br>";
					mensaje+="Ámbito: "+sub.get(i).getAmbitoString()+"<br>";
					mensaje+="Objeto o cuantía de la subvención: "+sub.get(i).getObjeto()+"<br>";
					if(sub.get(i).getAmbito().equals("3")||sub.get(i).getAmbito().equals("3"))
					mensaje+="Lugar: "+sub.get(i).getLugarString()+"<br></p>";
				}
				message.setContent(mensaje, "text/html");
			}
			Transport tr = s.getTransport("smtp");
			tr.connect("smtp.gmail.com", "practicasi3@gmail.com", "sistemasinformaticos3");
			message.saveChanges();
			tr.sendMessage(message, message.getAllRecipients());
			tr.close();
			//Transport.send(message);
		} catch(Exception e){e.printStackTrace();}
		}
		
	}
	

	private ArrayList<Subvencion> subvencionesUsuario(Usuario usuario, ArrayList<Subvencion> nuevasSubvenciones) {
		ArrayList<Subvencion> sub=new ArrayList<Subvencion>();
		for(int i=0;i<nuevasSubvenciones.size();i++)
		{
			if(usuario.getCatSubvenciones().contains(nuevasSubvenciones.get(i).getCategoria()+","))
					sub.add(nuevasSubvenciones.get(i));
		}
		return sub;
	}
	
	
}

