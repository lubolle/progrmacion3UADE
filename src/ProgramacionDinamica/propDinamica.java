package ProgramacionDinamica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class propDinamica {

	public int fiboDinamico (int n) {
		int fibo[] = new int[n+1];

		if(n<=1)
			return n;
		else {
			for(int i=0; i<=n;i++) {
				if(i<=1)
					fibo[i]=i;
				else {
					fibo[i]=fibo[i-1]+fibo[i-2];
				}
			}
		}
		return fibo[n];
	}

	public int minCostoNavegacion(int[][] precios) {
        int n = precios.length;
        int C[] = new int[n];
        for(int i =1; i<n ;i++)
        	C[i]=Integer.MAX_VALUE;//pongo todo el arreglo con +infinito

        C[0]=0;//el costo minimo para ir al nodo 0 es 0

        for(int i =1; i<n; i++) {
        	for(int j=0;j<i;j++) {
        		if(precios[j][i]!=0)//Esto es por que en la matriz de adyacencia significa que no tengo camino
        			C[i]=Math.min(C[i], C[j]+precios[j][i]);
        	}
        }
        return C[n-1];
	}

	public int[][] pagoMinMon (int []monedas, int pago) {
        int filas = monedas.length;
        int[][] C = new int[filas][pago+1];

        for(int i = 0; i<filas; i++) {//me muevo en las distintas monedas
        	for(int j=0; j<pago+1;j++) {//me muevo en los costos parciales

        		if(i==0 && j==0)
        			C[i][j]=0;
        		else if (i==0 && monedas[i]>j)
        			C[i][j]=Integer.MAX_VALUE;
        		else if(i==0 && monedas[i]<=j)
        			C[i][j] = 1+C[i][j-monedas[i]];//me muevo de costado en la moneda
        		else if(i>0 && monedas[i]>j)
        			C[i][j] = C[i-1][j];//me traigo el valor de arriba
        		else
        			C[i][j] = Math.min(1+C[i][j-monedas[i]], C[i-1][j]);
        	}
        }

		return C;
	}

	public int mochilaCeroUno (int []weight, int []value, int backPackSize) {
        int row = value.length;
        int[][] V = new int[row][backPackSize+1];

        for(int i = 0; i<row; i++) {
        	for(int j=0; j<backPackSize+1;j++) {

        		if(i==0 && weight[i]>j)
        			V[i][j]=0;

        		else if (i==0 && weight[i]<=j)
        			V[i][j]= value[i];

        		else if(i>0 && weight[i]>j)
        			V[i][j] = V[i-1][j];

        		else if(i>0 && weight[i]<=j)
        			V[i][j] = Math.max(V[i-1][j],value[i]+V[i-1][j-weight[i]]);
        	}
        }

		return V[weight.length-1][backPackSize];
	}

	public int mochila01ConRepeticion (int []weight, int []value, int backPackSize) {
		int row = value.length;
		int[][] V = new int[row][backPackSize+1];

		for(int i = 0; i<row; i++)
            for (int j = 0; j < backPackSize + 1; j++) {

                if (i == 0 && weight[i]>j)
                    V[i][j] = 0;
				else if(i==0 && weight[i]<=j)
					V[i][j] = (V[i][j - weight[i]] + value[i]);

                else if (weight[i] > j)
                    V[i][j] = V[i - 1][j];
                else
					V[i][j] = Math.max(V[i - 1][j], (V[i][j - weight[i]] + value[i]));
            }

		return V[weight.length-1][backPackSize];
	}

	public  int caminMasLargo(int[][] graph) {
        int n = graph.length;
        int C[] = new int[n];
        for(int i =1; i<n ;i++)
        	C[i]=0;//pongo todo el arreglo en 0 por que voy a buscar maximo

        C[0]=0;//el mayor costo  para ir al nodo 0 es 0

        for(int i =1; i<n; i++) {
        	for(int j=0;j<i;j++) {
        		if(graph[j][i]!=0)//Esto es por que en la matriz de adyacencia significa que no tengo camino
        			C[i]=Math.max(C[i], C[j]+graph[j][i]);
        	}
        }
        return C[n-1];
    }

	public int subSecMasLarga(String x, String y) {
		int n = x.length();//largo de string x
		int m = y.length();
		int Tdin[][] = new int[n+1][m+1];

		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m ;j++) {
				if(i==0 || j==0)
					Tdin[i][j]=0;
				else{
					if(x.charAt(i-1)==y.charAt(j-1)) {
						Tdin[i][j]=Tdin[i-1][j-1] + 1;
					}
					else
						Tdin[i][j]= Math.max(Tdin[i][j-1],Tdin[i-1][j]);// Me fijo si el mayor esta a la izq o arriba
				}
			}
		}
		return Tdin[n][m];
	}

	public int subString(String x, String y) {
		int ancho = x.length();//largo de string x
		int alto = y.length();
		int M[][] = new int[alto+1][ancho+1];

		for(int i=0; i<=alto; i++) {
			for(int j=0; j<=ancho ;j++) {
				if(i==0 || j==0)
					M[i][j]=0;//Completo con 0s la primera fila y la primera columna
				else{
					if(x.charAt(i-1)==y.charAt(j-1)) {
						M[i][j]=M[i-1][j-1] + 1;
					}
					else
						M[i][j]= Math.min(M[i][j-1],M[i-1][j]);// Me fijo si el menor esta a la izq o arriba
				}
			}
		}
		return M[alto][ancho];
	}

	public int[][] subMatrizCuadrada(int[][]M){
		int n = M.length;
		int H[][] = new int[n][n];

		for(int i=0;i<n;i++) {
			for(int j=0; j<n;j++) {
				if(i==0||j==0)
					H[i][j]=M[i][j];
				else if(M[i][j]==0)
					H[i][j]=0;
				else if(i>0 && j>0)
					H[i][j]=Math.min(Math.min(H[i-1][j],H[i-1][j-1]),H[i][j-1])+1;
			}
		}
		return H;
		//O(n^2), lo que significa que su rendimiento es cuadrático en
		//función del tamaño de la matriz cuadrada de entrada
	}

	public int[][] laberintoMatriz(int[][]A)
	{
		int n = A.length;
		int M[][] = new int[n][n];

		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {

				if(i==0 && A[i][j]!=1)//no puedo venir de arriba
					M[i][j]=1;
				else if(j==0 && A[i][j]!=1)//no puedo venir de la izquierda
					M[i][j]=1;
				else if(i>0 && A[i][j]!=1)
					M[i][j]= M[i-1][j]+M[i][j-1];
				else
					M[i][j]=0;
			}
		}

		return M;
	}

	public int subirEscaleras(int piso) {
		if(piso<=0)
			return piso;

		int dp[] = new int[piso + 1]; //este arreglo guarda los resultados intermedios
		//Casos bases
		dp[1]=1;
		dp[2]=2;

		//calcula los resultados para cada escalon a partir del tercero
		for(int i=3; i<=piso; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[piso];
	}

	public int numeroCatalan (int n) {
		int array[] = new int[n+1];
		for(int i=0; i<=n;i++) {
			if(i==0)
				array[i]=1;
			else
				array[i]=(int) ((2.0 * (2 * i - 1) / (i + 1)) * array[i - 1]);
		}
		return array[n];
	}

	// TODO: 09/12/2023 - Ejercicio de palabras, no tengo ninguno de estos.

	public void mayorSubSecCreciente (int [] secuencia){
		int [][] matriz = new int[2][secuencia.length];

		for(int i=0;i<secuencia.length;i++){
			matriz[0][i]=1;
			matriz[1][i]=-1;
		}
		for(int i=1;i<secuencia.length;i++){
			for(int j=0;j<i;j++){
				if(secuencia[j]<=secuencia[i] && matriz[0][j]+1>=matriz[0][i]){
					matriz[0][i] = matriz[0][j] + 1;
					matriz[1][i] = j;
				}
			}
		}
		//Busco el elemento mayor
		int max = matriz[0][0];
		int indice =0;
		for(int i=1;i<secuencia.length;i++){
			if(max<matriz[0][i]){
				max=matriz[0][i];
				indice = i;
			}
		}
		while(indice>-1){
			System.out.println(matriz[0][indice]);
			indice=matriz[1][indice];
		}
	}//Inicialización de la matriz:𝑂(𝑛)/Construcción de la matriz:𝑂(𝑛^2)
	// /Encontrar la longitud máxima:𝑂(𝑛)
	//Imprimir sub sec 𝑂(𝑛)
	//Total 𝑂(𝑛^2)

	public int fabricaSaxos(int[][] S, int[] D) {
		int n = D.length + 1;
		int[][] P = new int[2][n];

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < 2; i++) {
				if (j == 0) {
					P[i][j] = S[i][j];
				} else if (i == 0) {
					// First row
					P[i][j] = Math.min(P[i][j - 1], P[1][j - 1] + D[j - 1]) + S[i][j];
				} else {
					// Second row
					P[i][j] = Math.min(P[i][j - 1], P[0][j - 1] + D[j - 1]) + S[i][j];
				}
			}
		}

		return Math.min(P[0][n - 1], P[1][n - 1]);
	}

	public Boolean BarajarPalabras(String A, String B, String C){
		boolean result = false;
		Boolean M[][] = new Boolean[A.length()][B.length()];
		for(int i=0; i<A.length();i++){
			for(int j=0; j<B.length();j++){
				if(i==0){
					if(j==0)
						M[i][j]=true;
					else if (A.charAt(j)==C.charAt(i+j)&&M[i][j-1]) {
                        M[i][j]=true;
                    } else
						M[i][j]=false;
				}
				else{
					if(j==0 && B.charAt(i)==C.charAt(i+j)&&M[i-1][j]){
						M[i][j]=true;
					} else if (j>0 && A.charAt(j)==C.charAt(i+j)&&M[i][j-1] || j>0 && B.charAt(i)==C.charAt(i+j)&&M[i-1][j]) {
						M[i][j]=true;
					}
					else
						M[i][j]=false;
				}
				 result = M[i][j];
			}
		}
		return result;
	}

	public int CaminoRobot(int[][]M){
		//matriz auxiliar para ir guardando los caminos minimos aux[i,j]
		int fil = M.length;
		int col = M[0].length;
		int[][] aux = new int[fil][col];
		for(int i=0;i<fil;i++){
			for(int j=0;j<col;j++){

				if(i==0 & j==0){
					aux[i][j]=M[0][0];
				}
				else if(i==0 && j >0){//Primera fila, no pueden venir de arriba, viene de la izquierda
					aux[i][j]=M[i][j]+aux[i][j-1];
				}
				else if(j==0 && i>0) {//Primera columna, no puede venir del costado
					aux[i][j] = M[i][j] + aux[i-1][j];
				}
				else{
					aux[i][j] = Math.min(aux[i-1][j],aux[i][j-1])+M[i][j];
				}
			}
		}

		//Formacion del camino
		int i = fil - 1;
		int j = col - 1;
		List<String> camino = new ArrayList<>();
		camino.add("(" + i + ", " + j + ")");

		while (i > 0 || j > 0) {
			if (i == 0) {// ya estoy arriba del todo
				j--;
			} else if (j == 0) {// ya estoy contra la izquierda
				i--;
			} else {
				if (aux[i - 1][j] < aux[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
			camino.add("(" + i + ", " + j + ")");
		}

		Collections.reverse(camino);

		System.out.println("El camino mínimo es:");
		for (String posicion : camino) {
			System.out.println(posicion);
		}
		return aux[fil-1][col-1];

	}



	public void grillaCilindrica(int[][] C) {
		int m = C.length;//filas
		int n = C[0].length;//Columna
		int[][] aux = new int[m][n];//Matriz auxiliar para el costo minimo
		for (int i = 0; i < m; i++) {
			aux[i][0] = C[i][0];}//aca lo que hace es dejar la primera columna de la
			// auxiliar con los mismos costos de la matriz original
		for (int j = 1; j < n; j++) {//columnas, arranco desde la segunda columna
			for (int i = 0; i < m; i++) {//voy revisando fila a fila.
				int up = aux[prevRow(i, m)][j - 1];
				int left = aux[i][j - 1];
				int down = aux[nextRow(i, m)][j - 1];
				aux[i][j] = C[i][j] + Math.min(Math.min(up, left), down);}
		}
		int minCost = 99;
		for(int j = 0; j<n;j++){
			for (int i = 0; i < m; i++) {
				minCost = Math.min(minCost, aux[i][j]);
			}
			System.out.print(minCost + "-");
			minCost = 99;
		}//O(n*m)
	}
	// Si i es 0 (primera fila), (i - 1 + m) % m nos da m - 1,
	// que es el indice de la ultima fila.
	public static int prevRow(int i, int m) {
		return (i - 1 + m) % m;
	}
	// Si i es m - 1 (ultima fila), (i + 1) % m nos da 0, que es el indice de la primera fila.
	public static int nextRow(int i, int m) {
		return (i + 1) % m;
	}

	//El objetivo es encontrar la longitud del camino más largo que va de v1 a vn.
	public int caminoMasLargoGrafoOrdenado(int[][] grafo){
		int []dp = new int[grafo[0].length];//en este vector voy a ir guardan el mayor costo para ir a cada nodo que estara identificado con el indicie del array.
		for(int i=0; i<grafo[0].length;i++){
			for(int j=0; j<grafo[0].length;j++){
				if(i==0 && j==0)
					dp[i]=0;//no tengo costo de ir de 0 a 0

				if(i<j && grafo[i][j]!=0)
					dp[j]=dp[i]+grafo[i][j];
			}
		}
		return dp[grafo.length-1];
	}

	public int minaOro (int[][] M){
		int m = M.length; //filas
		int n = M[0].length;//columnas
		int [][] aux = new int[m][n];
		for(int j=0;j<n;j++){
			for(int i=0; i<m;i++){
				if(j==0)
					aux[i][0]=M[i][j];
				else if (i==0) {//No puedo buscar arriba, tengo 2 mov validos
					aux[i][j] = M[i][j] + Math.max(aux[i][j-1],aux[i+1][j-1]);
				}
				else if (i==m-1) {
					aux[i][j] = M[i][j] + Math.max(aux[i][j-1],aux[i-1][j-1]);
				}
				else
					aux[i][j] = M[i][j] + Math.max(Math.max(aux[i][j - 1], aux[i + 1][j - 1]), aux[i - 1][j - 1]);
			}
		}
		int max = aux[0][n-1];
		for(int i = 1; i<n;i++){
			if(aux[i][n-1]>max)
				max = aux[i][n-1];
		}
		return max;
	}

	public  int[] bellmanFord(int[][] grafo, int vertices, int origen) {
		int[] distancias = new int[vertices];
		Arrays.fill(distancias, Integer.MAX_VALUE);
		distancias[origen] = 0;

		// Relajación de aristas repetidas |V| - 1 veces
		for (int i = 0; i < vertices - 1; i++) {
			for (int[] arista : grafo) {
				int u = arista[0];
				int v = arista[1];
				int peso = arista[2];
				if (distancias[u] != Integer.MAX_VALUE && distancias[u] + peso < distancias[v]) {
					distancias[v] = distancias[u] + peso;
				}
			}
		}

		// Verificar ciclos de peso negativo
		for (int[] arista : grafo) {
			int u = arista[0];
			int v = arista[1];
			int peso = arista[2];
			if (distancias[u] != Integer.MAX_VALUE && distancias[u] + peso < distancias[v]) {
				System.out.println("El grafo contiene un ciclo de peso negativo");
				return null; // Se encontró un ciclo de peso negativo
			}
		}

		return distancias;
	}

	public int numeroDePermutaciones(int n, int k){
		int [][] M = new int[k+1][n];//Matriz donde voy a ir armando las permutaciones / complejidad O(k.n)
		for(int i=0;i<M.length;i++){
			for(int j=0;j<M[0].length;j++){
				if(i==0) // O(1)
					M[i][j]=1;
				else if (i==j+1) // O(j)
					M[i][j]=factorialRecursivo(j+1);//aca calculo el factorial tiene una complejidad O(n^2) por estar dentro de un bucle anidado
				else if(i>j+1)//k es mayor a n
					M[i][j]=0;
				else
					M[i][j]=M[i][j-1]+i*M[i-1][j-1];
			}
		}
		return M[k][n-1];
	}//Complejidad Inicializacion O(k.n)
	//Bucle anidado O(k.n)
	//factorial O(n^2) en el peor de los casos
	//Por lo que la complejidad final es O(n^2)

	private int factorialRecursivo(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("El número debe ser no negativo.");
		}
		if (n == 0) {
			return 1;
		}
		return n * factorialRecursivo(n - 1);
	}
	//b=lo que le voy quitando a la entrada = 1
	//a= llamados recursivos =1
	//k= grado del polinomio = 0
	//O(n^k+1)--> O(n)


}
