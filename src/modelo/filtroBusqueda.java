package modelo;

import java.util.ArrayList;

public class filtroBusqueda {

	public static void filtrar(ArrayList<Subvencion> subvenciones, String provincia) 
	{
		ArrayList<Subvencion> aEliminar=new ArrayList<Subvencion>();
		for(int i=0; i<subvenciones.size(); i++)
		{
			if((subvenciones.get(i).getAmbito().equals("4"))&&!(subvenciones.get(i).getLugar().equals(provincia)))
				aEliminar.add(subvenciones.get(i));
			if((subvenciones.get(i).getAmbito().equals("3"))&&!(estaEnComunidad(subvenciones.get(i).getLugar(), provincia)))
				aEliminar.add(subvenciones.get(i));
		}
		subvenciones.removeAll(aEliminar);
		
	}
	
	private static boolean estaEnComunidad(String comunidad, String provincia)
	{
		int valor= Integer.parseInt(provincia);
		boolean vuelta=false;
		switch(valor)
		{

			case 1: vuelta=(comunidad.equals("17")?  true :  false); break;
			case 2: vuelta=(comunidad.equals("6")?  true :  false); break;
			case 3: vuelta=(comunidad.equals("10")?  true :  false); break;
			case 4: vuelta=(comunidad.equals("1")?  true :  false); break; 
			case 5: vuelta=(comunidad.equals("18")?  true :  false); break; 
			case 6: vuelta=(comunidad.equals("5")?  true :  false); break;
			case 7: vuelta=(comunidad.equals("11")?  true :  false); break;
			case 8: vuelta=(comunidad.equals("13")?  true :  false); break; 
			case 9: vuelta=(comunidad.equals("7")?  true :  false); break;
			case 10: vuelta=(comunidad.equals("5")?  true :  false); break;
			case 11: vuelta=(comunidad.equals("11")?  true :  false); break;
			case 12: vuelta=(comunidad.equals("1")?  true :  false); break;
			case 13: vuelta=(comunidad.equals("4")?  true :  false); break;
			case 14: vuelta=(comunidad.equals("10")?  true :  false); break;
			case 15: vuelta=(comunidad.equals("8")?  true :  false); break;
			case 16: vuelta=(comunidad.equals("6")?  true :  false); break;
			case 17: vuelta=(comunidad.equals("1")?  true :  false); break;
			case 18: vuelta=(comunidad.equals("6")?  true :  false); break;
			case 19: vuelta=(comunidad.equals("7")?  true :  false); break;
			case 20: vuelta=(comunidad.equals("1")?  true :  false); break;
			case 21: vuelta=(comunidad.equals("6")?  true :  false); break;
			case 22: vuelta=(comunidad.equals("17")?  true :  false); break;
			case 23: vuelta=(comunidad.equals("1")?  true :  false); break;
			case 24: vuelta=(comunidad.equals("2")?  true :  false); break;
			case 25: vuelta=(comunidad.equals("1")?  true :  false); break;
			case 26: vuelta=(comunidad.equals("12")?  true :  false); break;
			case 27: vuelta=(comunidad.equals("14")?  true :  false); break;
			case 28: vuelta=(comunidad.equals("3")?  true :  false); break;
			case 29: vuelta=(comunidad.equals("5")?  true :  false); break;
			case 30: vuelta=(comunidad.equals("7")?  true :  false); break; 
			case 31: vuelta=(comunidad.equals("12")?  true :  false); break;
			case 32: vuelta=(comunidad.equals("9")?  true :  false); break;
			case 33: vuelta=(comunidad.equals("1")?  true :  false); break;
			case 34: vuelta=(comunidad.equals("15")?  true :  false); break;
			case 35: vuelta=(comunidad.equals("19")?  true :  false); break;
			case 36: vuelta=(comunidad.equals("16")?  true :  false); break;
			case 37: vuelta=(comunidad.equals("12")?  true :  false); break;
			case 38: vuelta=(comunidad.equals("5")?  true :  false); break;
			case 39: vuelta=(comunidad.equals("12")?  true :  false); break;
			case 40: vuelta=(comunidad.equals("5")?  true :  false); break;
			case 41: vuelta=(comunidad.equals("5")?  true :  false); break;
			case 42: vuelta=(comunidad.equals("1")?  true :  false); break; 
			case 43: vuelta=(comunidad.equals("5")?  true :  false); break;
			case 44: vuelta=(comunidad.equals("7")?  true :  false); break;
			case 45: vuelta=(comunidad.equals("3")?  true :  false); break;
			case 46: vuelta=(comunidad.equals("2")?  true :  false); break;
			case 47: vuelta=(comunidad.equals("6")?  true :  false); break;
			case 48: vuelta=(comunidad.equals("10")?  true :  false); break;
			case 49: vuelta=(comunidad.equals("5")?  true :  false); break;
			case 50: vuelta=(comunidad.equals("17")?  true :  false); break;
			case 51: vuelta=(comunidad.equals("5")?  true :  false); break;
			case 52: vuelta=(comunidad.equals("2")?  true :  false); break;
		}
		return vuelta;
	}

}
