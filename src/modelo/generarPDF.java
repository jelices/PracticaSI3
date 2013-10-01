package modelo;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class generarPDF {

	public static void generarPDF(Subvencion s, String ruta)
	{
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer=null;
		try {
			 writer=PdfWriter.getInstance(document, new FileOutputStream(ruta+"/pages/InfSub"+s.getId()+".pdf"));
		} catch (Exception e) {	e.printStackTrace();}
		document.open();
		Chapter chapter1 = new Chapter(new Paragraph(("Informacion de la subvencion "+s.getTitulo()), FontFactory.getFont(FontFactory.TIMES_BOLD)),1);
		chapter1.setNumberDepth(0);
		Paragraph titulo=new Paragraph("Titulo: ",FontFactory.getFont(FontFactory.TIMES_BOLD));
		Section section1 = chapter1.addSection(titulo);
		Paragraph tituloD=new Paragraph(s.getTitulo());
		section1.add(tituloD);
		Paragraph categoria=new Paragraph("Categoria: ",FontFactory.getFont(FontFactory.TIMES_BOLD));
		Section section2 = chapter1.addSection(categoria);
		Paragraph categoriaD=new Paragraph(s.getCategoriaString());
		section2.add(categoriaD);
		Paragraph condiciones=new Paragraph("Beneficiarios / condiciones para optar: ",FontFactory.getFont(FontFactory.TIMES_BOLD));
		Section section3 = chapter1.addSection(condiciones);
		Paragraph condicionesD=new Paragraph(s.getCondiciones());
		section3.add(condicionesD);
		Paragraph ambito=new Paragraph("Ambito geografico: ",FontFactory.getFont(FontFactory.TIMES_BOLD));
		Section section4 = chapter1.addSection(ambito);
		Paragraph ambitoD=new Paragraph(s.getAmbitoString());
		section4.add(ambitoD);
		Paragraph objeto=new Paragraph("Objeto o cauntia de la subvencion: ",FontFactory.getFont(FontFactory.TIMES_BOLD));
		Section section5 = chapter1.addSection(objeto);
		Paragraph objetoD=new Paragraph(s.getObjeto());
		section5.add(objetoD);
		if(!s.getLugarString().equals(""))
		{
			Paragraph lugar=new Paragraph("Lugar: ",FontFactory.getFont(FontFactory.TIMES_BOLD));
			Section section6 = chapter1.addSection(lugar);
			Paragraph lugarD=new Paragraph(s.getLugarString());
			section6.add(lugarD);
		}
		
		try {document.add(chapter1);} catch (DocumentException e) {	e.printStackTrace();}
		document.close();
		writer.close();
	}
	
	public static void borrarPDF(Subvencion s, String ruta)
	{
		File file=new File((ruta+"/pages/InfSub"+s.getId()+".pdf"));
		file.delete();	
	}
}
