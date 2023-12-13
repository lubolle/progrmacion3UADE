package ProgramacionDinamica;

import java.util.Arrays;

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
        
        C[0]=0;//el costo minimo para ir al nodo 0 es 0
        
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
	}

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







}
