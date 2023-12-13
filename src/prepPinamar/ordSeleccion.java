package prepPinamar;

public class ordSeleccion {
	
	public void Seleccion (int[] vec) {
		int m =0;
		for(int i=0 ; i < vec.length ;i++ ) {
			for(int j = i+1; j< vec.length; j++) {
				if(vec[i]>vec[j])
				{
					m = j;
					int aux = vec[i];
					vec[i] = vec[m];
					vec[m]=aux;
				}
			}

		}
		//Imprimo el vector
//		for(int z = 0; z < vec.length;z++) {
//			System.out.println(vec[z]);
//		}
	}

}
