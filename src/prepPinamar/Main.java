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

@SuppressWarnings("unused")

public class Main {

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
		int [] moneda1 = {1, 1, 1, 2, 1, 1};
		int [] moneda2 = {1, 2};
		int [] moneda3 = {1, 1, 1, 1, 1, 1};
		int [] array1 = {1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1};//{1,2,3,3,4};
		int [] array2 = {7, 2, 3, 4, 5, 6};
		int [] pico1 = {1,3,2};
		int [] pico2 = {0, 1, 3, 2, 5, 1, 0};
		int [] pico3 = {1, 2, 3, 4, 5, 6};
		int [] unos1 = {0, 0, 0, 0, 1, 1, 1, 1};
		int [] sepMayor = {2, 7, 4, 5, 3, 1, 8, 6, 10,11,12,13};
		int [] SMP = {4, -5, 3, 2, -7, 4, 3, 1};
		int [] ordCircular1 = {35, 42, 5 ,15 ,27 ,29};
		int [] ordCircular2 = {27, 29, 35 ,99 ,100 ,15};
		int [] ordCircular3 = {1, 3, 5 ,6 ,7 ,15};
		int [] ordEnInd = {-3, -2, -1, 0, 4, 7 ,8};
		int [] arrayInfinto = {1, 3, 5, 7, 9, 11, 13, 15, Integer.MAX_VALUE};
		int [] arrayInfintoDeso = {3, 1, 5, 7, 9, 8, 13, 15, Integer.MAX_VALUE};
		int numRaizEntera = 25;
		int []modeloParcial = {2,1,3,4,6,5,8,9};
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
		int[] vecNumeros = {3, 6, 1, 8, 2, 4, 7, 5};
		//        MinMaxPair result = clase1.encontrarParMinMax(vecNumeros, 0, vecNumeros.length - 1);
		//        System.out.println("Mínimo: " + result.min);
		//        System.out.println("Máximo: " + result.max);

		/*********************GREEDY********************/
		/****EJERCICIOS CURSADA RICARDO WHEBE - 4 DE SEPTIEMBRE*****/
		propuestosClase4Greedy clase4 = new propuestosClase4Greedy();
		int monedas[] = {500, 200, 100, 50, 20, 10, 5};
		int aPagar = 878;
		//clase4.frutillasThuragu(monedas, aPagar);
		int valores[] = {4, 7, 2, 5};
		int pesos[] = {3, 5, 4, 4};

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


		//Problema de la mochila 0-1
		//    int[] value = {3,8,5,7};
		//    int[] weight = {3,2,6,7};
		//    int backPackSize = 9;
		//    int maxCharge = dinamica.mochilaCeroUno(weight, value, backPackSize);
		//    System.out.println(maxCharge);

		//Problema de la mochila 0-1 pero con repeticiones, puedo repetir los objetos
//		    int[] value = {3,8,5,7};
//		    int[] weight = {3,2,6,7};
//		    int backPackSize = 9;
//		    int maxCharge = dinamica.mochila01ConRepeticion(weight, value, backPackSize);
//		    System.out.println(maxCharge);

		//    int[][] graph = {
		//            {0, 1, 1, 0, 0, 0},
		//            {0, 0, 1, 0, 1, 0},
		//            {0, 0, 0, 1, 0, 0},
		//            {0, 0, 0, 0, 1, 1},
		//            {0, 0, 0, 0, 0, 0}
		//        };
		//    
		//    int longestPathLength = dinamica.caminMasLargo(graph);
		//    System.out.println("Longitud del camino más largo: " + longestPathLength);
		////    
		//    
		//    String x = "ABCBDA";
		//    String y = "ABACADAC";
		//    int subCadMasLarga = dinamica.subSecMasLarga(x,y);
		//    System.out.println("Longitud de la sub cadena mas larga es: " + subCadMasLarga);
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
		//  int[][] matriz = {
		//  {0, 1, 0, 1, 1},
		//  {0, 1, 0, 1, 1},
		//  {1, 1, 1, 0, 1},
		//  {1, 1, 1, 0, 1},
		//  {1, 1, 1, 0, 0}
		//  };
		//  
		//  int H[][] = new int[matriz.length][matriz.length];
		//  H = dinamica.subMatrizCuadrada(matriz);
		//  for (int i = 0; i < H.length; i++) {
		//      for (int j = 0; j < H[0].length; j++) {
		//          System.out.print(H[i][j] + " ");
		//      }
		//      System.out.println();
		//  }
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
//		int[] secuencia = {2,3,1,5,0,6,7,2,3,4,5};
//		dinamica.mayorSubSecCreciente(secuencia);

		//Ejercicio fabrica de saxos
		int[] D = {3,2,2,3,2};
		int[][] S = {{6,4,5,2,3,4},{4,3,5,5,6,6}};
		System.out.println(dinamica.fabricaSaxos(S,D));


		//Ejercicio escaleras tipo parcial
		//    int piso = 4;
		//    System.out.println(dinamica.subirEscaleras(piso));


		///    PRACTICA FINAL 
		int numero = 8;
//		System.out.println(dinamica.numeroCatalan(numero));


//		int array[] = {9, -3, 5, -2, -8, -6, 1, 3};
//		PracticaFinal.MergeSortNegativos(array, 0, array.length-1);
//
//		for(int i=0;i<array.length;i++) {
//			System.out.println(array[i]);
//		}


		/////////////--------------BACKTRACKING--------------------\\\\\\\\\\\\\\\\\\\\\\\\\

		backTracking backT = new backTracking();

		//Problema de las damas en el tablero de damas
		//    int vec [] = new int[4];
		//    int etapa = 0;
		//    boolean damas = backT.posicionDamas(vec, etapa);
		//    System.out.print(damas);


		/// Problema suma de subconjuntos

		//    int v[]= {5,10,6,7};//Numeros del conjunto
		//    int actSol[] = new int[v.length];
		//    int etapa = 0;
		//    int numBuscado = 18;//Numero que quiero encontrar
		//    int actSum = 0;//variable para ir viendo cuanto da la suma
		//    backT.sumaSubConj(v,numBuscado,etapa,actSol,actSum);

		///Generacion de numeros binarios con n cantidad de bits

		//    int cantBits = 4;
		//    int v[] = new int[cantBits];
		//    int etapa = 0;
		//    backT.generacionNumBin(v,etapa);


		///////////------Particion en sumas iguales------------///////

		//    int[] v = {2,5,8,3,2};
		//    int sumTotal = 0;
		//	for(int i = 0; i<=v.length-1; i++) {
		//		sumTotal = sumTotal + v[i];
		//		
		//	}
		//    int sumParcia = 0;
		//    int etapa = 0;
		//    //backT.particionPartesIguales(v, sumTotal, sumParcia, etapa);
		//    
		//    int[] s = new int[v.length];
		//    backT.particionPartesIguales2(v, s, etapa);


		////////=---------Mochila backTracking-------------=///////////

		//  int[] v = {10,3,5,7,2};
		//  int[] sol = new int[v.length];
		//  int etapa = 0;
		//  backT.mochilaBackT(v, sol, etapa, 15);


		//============-----------Variables booleanas con n cantidad de numeros y restricciones=======----------/////   
		//int cantVariables = 4;
		//int [] solu = new int[cantVariables];
		//int etapa = 0;
		//backT.variablesBooleanas(solu, etapa);




	}


}
