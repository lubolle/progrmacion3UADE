package DivedAndConquer;

public class mayoritarioOp2 {
	
	public String elemMayoritario (int[] vec) {
		//Este metodo es acomodando el array y verificando si el elemento del medio es mayoritario
		//si un elemento es mayoritario siempre estara en el medio del arreglo
		
		//Acomodo el arreglo 
		quickSort qSort = new quickSort();
		qSort.QuickSort(vec, 0, vec.length-1);
		int mitad = (vec.length-1)/2;
		int contador = 0;
		
		for(int i=0; i<=vec.length-1; i++) {
			if(vec[mitad]==vec[i]) {
				contador++;
			}
		}
		
		return (contador>=mitad+1)? "Hola tu mayoritario es " + vec[mitad] : "No hay mayoritario";
	}


}
