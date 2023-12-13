package prepPinamar;

public class buscBinariaRecurs {

	public Boolean buscBinRec (int [] arr, int valorBuscado, int inicio,int fin) {
		
		
		if( inicio == fin && valorBuscado != arr[fin])
		{
			return false;
		}
		
		int medio = (inicio + fin)/2;
		
		if(valorBuscado == arr[medio])
			return true;
		else if (valorBuscado > arr[medio])
			return buscBinRec(arr,valorBuscado, medio +1, fin);
			else 
				return buscBinRec(arr,valorBuscado, inicio, medio -1);
		
	}
}
