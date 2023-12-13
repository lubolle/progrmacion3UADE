package DivedAndConquer;

public class mergeSort {
	
	public void MergeSort (int vec[], int ini, int fin) {
		if(ini<fin) {
			
//			Busco la mitada del vector
			int mid = (ini+fin)/2;
//			De la mitad al medio
			MergeSort(vec,ini,mid);
//			Del medio al final
			MergeSort(vec,mid+1,fin);
			Merge(vec,ini,fin);
			
		}
		
	}
	
	private void Merge (int vec[], int ini, int fin) {
		
		int w [] = new int[fin-ini+1];
		int mid = (ini + fin)/2;
		int i = ini;
		int j = mid +1;
		
		for(int k=0; k<fin-ini+1; k++)
		{
			if((j>fin)||(vec[i]<=vec[j] && i< mid+1))
			{
				w[k]=vec[i];
				i++;
			}
			else {
				w[k] = vec[j];
				j++;
			}
				
		}
		for (int k=0; k<= fin-ini; k++)
		{
			vec[ini+k] = w[k];
		}
		
		
		
		
	}
	

}
