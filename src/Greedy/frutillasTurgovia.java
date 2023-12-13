package Greedy;

public class frutillasTurgovia {
	
	public String contarMonedas(int aPagar, int[] monedas) {
		int pagado = 0;
		int cantMonedas = 0;
		int i = 0;
		String combMonedas = " ";
		
		while((pagado<aPagar) && (i<=monedas.length-1)) {
			
			if(pagado + monedas[i]<=aPagar) {
				pagado += monedas[i];
				cantMonedas ++;
				String cambio = " 1 monedas de " + monedas[i] + " + ";
				combMonedas += cambio;
			}
			else
				i++;
			
		}
		
		//Si i > a la longitud del vector es que no encontre una solucion
		return i<=monedas.length-1?"El total de monedas fue:"+ cantMonedas + " y se requirio la siguiente combinacion " + combMonedas:"no hay solucion";
	}

}
