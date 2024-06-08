package prepPinamar;
import DivedAndConquer.mergeSort;
import DivedAndConquer.PropuestosClase1;
import DivedAndConquer.PropuestosClase1.MinMaxPair;
import DivedAndConquer.quickSort;
import DivedAndConquer.torresHanoi;
import DivedAndConquer.palindromo;
import DivedAndConquer.perteneceAlVector;
import DivedAndConquer.OrdenadoAlfabeticamente;
import DivedAndConquer.fibonacci;
import DivedAndConquer.mayoritarioOp1;
import DivedAndConquer.mayoritarioOp2;
import DivedAndConquer.productoMatrices;
import Greedy.frutillasTurgovia;
import Greedy.propuestosClase4Greedy;
import ProgramacionDinamica.propDinamica;
import BackTracking.backTracking;
import ejerciciosFinal.PracticaFinal;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("unused")

public class Main {
	private static List<Integer>[] adjList;
	private static void addEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
	}
	public static void main(String[] args) {
		printArray printA = new printArray();
		//		int [] array = {1,2,3,4,5,33,55,66,67,99};
		//		busquedaBinaria b = new busquedaBinaria();
		//		int res = b.busqBinaria(array,11);
		//		if(res==-1) {
		//			System.out.println("No esta");
		//		}
		//		else
		//		{System.out.println("Esta, el valor encontrado es " + array[res]);}

		//		buscBinariaRecurs brecursiva = new buscBinariaRecurs();
		//		boolean result = brecursiva.buscBinRec(array, 100, 0, array.length-1);
		//		if(result)
		//			System.out.println("Resultado existente");
		//		else
		//			System.out.println("no esta");
		//
		//		potencia potencia = new potencia();
		//		int pot = potencia.Pot(2, 0);
		//		System.out.print(pot);
		//


		//EJERCICIOS DE LA GUIA

		//		1.	Determinar si una secuencia de n caracteres está ordenada alfabéticamente
		//		String cadena = "ABCDEGHIJK";
		//		OrdenadoAlfabeticamente ordAlf = new OrdenadoAlfabeticamente();
		//		System.out.print(ordAlf.ordenAlfabet(cadena));

		//		2. Dado un vector de n números naturales ordenados crecientemente, determinar si un número x dado pertenece al vector.

		//		int[] cadena = {1,2,3,4,5};
		//		int num = 6;
		//		perteneceAlVector pVector = new perteneceAlVector();
		//		System.out.print(pVector.pertenece(cadena, num, 0));


		//		5. Dadas dos matrices cuadradas M1 y M2 de NxN, calcular el producto de ambas, donde N es una potencia de 2.
		//			int[][] A = {{1,2},{3,4}};
		//			int[][] B = {{1,0},{0,1}};
		//			productoMatrices prodMatriz = new productoMatrices();
		//			int[][] resultado = new int[2][2];
		//
		//			prodMatriz.prodMatric(A, B, resultado, 0, 0, 0, A.length);
		//			prodMatriz.mostrarMatriz(resultado, 0, 0);

		// Torres de hanoi (A TERMINAR)
		//        int n = 4; // número de discos
		//        int origen = 1; // torre origen
		//        int auxiliar = 2; // torre auxiliar
		//        int destino = 3; // torre destino
		//        torresHanoi hanoi = new torresHanoi();
		//        hanoi.hanoi(n, origen, auxiliar, destino);
		//

		//		int [] array = {5,4,3,7,1,2};
		//		int [] array = {5,4};
		//		int [] array = {1,2,3,2,1};
		//		int [] array = {2,1,1,1,3};
		//MAYORITARIOS
		//		int [] array = {4,5,4,1,4,3,4,7,4,2,4,8,4};
		//		int [] array = {2, 1, 5, 2, 3, 2, 2, 7, 2, 9, 2, 8, 2};
		//		int [] array = {8, 6, 5, 8, 2, 8, 1, 8, 3, 8, 4, 8, 8};
		//		int [] array = {8, 6, 5, 8, 2, 8, 1, 8, 3, 8, 4, 8, 7};
		//		ordSeleccion oSelec = new ordSeleccion();
		//		oSelec.Seleccion(array);

		//MERGE SORT
		//		mergeSort mSort = new mergeSort();
		//		mSort.MergeSort(array, 0, (array.length-1));

		//QUICK SORT
		//		quickSort qSort = new quickSort();
		//		qSort.QuickSort(array, 0, (array.length-1));

		//PALINDROMO
		//		palindromo pal = new palindromo();
		//		System.out.print(pal.Palindromo(array, 0,array.length-1));
		//FIBONACCI
		//		fibonacci fi = new fibonacci();
		//		System.out.print(fi.Fibonacci(6));

		// MAYORITARIO RECORREINDO TODO EL VEC O(N^2)
		//		mayoritarioOp1 mayo = new mayoritarioOp1();
		//		System.out.println(mayo.elemMayoritario(array));

		//MAYORITARIO ACOMODANDO ARRAY

		//		mayoritarioOp2 mayo = new mayoritarioOp2();
		//		System.out.println(mayo.elemMayoritario(array));

		//		printA.showArray(array);

		//EJERCICIOS CURSADA RICARDO WHEBE - DIVIDE Y VENCERAS (20 de Agosto)
		int[] moneda1 = {1, 1, 1, 2, 1, 1};
		int[] moneda2 = {1, 2};
		int[] moneda3 = {1, 1, 1, 1, 1, 1};
		int[] array1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1};//{1,2,3,3,4};
		int[] array2 = {7, 2, 3, 4, 5, 6};
		int[] pico1 = {1, 3, 2};
		int[] pico2 = {0, 1, 3, 2, 5, 1, 0};
		int[] pico3 = {1, 2, 3, 4, 5, 6};
		int[] unos1 = {0, 0, 0, 0, 1, 1, 1, 1};
		int[] sepMayor = {2, 7, 4, 5, 3, 1, 8, 6, 10, 11, 12, 13};
		int[] SMP = {4, -5, 3, 2, -7, 4, 3, 1};
		int[] ordCircular1 = {35, 42, 5, 15, 27, 29};
		int[] ordCircular2 = {27, 29, 35, 99, 100, 15};
		int[] ordCircular3 = {1, 3, 5, 6, 7, 15};
		int[] ordEnInd = {-3, -2, -1, 0, 4, 7, 8};
		int[] arrayInfinto = {1, 3, 5, 7, 9, 11, 13, 15, Integer.MAX_VALUE};
		int[] arrayInfintoDeso = {3, 1, 5, 7, 9, 8, 13, 15, Integer.MAX_VALUE};
		int numRaizEntera = 25;
		int[] modeloParcial = {2, 1, 3, 4, 6, 5, 8, 9};
		PropuestosClase1 clase1 = new PropuestosClase1();
		//System.out.println(clase1.arraysIguales(array1, array2, 0, array1.length-1));
		//System.out.println(clase1.numeroRepetido(array1, 0, (array1.length-1)));
		//System.out.println(clase1.raizEntera(9,0,9));
		//		System.out.println(clase1.cantPesadas = clase1.hayTrucha(moneda3, 0, moneda3.length-1));
		//		System.out.println(clase1.picosNOrec(pico3));
		//		System.out.println(clase1.picosRecursivo(array2,0,array2.length-1));
		//		System.out.println(clase1.cantDeUnos(array1, 0, array1.length-1));
		//		System.out.println(clase1.cantDe1(unos1, 0, unos1.length-1));
		//		System.out.println(clase1.septimoMayor(sepMayor, 0, sepMayor.length-1));
		//		System.out.println(clase1.sumMaxPar(SMP, 0, SMP.length-1));
		//		System.out.println(clase1.calcMaxMitad(SMP, 3));
		//		System.out.println(clase1.ordenadoDesplazado(ordCircular2, 0, ordCircular2.length-1));
		//		System.out.println(clase1.ordEnIndex(ordEnInd, 0, ordEnInd.length-1));
		//		System.out.println(clase1.searchInInfiniteArray(arrayInfinto, 5));
		//		System.out.println(clase1.searchInInfiniteUnsortedArray(arrayInfintoDeso, 5, 0, 1));
		//		System.out.println("el numero buscado se encuentra en la posicion " + clase1.busquedaModParcial(modeloParcial, 0, modeloParcial.length, 3));
		//int[] vecNumeros = {3, 6, 1, 8, 2, 4, 7, 5};
		//        MinMaxPair result = clase1.encontrarParMinMax(vecNumeros, 0, vecNumeros.length - 1);
		//        System.out.println("Mínimo: " + result.min);
		//        System.out.println("Máximo: " + result.max);
//		int[] numerosIlimitados = {1,7,25,60,90,105,300,1000,2000};
//		System.out.println(clase1.BusquedaExponencial(numerosIlimitados, 7));
//		int num = 3;
//		System.out.println("El numero catalan es divide and conquer es: " + clase1.numeroCatalan(num));

//		int numTecho = 3;
//		int [] a = {1,2,4,5,5,7,9,11};
//		System.out.println("El techo de "+numTecho+" es "+ clase1.techoDeUnNumero(a,numTecho,0,a.length));

//		System.out.println(clase1.raizCuadradaEntera(9));
		/*********************GREEDY********************/
		/****EJERCICIOS CURSADA RICARDO WHEBE - 4 DE SEPTIEMBRE*****/
		propuestosClase4Greedy clase4 = new propuestosClase4Greedy();

//		int A[] = {6,-7,5,-3,6,-1};
//		clase4.cambioSignoEnArrglo(A,3);
//		int monedas[] = {500, 200, 100, 50, 20, 10, 5};
//		int aPagar = 878;
//		//clase4.frutillasThuragu(monedas, aPagar);
//		int valores[] = {4, 7, 2, 5};
//		int pesos[] = {3, 5, 4, 4};

		//	clase4.mochilaFraccion(valores, pesos,10);
		//		Ejercicio frutillas en Turgovia
		//		Se dispone de las siguientes monedas: cinco francos, dos francos, un franco,
		//		50 centavos (medio franco), 10 centavos, cinco centavos y un centavo
		//		Usted quiere pagar 8.78 francos por un paquete de frutillas (producto típico local),
		//		y quiere hacerlo con la mínima cantidad posible de monedas.

		//		int [] cambio = {500,200,100,50,10,5,1};
		//		int aPagar = 878;
		//		frutillasTurgovia monedas = new frutillasTurgovia();
		//		System.out.println(monedas.contarMonedas(aPagar, cambio));
		//

		//		EJERCICIO --- El problema de la mochila-----
		//		Se trata de otro problema clásico de optimización. Se tiene una mochila que puede llevar un peso de hasta P. Hay por otro lado n objetos identificados por sus números, de 1 a n.
		//		Cada objeto i ∈ {1,...,n} tiene un valor Vi > 0 y un peso Pi > 0.
		//		El objetivo es colocar objetos en la mochila de manera que se maximice el valor almacenado respetando la limitación de peso.
		//		Los objetos pueden ser fraccionados. Para un valor 0≤Xi ≤1,elvaloralmacenadoesXi ×Vi yelpeso correspondiente es Xi × Pi .
		//
		//		int [] valores = {4,7,2,5};
		//		int [] pesos = {3,5,4,4};
		//
		//		mochila mValiosa = new mochila();
		//		mValiosa.mochilaValiosa(valores, pesos, 10);


		//    int[][] preciosLancha = {
		////          {0 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9,10,11,12},
		//            {0, 2, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},//nodo0
		//            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//nodo1
		//            {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},//nodo2
		//            {0, 0, 0, 0, 5, 2, 0, 0, 0, 0, 0, 0, 0},//nodo3
		//            {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},//nodo4
		//            {0, 0, 0, 0, 0, 0, 0, 0,11,15, 0, 0, 0},//nodo5
		//            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},//nodo6
		//            {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 8, 0},//nodo7
		//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//nodo8
		//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},//nodo9
		//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},//nodo10
		//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,11},//nodo11
		//            {0,0,0,0,0,0,0,0,0,0,0,0,0},//nodo12
		//        };
		//	int [][] preciosLancha = {
		//			{0,3,5,9,10},
		//			{0,0,2,7,8 },
		//			{0,0,0,4,6 },
		//			{0,0,0,0,3 },
		//			{0,0,0,0,0 }
		//	};
		//	int [][] preciosLancha = {
		//	{0,1,2,0},
		//	{0,0,0,3},
		//	{0,0,0,4},
		//	{0,0,0,0},
		//};
		//
//		String palabra1 = "BOBA";
//		String palabra2 = "CABO";
//		//
//		String resultado = clase4.combinarPalabras(palabra1, palabra2);
//		System.out.println(resultado);

		//Problema de suma maxima de un arreglo -- //	Queremos seleccionar cinco números dentro de un arreglo con n números enteros positivos (n > 10)
		// de manera que la suma de estos cinco números sea máxima. La restricción es que no se pueden elegir dos números vecinos. Se propone el siguiente algoritmo:

/*		int [] array = {15,4,20,17,11,8,11,16,7,14,2,7};
		int resultado = clase4.sumMaxconRestriccion(array);
		System.out.println(resultado);*/

		/*    Tengo un unico recurso(piano) y N solicitudes para utilizarlo, estas indican la hora de inicio y la hora de fin. La solicitudes son
    para un dia determinado y queremos maximisar el numero de estudiantes que pueden usar el piano. Proponga un esque Greedy para
    resolver este problema*/
//		propuestosClase4Greedy.Solicitud[] arraySolicitudes = new propuestosClase4Greedy.Solicitud[6];
//		arraySolicitudes[0] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("08:00"), LocalTime.parse("09:00"));
//		arraySolicitudes[1] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("09:00"), LocalTime.parse("10:00"));
//		arraySolicitudes[2] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("08:30"), LocalTime.parse("09:30"));
//		arraySolicitudes[3] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("10:00"), LocalTime.parse("12:00"));
//		arraySolicitudes[4] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("10:00"), LocalTime.parse("11:00"));
//		arraySolicitudes[5] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("12:00"), LocalTime.parse("15:00"));
//		System.out.println("Se pueden tomar "+ clase4.pianoFraileMuerto(arraySolicitudes) + " turnos");

	/*	Varios crusos a programar en una universidad. No puedo tener dos cursos en la misma aula. Se necesita un algoritmo que calcule el numero
		minimo de aulas para programar todos los cursos. Usted tiene a disposicion un numero arbitrario de aulas.*/
//		propuestosClase4Greedy.Solicitud[] arrayClases = new propuestosClase4Greedy.Solicitud[6];
//		arrayClases[0] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("08:00"), LocalTime.parse("09:00"));
//		arrayClases[1] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("08:00"), LocalTime.parse("09:30"));
//		arrayClases[2] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("08:00"), LocalTime.parse("10:00"));
//		arrayClases[3] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("09:45"), LocalTime.parse("11:00"));
//		arrayClases[4] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("10:00"), LocalTime.parse("11:00"));
//		arrayClases[5] = new propuestosClase4Greedy.Solicitud(LocalTime.parse("11:00"), LocalTime.parse("13:00"));
//		System.out.println("Se necesitan "+ clase4.aulasFraileMuerto(arrayClases) + " aulas para dictar todos los cursos");

//		int[] materias = {2,3,4,6,6,5,5,3,2,5,6,6};
//		int horasParaEstudiar = 30;
//		clase4.estudianteVago(materias,horasParaEstudiar);

//		char [] S= {'p','l','l','l','p','l','p','l','p','l'};
//		System.out.println("Se capturaron " + clase4.buscarLadron(S,2) + " Ladrones");


		//////////////////////////PROGRAMACION DINAMICA////////////////////////////////
		//////////////////////////PROGRAMACION DINAMICA////////////////////////////////
		//////////////////////////PROGRAMACION DINAMICA////////////////////////////////


		propDinamica dinamica = new propDinamica();
		//    int resultado = dinamica.minCostoNavegacion(preciosLancha);
		//    System.out.println("Costo mínimo de navegación: " + resultado);

		//    int fiboDinamico = dinamica.fiboDinamico(10);
		//    System.out.println(fiboDinamico);
		//Problem del cambio programacio dinamica
//		    int[] monedasDin = {1,4,6};
//		    int pagoDin = 8;
//		    int [][]C = dinamica.pagoMinMon(monedasDin, pagoDin);


//		Problema de la mochila 0-1
//		    int[] value = {3,8,5,7};
//		    int[] weight = {3,2,6,7};
//			int[] value = {100,100,75,75,40,40,40,40};
//			int[] weight = {500,500,300,300,200,200,400,400};
//			int[] value = {45,45,20,20,5,5,27,27};
//			int[] weight = {450,450,200,200,100,100,300,300};
//		    int backPackSize = 600;
//		    int maxCharge = dinamica.mochilaCeroUno(weight, value, backPackSize);
//		    System.out.println(maxCharge);

		//Problema de la mochila 0-1 pero con repeticiones, puedo repetir los objetos
//		    int[] value = {3,8,5,7};
//		    int[] weight = {3,2,6,7};
//		    int backPackSize = 9;
//		    int maxCharge = dinamica.mochila01ConRepeticion(weight, value, backPackSize);
//		    System.out.println(maxCharge);

//		int[][] graph = {
//				{0, 1, 1, 0, 0, 0},
//				{0, 0, 1, 0, 1, 0},
//				{0, 0, 0, 1, 0, 0},
//				{0, 0, 0, 0, 1, 1},
//				{0, 0, 0, 0, 0, 1},
//				{0, 0, 0, 0, 0, 0}
//		        };
//		int[][] graph = {
//				{0, 1, 0, 0},
//				{0, 0, 2, 0},
//				{0, 0, 0, 3},
//		};

//
//		int longestPathLength = dinamica.caminMasLargo(graph);
//		int longestPathLength = dinamica.caminoMasLargoGrafoOrdenado(graph);
//		System.out.println("Longitud del camino más largo: " + longestPathLength);
		////
		//
//		    String x = "ABCBDA";
//		    String y = "ABACADAC";
		String x = "WEBER";
		String y = "GEBER";
		//int subCadMasLarga = dinamica.subSecMasLarga(x,y);
		//System.out.println("Longitud de la sub cadena mas larga es: " + subCadMasLarga);

//		int subString = dinamica.subString(x,y);
//		System.out.println("Longitud dela substring mas larga es: " + subString);


		//
		//  int[][] matriz = {
		//  {0, 1, 0, 1},
		//  {1, 1, 0, 1},
		//  {1, 1, 1, 0},
		//  {0, 1, 0, 1},
		//  };
		//
		//  int[][] matriz = {
		//  {0, 1, 0, 1},
		//  {1, 1, 1, 1},
		//  {1, 1, 1, 0},
		//  {1, 1, 1, 1},
		//  };
		//
		int[][] matriz = {
				{0, 1, 0, 1, 1},
				{0, 1, 0, 1, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 0, 1},
				{1, 1, 1, 0, 0}
		};

//		  int H[][] = new int[matriz.length][matriz.length];
//		  H = dinamica.subMatrizCuadrada(matriz);
//		  for (int i = 0; i < H.length; i++) {
//		      for (int j = 0; j < H[0].length; j++) {
//		          System.out.print(H[i][j] + " ");
//		      }
//		      System.out.println();
//		  }
		//    int[][] laberinto = {
		//    		  {0, 0, 0, 0, 0},
		//    		  {0, 0, 1, 0, 1},
		//    		  {0, 0, 0, 0, 0},
		//    		  {0, 1, 0, 1, 0},
		//    		  {0, 0, 0, 0, 0}
		//    		  };
		//
		//	//    int[][]laberinto = {
		//	//                 {0, 0, 0},
		//	//                 {0, 1, 0},
		//	//                 {0, 0, 0}
		//	//    };
		//	//
		//  int H[][] = new int[laberinto.length][laberinto.length];
		//  H = dinamica.laberintoMatriz(laberinto);
		//  for (int i = 0; i < H.length; i++) {
		//      for (int j = 0; j < H[0].length; j++) {
		//          System.out.print(H[i][j] + " ");
		//      }
		//      System.out.println();
		//  }

		//Ejercicio sub secuencia creciente mas larga de un Array
		int[] secuencia = {2, 3, 1, 5, 0, 6, 7, 2, 3, 4, 5};
		dinamica.mayorSubSecCreciente(secuencia);

		//Ejercicio fabrica de saxos
//		int[] D = {3,2,2,3,2};
//		int[][] S = {{6,4,5,2,3,4},{4,3,5,5,6,6}};
//		System.out.println(dinamica.fabricaSaxos(S,D));


		//Ejercicio escaleras tipo parcial
		//    int piso = 4;
		//    System.out.println(dinamica.subirEscaleras(piso));


		///    PRACTICA FINAL
//		int numero = 3;
//		System.out.println("El catalan dinamico es: "+ dinamica.numeroCatalan(numero));


//		int array[] = {9, -3, 5, -2, -8, -6, 1, 3};
//		PracticaFinal.MergeSortNegativos(array, 0, array.length-1);
//
//		for(int i=0;i<array.length;i++) {
//			System.out.println(array[i]);
//		}

//		String A = "3DADO";
//		String B = "3COSA";
//		String C = "3DACOSDOA";
//		System.out.println(dinamica.BarajarPalabras(A,B,C));
//
//		Se tiene una matriz M ∈ Nn×m donde cada posición M[i,j] repre- senta un costo. Un robot se debe desplazar desde la posición M[0,0] hasta la posición M[n-1,m-1] con mínimo costo. El robot sólo puede desplazar- se en sentido horizontal hacia la derecha o vertical hacia abajo; no puede moverse en diagonal. El costo de un camino es la suma de los costos de las celdas visitadas.
//		int[][] matriz = {
//				{4, 7, 8, 6, 4},
//				{6, 7, 3, 9, 2},
//				{3, 8, 1, 2, 4},
//				{7, 1, 7, 3, 7},
//				{2, 1, 8, 9, 3}
//		};
//		int[][] matriz = {
//				{3,2,4},
//				{1,4,5},
//				{7,3,1}
//		};
//		int[][] matriz = {
//			{6, 1, 4, 4, 8, 4, 6, 3},
//			{5, 8, 7, 9, 9, 2, 7, 8},
//			{8, 9, 2, 6, 9, 5, 4, 1},
//			{4, 6, 1, 3, 4, 9, 2, 4},
//			{4, 4, 8, 1, 2, 1, 5, 8},
//			{4, 3, 8, 3, 1, 1, 5, 6}
//		}
//		System.out.println(dinamica.CaminoRobot(matriz));
//		System.out.print("El camino es el siguiente: ");
//		dinamica.grillaCilindrica(matriz);

//
//		La mina de oro. Se tiene una mina de oro representada por una matriz M de m filas y n columnas. El número M[i,j] representa la cantidad de oro que hay en la posición de la fila i y la columna j. Un minero recorre la mina viajando columna por columna de izquierda a derecha. Inicialmente está en la columna 1 pero puede elegir la fila. Por supuesto, el minero recoje el oro que se encuentra en las celdas que visita. El objetivo es maximizar la cantidad de oro recolectado.
//		Estando en una posición cualquiera M[i,j], dispone de los siguientes despla- zamientos:
//		Hacia arriba a la derecha: M[i, j] → M[i − 1, j + 1] (si i < n y j < m.)
//		Hacia la derecha: M[i, j] → M[i, j + 1] (si j < m.)
//		Hacia abajo a la derecha: M[i, j] → M[i + 1, j + 1] (si i > 1 y j < m.)
//		int[][] minaOro = {
//				{1,3,3},
//				{2,1,5},
//				{0,6,4}
//		};
//		System.out.print(dinamica.minaOro(minaOro));


//		int[][] grafo = {
//				{0, 1, 6}, // (0 -> 1) con peso 4
//				{0, 2, 5}, // (0 -> 2) con peso 3
//				{0, 3, 5}, // (1 -> 3) con peso 2
//				{1, 4, -1}, // (1 -> 2) con peso 5
//				{2, 1, -2}, // (2 -> 3) con peso 7
//				{2, 4, 1}, // (3 -> 4) con peso 2
//				{3, 2, -2},  // (4 -> 0) con peso 1
//				{3, 5, -1}, //(5-->) con peso -1
//				{4, 6, 3},
//				{5, 6, 3}
//		};
//		int vertices = 7; // Número de vértices en el grafo
//		int origen = 0; // Vértice de origen
//
//		int[] distancias = dinamica.bellmanFord(grafo, vertices, origen);
//
//		System.out.println("Distancias más cortas desde el vértice " + origen + ": ");
//		for (int i = 0; i < vertices; i++) {
//			System.out.println("Hacia el vértice " + i + ": " + distancias[i]);
//		}

//		La permutación de n elementos tomados de a k se refiere al proceso de acomodar k elementos de un conjunto de n para formar una secuencia.
//				El coeficiente de permutaciones P(n,k) nos da el número de secuencias que podemos obtener tomando k elementos de un conjunto de n. Este coeficiente está dado por la fórmula
//
//		El coeficiente P(n,k) se puede computar a partir de resultados ya obtenidos para números menores:
//		P (n, k) = P(n - 1, k) + k. P(n - 1, k - 1)
//		Además tenemos los casos base: si k > n entonces P(n, k) = 0, si k = n
//		entonces P (n, k) = P(n,n) = n! y si k = 0 entonces P(n, k) = P(,0) = 1.
//		Con esta información, se pide:
//		a) Establezca una estrategia general para encontrar el número buscado.
//				Explique en palabras cómo piensa resolver el problema. ¿A cuál de las técnicas estudiadas corresponde su estrategia y por qué? La entrada son los números n y k. Observe que no se admite el cálculo directo de las fórmulas excepto en los casos base.
//		6) Escriba el pseudo-código del programa que realiza su estrategia.
//		c) Calcule la complejidad del programa que escribió.
//				Ayuda: puede crear una matriz M de n columnas que vayan de 1 an y k + 1 filas que vayan de 0 a k de manera que cada posición M[i, j] contenga el valor P(i, j].
//		Las fórmulas dadas más arriba le dan todos los elementos necesarios.

//		int n = 4;
//		int k = 2;
//		System.out.println("Las permutaciones de n="+n+" tomando de a k=" + k + " elementos es:"+ dinamica.numeroDePermutaciones(4,2));

//		/////////////--------------BACKTRACKING--------------------\\\\\\\\\\\\\\\\\\\\\\\\\
//
		backTracking backT = new backTracking();


		//Problema de las damas en el tablero de damas
		//    int vec [] = new int[4];
		//    int etapa = 0;
		//    boolean damas = backT.posicionDamas(vec, etapa);
		//    System.out.print(damas);

		/// Problema suma de subconjuntos
//		    int v[]= {5,10,6,7};//Numeros del conjunto
//		    int actSol[] = new int[v.length];
//		    int etapa = 0;
//		    int numBuscado = 18;//Numero que quiero encontrar
//		    int actSum = 0;//variable para ir viendo cuanto da la suma
//		    backT.sumaSubConj(v,numBuscado,etapa,actSol,actSum);

		///Generacion de numeros binarios con n cantidad de bits

//		   	int cantBits = 2;
//		    int v[] = new int[cantBits*2];
//		    int etapa = 0;
//			boolean[] usados = new boolean[cantBits+1];
		//backT.generacionNumBin(v,etapa);
		//backT.generacionNumBinConRestriccion(v,etapa,2);
//			// Complejidad: O(n)
//
//			int[] secuencia = new int[2 * cantBits];//es el tamaño que tendra el vector
//			boolean[] usado = new boolean[cantBits + 1];
//			List<int[]> soluciones = new ArrayList<>();
//			backT.buscarCombinaciones(secuencia, usado, etapa, cantBits, soluciones);


//		int n = 5;//Cantidad de salas
//		int[] doors = {2, 3, 1, 1, 4};
//		int[] maxRooms = new int[]{0}; // Para almacenar el resultado
//		backT.salasCine(0,5,doors,0,maxRooms);


		///////////------Particion en sumas iguales------------///////

		//    int[] v = {2,5,8,3,2};
		//    int sumTotal = 0;
		//	for(int i = 0; i<=v.length-1; i++) {
		//		sumTotal = sumTotal + v[i];
		//
		//	}
		//    int sumParcia = 0;
		//    int etapa = 0;
//		    backT.particionPartesIguales(v, sumTotal, sumParcia, etapa);
		//
		//    int[] s = new int[v.length];
		//    backT.particionPartesIguales2(v, s, etapa);


		////////=---------Mochila backTracking-------------=///////////

//		  int[] v = {10,3,5,7,2};
//		  int[] sol = new int[v.length];
//		  int etapa = 0;
//		  backT.mochilaBackT(v, sol, etapa, 15);


		//============-----------Variables booleanas con n cantidad de numeros y restricciones=======----------/////
		//int cantVariables = 4;
		//int [] solu = new int[cantVariables];
		//int etapa = 0;
		//backT.variablesBooleanas(solu, etapa);

		//Permutacion de caracteres
//		String str = "ABC";
//		backT.permutaciones(str.toCharArray(),0);

		//Permutaciones con restricciones
//		char[] A = {'A','B','C'};
//		char[] S = {' ',' ',' '};
//
//		backT.permutacionesSinRestriccion(A,S,0);

		//Ejercicio del final, te daba un numero n y en base a ese numero n tenias que generar todas las permutaciones y guardarlas en un arraylist
//		int n = 3;
//		int[] Sol = new int[n];
//		ArrayList<int[]> listaDeSubarreglos = new ArrayList<>();//Aca voy a guardar todos los resultados
//		backT.generadorDePermutaciones(n,0,Sol,listaDeSubarreglos);
//
//		for (int[] subarreglo : listaDeSubarreglos) {
//			for (int elemento : subarreglo) {
//				System.out.print(elemento + " ");
//			}
//			System.out.println();
//		}

//
//		int[] A = {1,2,3,4};
//		int[] S = new int[A.length];
//		backT.numerosPrecedente(A,0,S);

		//System.out.println(backT.corchos(11,1));

//		int[][] Mt= {
//				{0,1,0,0,0,0,0,0,0},
//				{0,0,1,1,1,0,0,0,0},
//				{1,0,0,0,0,1,0,0,0},
//				{0,0,0,0,1,0,0,0,0},
//				{0,0,0,0,0,0,1,1,0},
//				{0,0,0,0,0,0,0,0,1},
//				{0,0,0,0,0,1,0,1,0},
//				{0,0,0,0,0,0,0,0,1},
//				{0,0,0,0,0,0,0,0,0}
//		};

//		int[][] Mt= {
//				{0,1,1},
//				{0,0,1},
//				{0,0,0},
//
//		};

//		int[][] Mt= {
//				{0,1,0,0,0,0,0,0,0},
//				{0,0,0,1,1,0,0,0,0},
//				{1,0,0,0,0,0,0,0,0},
//				{0,0,0,0,1,0,0,0,0},
//				{0,0,0,0,0,0,1,1,0},
//				{0,0,1,0,0,0,0,0,1},
//				{0,0,0,0,0,1,0,1,0},
//				{0,0,0,0,0,0,0,0,1},
//				{0,0,0,0,0,0,0,0,0}
//		};

//		int[][] Mt = {
//				{0,1,0},
//				{0,0,1},
//				{0,0,1}
//
//		};


//		System.out.println(backT.hasCycle(Mt));


		//int[] A = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
//		int [] A = {7,3,2,8};
//		int[] S = new int[A.length];
////		List<Integer> grupo1 = new ArrayList<>();
////		List<Integer> grupo2 = new ArrayList<>();
//		int [] grupo1 = new int[A.length];
//		int [] grupo2 = new int[A.length];
//		int n = A.length;
//		int mejorDif = 99999;
//		backT.diferenciaMinimaEntreSubConjuntos(A,0,grupo1,grupo2,n,mejorDif,S);
//		System.out.print(Arrays.toString(S));

		//Problema del caballo ajedrez, verificar si es posible vistar todas las casillas de un tablero nxn sin repetir ninguna
//		int[][] M = new int[5][5];
//		int[] movX = {1, 2, -1, -2, -2, -1, 1, 2};
//		int[] movY = {2, 1, 2, 1, -1, -2, -2, -1};
//		System.out.println(backT.caballo(M, 0, 0, movX, movY, 1));
//		for(int i=0; i<M.length;i++){
//			for(int j=0;j<M.length;j++){
//				System.out.print(M[i][j] + " ");
//			}
//			System.out.println();
//		}
		//Problema del conjeo
//		int [][] M = {
//				{2,1,0,0},
//				{3,0,0,1},
//				{0,1,0,1},
//				{0,0,0,1}
////				{1,0,0,0},
////				{1,0,1,1},
////				{0,0,0,1},
////				{0,0,0,1}
//		};
//		System.out.println(backT.conjeo(M,0,0));

		//Caminos en grafo dirigido
//		int [][] M = {
//				{0,1,1,0,1},
//				{0,0,1,1,0},
//				{0,1,0,1,1},
//				{0,1,0,0,1},
//				{0,0,1,1,0}
//		};
//		String solucion = " ";
//		int etapa = 0;
//		int origen = 0;
//		int[] visit = new int[M.length];
//		backT.caminosGrafoDirigido(M,origen,visit,etapa,solucion);

		//Problema de suma de subconjuntos
//		int [] v = {5,10,6,7};
//		int m = 11;
//		int [] solu = new int[v.length];
//		backT.sumaSubConjunto(0,m,v,solu,0);

		//problema de generar todos los numeros binarios de n bits
//		int n = 2;
//		int [] solu = new int[n];
//		backT.numerosBinarios(0,solu);

		//Generar subconjuntos
//		Set<Integer> subconjuntos = new HashSet<>();
//		int k = 3;
//		backT.generacionSubConjuntos(k,1,subconjuntos);

//		String [] letras = {"A","B","C","D"};
//		String [] solucion = new String[letras.length];
//		backT.permutacionesABCD(letras,0,solucion);

//	Subconjuntos independientes en un grafo no dirigido: dado un grafo no dirigido G = (V,E), un subconjunto de nodos A ⊆ V es independiente o
//	estable si no hay dos elementos en A que sean adyacentes.

//		private static List<Integer>[] adjList;
//		private static int maxSize = 0;
//		private static Set<Integer> bestSet = new HashSet<>();
//		int n =10;//numero de nodos
//		adjList = new ArrayList[n];
//		for (int i = 0; i < n; i++) {
//			adjList[i] = new ArrayList<>();
//		}
//
//		// Agregar aristas (grafo no dirigido)
//		addEdge(0, 1);
//		addEdge(0, 6);
//		addEdge(0, 4);
//		addEdge(1, 2);
//		addEdge(1, 3);
//		addEdge(2, 6);
//		addEdge(2, 3);
//		addEdge(2, 8);
//		addEdge(3, 8);
//		addEdge(4, 6);
//		addEdge(4, 5);
//		addEdge(5, 6);
//		addEdge(5, 9);
//		addEdge(6, 1);
//		addEdge(6, 8);
//		addEdge(6, 7);
//		addEdge(7, 9);
//		addEdge(8, 7);
//
//
//		Set<Integer> currentSet = new HashSet<>();
//		backT.findMaxIndependentSet(0, currentSet, adjList);

//Defina una estrategia de backtracking que permita determinar si existe
//un estado de deadlock al que se pueda llegar desde el estado 0.

		int [][] M = {
				{0,1,0,0},
				{0,0,1,0},
				{0,0,0,1},
				{0,0,0,0},
				};
		boolean []vistados = new boolean[M.length];
		backT.estadoDeadlock(M,0,vistados);

	}
}
