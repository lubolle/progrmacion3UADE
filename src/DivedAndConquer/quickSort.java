package DivedAndConquer;

public class quickSort {

	
	public void QuickSort (int vec[], int ini, int fin) {
		if(ini<fin) {
			
//			Designo el pivot
			int piv = Pivot(vec, ini, fin);
			QuickSort(vec,ini,piv-1);
			QuickSort(vec,piv+1,fin);
			
		}
		
	}
	
	private int Pivot (int vec[],int ini, int fin) {
		
		int p = vec[ini];
		int i = ini + 1;
		int j = fin;
		
		while(i<=j) {
			//El elemento del array es menor al pivot
			while(i <= j && vec[i] < p) {
				i++;
			}
			//El elemento del array es mayor al pivot
			while (i <= j && vec[j] > p) {
				j--;
			}
			
			if(i<=j) {
				int aux = vec[i];
				vec[i] = vec[j];
				vec[j] = aux;
				i++;
				j--;
			}
		}
		
		int aux = vec[j];
		vec[j] = vec[ini];
		vec[ini] = aux;
		return j;
		
//		while (vec[i]<= p && i <= fin) {
//			i++;
//		}
//		
//		while(vec[j] > p) {
//			j--;
//		}
//		
//		while(i<j) {
//			int aux = vec[j];
//			vec[j] = vec[i];
//			vec[i] = aux;
//			while (vec[i] <= p && i <= fin) {
//				i++;
//			}
//			while(vec[j] > p) {
//				j--;
//			}
//		}
//		int aux = vec [j];
//		vec[j] = p;
//		p = aux;
//		return j;
		
	}
	
}
