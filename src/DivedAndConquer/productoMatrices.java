package DivedAndConquer;

public class productoMatrices {
	
	public void prodMatric(int[][] matriz1 , int[][] matriz2,int[][] resultado, int fila, int columnaM2, int k, int altoFilaM1){
		
		//fila y columna llegan en 0
		
		if (fila == altoFilaM1) { // Caso base: se han recorrido todas las filas de la matriz1
            return;
        }

        if (columnaM2 == altoFilaM1) { // Se han completado todas las columnas de la matriz2 para la fila actual
        	prodMatric(matriz1, matriz2, resultado, fila + 1, 0, 0, altoFilaM1); // Avanzar a la siguiente fila de matriz1
            return;
        }

        if (k == altoFilaM1) { // Se han completado todas las columnas de la matriz1 para la columna actual de matriz2
        	prodMatric(matriz1, matriz2, resultado, fila, columnaM2 + 1, 0, altoFilaM1); // Avanzar a la siguiente columna de matriz2
            return;
        }

        resultado[fila][columnaM2] += matriz1[fila][k] * matriz2[k][columnaM2]; // Multiplicación y acumulación

        prodMatric(matriz1, matriz2, resultado, fila, columnaM2, k + 1, altoFilaM1); // Avanzar a la siguiente columna de matriz1
	}
	
	
	
	
	public void mostrarMatriz(int[][] Mat, int fil, int col) {
		
		if(fil==Mat.length)//Ya estoy en la ultima fila
			return;
		
		System.out.print(Mat[fil][col] + " ");
		
		
		if(col==Mat[fil].length-1) {
			//Aca cambio de fila
			System.out.println();
			mostrarMatriz(Mat,fil+1,0);//me quedo en columna 0 porq arranco mostrando desde el principio
		}
		else
			//aca cambio de columna
			mostrarMatriz(Mat,fil,col+1);
	}
	

}
