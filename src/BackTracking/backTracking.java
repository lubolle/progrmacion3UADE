package BackTracking;

public class backTracking {

	public boolean posicionDamas(int[] vec, int e) {

		boolean ok = false;
		// vec[e] es lo mismo que la columna, los indices del vector son las columnas
		vec[e] = 0;

		while (vec[e] < vec.length && !(ok)) {
			if (damaOK(vec, e)) {

				if (e == vec.length - 1)
					ok = true;
				else
					ok = posicionDamas(vec, e + 1);
			}

			vec[e] = vec[e] + 1;
		}
		return ok;

	}

	boolean damaOK(int vec[], int e) {

		for (int i = 0; i < e; i++) {
			// me fijo que la resta de las filas y las restas de las columnas no sea iguales
			// filas --> Math.abs(i-fila)
			// columnas --> Math.abs(vec[i]-vec[fila])
			if (vec[i] == vec[e] || (Math.abs(vec[i] - vec[e]) == Math.abs(i - e))) {
				return false;
			}
		}
		return true;
	}

	public void sumaSubConj(int[] v, int numBuscado, int etapa, int[] actSol, int actSum) {

		for (int i = 0; i <= 1; i++) {// El for va de 0 a 1 por que el numero puede estar o no, son solo 2 opciones.
			actSol[etapa] = i;// Aca voy poniendo si lo guardo o no osea (0 o 1)
			actSum = actSum + v[etapa] * i;// Si el numero no va se lo multilica por 0

			if (etapa == v.length - 1) {// me fijo si estoy al final del arbol
				if (actSum == numBuscado)
					for (int j = 0; j < actSol.length; j++) {// Imprime lindo el resultado
						System.out.print(actSol[j] + " ");
					}
			} else {
				if (actSum <= numBuscado)
					sumaSubConj(v, numBuscado, etapa + 1, actSol, actSum);
			}
		}
	}
	
	public void generacionNumBin(int[] v, int etapa) {
		for(int i = 0;i<=1; i++) {
			v[etapa]=i;
			if(etapa == v.length-1) {
				for (int j = 0; j < v.length; j++){// Imprime lindo el resultado
					System.out.print(v[j] + " ");
				}
				System.out.println();
			}
			else {
				generacionNumBin(v,etapa+1);
			}
		}
	}

	public void particionPartesIguales (int[] v, int sumTotal, int sumParcial,int etapa) {
		for(int i = 0; i<=1; i++) {
			sumParcial = sumParcial + v[etapa]*i;
			sumTotal = sumTotal - v[etapa]*i;
			if(etapa == v.length-1) {
				if(sumTotal==sumParcial)
					System.out.print("partes iguels de " + sumParcial +"|"+sumTotal );
					System.out.println();
			}
			else if (sumParcial<=sumTotal)
				particionPartesIguales(v,sumTotal, sumParcial,etapa+1);
		}
	}
	
	public void particionPartesIguales2 (int[]v,int[]solu, int etapa) {
		for(int i = 0; i<=1; i++) {
			solu[etapa]=i;
			if(etapa == v.length-1) {
				int s1 =0;//lado izquierdo
				int s2 =0;//lado derecho
				for(int j=0; j<=v.length-1;j++) {
					if(solu[j]==0)
						s1 = s1+v[j];
					else
						s2= s2+v[j];
				}
				if(s1==s2){
					System.out.print("partes iguels de " + s1 +"|"+s2 );
					System.out.println();
					}
			}
			else
				particionPartesIguales2(v,solu,etapa+1);
		}
	}///COMPLEJIDAD A=2 (tengo 2 llamados recursivos uno por true y otro por false)
		//			B=1 (lo que le saco a la entrada)
		//			K=1 (por el for interior que es lineal)

/// Considere 5 objetos con pesos (w1,w2,w3,..,w5) = (10,3,5,7,2) y una mochila de tamano m=15. Use una estrategia de backtracking para encontrar todas las combinanciones de objetos que bane exactamente en la mochila. Calcule la complejidad del metodo

	public void mochilaBackT(int []v, int[]solu, int etapa, int mochila) {
		for(int i=0;i<=1;i++) {
			solu[etapa]=i;
			if(etapa==v.length-1) {
				int carga=0;//carga de la mochila
				for(int j=0; j<=v.length-1;j++) {
					if(solu[j]==1)
						carga = carga + v[j];
				}
				if(carga==mochila) {

					System.out.println();
					for (int j = 0; j < v.length; j++){// Imprime lindo el resultado
						System.out.print(solu[j] + " ");
					}
				}
			}
			else
				mochilaBackT(v,solu,etapa+1,mochila);
		}	
	}
	///COMPLEJIDAD A=2 (tengo 2 llamados recursivos uno por true y otro por false)
			//			B=1 (lo que le saco a la entrada)
			//			K=1 (por el for interior que es lineal)
	//Exponenciasl  -- O(2^n)
	
	
///dadas cuatro variables booleanas  x0 x1 x2 x3 (o binarias) sujetas a las siguientes restricciones:
	//x1 =! x2 y el numero de variables en 1 debe ser impar
	
	public void variablesBooleanas (int[]solu, int etapa) {
		for(int i=0;i<=1;i++) {
			solu[etapa] = i;
			
			if(etapa == solu.length-1) {
				if(restriccionOK(solu,etapa)) {	
					for (int j = 0; j < solu.length; j++){// Imprime lindo el resultado
						System.out.print(solu[j] + " ");
					}
					System.out.println();
					
				}
			}
			else
				variablesBooleanas(solu,etapa+1);
		}
	}
	
	private boolean restriccionOK(int[]solu,int etapa) {
		int cantUnos = 0;
		for(int i=0;i<=solu.length-1;i++) {
			cantUnos = cantUnos + solu[i];
		}
		if(solu[1]==solu[2] || cantUnos % 2 !=0){
			return false;
		}
		
		return true;
	}
	
	
}// llave de cierre
