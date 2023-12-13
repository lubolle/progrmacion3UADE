package DivedAndConquer;

public class OrdenadoAlfabeticamente {
	//1.	Determinar si una secuencia de n caracteres está ordenada alfabéticamente
	public boolean ordenAlfabet(String cadena) {
		
		if(cadena.length()==1)
			return true;
		
		else
			if(cadena.charAt(0)<=cadena.charAt(1))
				return ordenAlfabet(cadena.substring(1));
			else
				return false;
	}

}
