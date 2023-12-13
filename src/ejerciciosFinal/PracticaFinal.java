package ejerciciosFinal;

import java.util.LinkedList;

public class PracticaFinal {
	

/// Esto era para un ordenamiento de un arreglo entre positivos y negativos sin cambiar su orden relativo
	private static void MergeNegativos (int vec[], int ini, int fin) {

		int w [] = new int[fin-ini+1];
		int mid = (ini + fin)/2;
		int i = ini;
		int j = mid +1;

		for(int k=0; k<fin-ini+1; k++)
		{
			if((j>fin)||(vec[i]<0 && i< mid+1))
			{
				w[k]=vec[i];
				i++;
			}
			else if (vec[i]>0 && vec[j]>0){
				w[k] = vec[i];
				i++;
			}
			else{
				w[k] = vec[j];
				j++;
			}


		}
		for (int k=0; k<= fin-ini; k++)
		{
			vec[ini+k] = w[k];
		}
	}

	public static void MergeSortNegativos(int[] array, int ini, int fin) {
		// TODO Auto-generated method stub
		
		if(ini<fin) {
			
//			Busco la mitada del vector
			int mid = (ini+fin)/2;
//			De la mitad al medio
			MergeSortNegativos(array,ini,mid);
//			Del medio al final
			MergeSortNegativos(array,mid+1,fin);
			MergeNegativos(array,ini,fin);
			
		}
	}



}
