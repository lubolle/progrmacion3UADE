package DivedAndConquer;

public class mayoritarioOp1 {
	
	public String elemMayoritario (int[] vec) {
		//Este metodo es recorriendo todo el arreglo
		int mitadmasuno = (vec.length-1)/2+1;
		int contador = 0;
		int i = 0;
		
		while(contador<mitadmasuno && i<=vec.length-1){
			contador = 0;
			for (int j = 0; j<=vec.length-1; j++) {
				
				if(vec[i]==vec[j]) {
					contador ++;
				}
			}
			i++;
		}
		return (contador>=mitadmasuno) ? "Elemento mayoritario " + vec[i-1]:"No hay mayoritario";
	
	}

}
