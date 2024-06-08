package Alogaritmos;
import recursividadProgra3.*;

import java.util.Vector;

import Implementacion.*;
import api.*;


public class Metodos {
	
/**____________________________________METODOS Progra 3____________________________________**/

	public static int esMayoritario (int S[],int inicio, int fin) {
		int medio = (fin+inicio)/2;
		if(inicio==fin)//tengo un solo elemento
			return S[inicio];
		
			if(S[inicio]==S[medio])
				return S[inicio];//estoy contemplando un elemento de 2 items
			if(S[medio+1]==S[fin])
				return medio+1;
			else
			{
				if(S.length>0) {
				int izq =  esMayoritario(S,inicio,medio);
				int der = esMayoritario(S,inicio,medio+1);
				return izq==der?izq:-1;
				}
				else
					return -1;
			}
	//	
	}
	
	public static int candidato(int S[], int inicio, int fin)
	{
		if(inicio==fin)
			return S[inicio];//Vector de un elemento
		else
			if(inicio>fin)//no es candidato
				return -1;
			else
				if((fin-inicio)+1==2)//Es un vector par, en los pares para que sea mayoritarios siempre tengo que tener 2 elementos iguales juntos
					if(S[inicio]==S[fin])
						return S[inicio];
					else
						return -1;//no es candidato
				else{
					//Vector nuevoVec = new Vector();
					int candidatos[];
					if((fin-inicio)+1%2==0)//Es un vector impar
					{
						
						for(int i=inicio; i<fin ;i=i+2)//Recorre el vector de 2 en 2 buscando dos elementos iguales
						{
							if(S[i]==S[i+1])
								//v1.agregarEnVector(S[i]);//Si encuentro 2 iguales lo guardo en el nuevo vector
								nuevoVec.add(S[i]);
							else
							{
								//Si no coincide ninguno de los pares agrega el ultimo como candidato
								for(int j=inicio; j<fin ;j=j+2)
								{
									if(S[i]==S[i+1])
										nuevoVec.add(S[i]);
										//v1.agregarEnVector(S[i]);
									//v1.agregarEnVector(S[fin]);
									nuevoVec.add((S[fin]));
									
								}
							}
						}
					}
				}
					
					
		return (nuevoVec,0,nuevoVec.size()-1);
	}
	
	private static int[] agregarCandidato(int S[],int valor)
	{
		int i=0;
		while(S != null) {
			if(S[i] == null) {
				
			}
		}
	}
	public static boolean estaOrdenado(int S[],int inicio, int fin) {
		if(inicio==fin)
			return true;
		
		int mitad =(fin+inicio)/2;
		if(S[mitad]>S[mitad+1])
			return false;
		
		boolean primeraMitad = estaOrdenado(S,inicio,mitad);
		if(!estaOrdenado(S,inicio,mitad))//La primera mitad no esta ordenada
				return false;
		else
			return estaOrdenado(S,mitad+1,fin);
		
				
		//return estaOrdenado(S,inicio,mitad) && estaOrdenado(S,mitad+1,fin);
		//Hacer el return con dos llamadas recursivas hace que la complejidad temporal
		//se termine yendo muy arriba
	}
	
	
	public static void mostrarVectorChar(char S[],int ini, int fin) {
		while(ini<=fin) {
			System.out.print(S[ini]);
			ini++;
		}
	}
	
	public static void mostrarVector(Vector v1,int ini, int fin) {
		while(ini<=fin) {
			System.out.print(v1.obtenerValorVector(ini) +" ");
			ini++;
		}
	}
	

	
	public static String vectorToString (String str, char s[], int pos)
	{
	        if (pos == s.length) //me fijo si la posicion es el tama�o del vector
	            return str;		//El caso trival es que sea un solo caracter a convertir
	        
	        str += Character.toString(s[pos]);
	        return vectorToString(str, s, ++pos);
	}
	
	public static boolean cadenOrdenada (char vect[]) {
		
		String cadOrginal = new String();
		String cadOrdenada = new String();
		cadOrginal = vectorToString(cadOrginal,vect,0);
		Ordenamiento.MergeSortChar(vect, 0, 3);
		cadOrdenada = vectorToString(cadOrdenada,vect,0);
		if(cadOrginal.equals(cadOrdenada))
			return true;
		return false;
	}
	
	
	/*------------------METODOS PILA---------------------------------------*/	
	 public static void MostrarPila(PilaTDA origen) {	
		PilaTF aux = new PilaTF();
		aux.InicializarPila();
		if(!origen.PilaVacia())
		{
			while(!origen.PilaVacia())
			{
				aux.Apilar(origen.Tope());
				System.out.print(origen.Tope()+" \n");
				origen.Desapilar();
			}
			PasarPila(aux,origen);//Restauro la pila original
			System.out.print("\n");
		}
		else
		{
			System.out.println("La pila esta vacia");
		}
	}
	 
	 public static void CopiarPila(PilaTDA origen, PilaTDA destin){
		 PilaTF aux = new PilaTF();
		 aux.InicializarPila();
		 if(!origen.PilaVacia())
		 {
			 PasarPila(origen,aux);
			 while(!aux.PilaVacia())
			 {
				 destin.Apilar(aux.Tope());
				 origen.Apilar(aux.Tope());
				 aux.Desapilar();
			 }
		 }
		 else
		 {
			 System.out.println("No es posible realizar una copia,"
			 		+ " la pila esta vacia");
		 }
	 }	 
	
	 //Pasa una pila a la otra destruyendola o y dejando invertida d
	 public static void PasarPila(PilaTDA o, PilaTDA d){
			while(!o.PilaVacia()){
				d.Apilar(o.Tope());
				o.Desapilar();			
			}
	 }

	 public static void InvertirPila(PilaTDA original)
	 {
		 PilaTF aux1= new PilaTF();
		 PilaTF aux2= new PilaTF();
		 aux1.InicializarPila();
		 aux2.InicializarPila();
		 PasarPila(original,aux1);
		 PasarPila(aux1,aux2);
		 while(!aux2.PilaVacia())
		 {
			 original.Apilar(aux2.Tope());
			 aux2.Desapilar();
		 }
	 }	
	 
	 public static int ContarElementos (PilaTDA origen)
	 {
		 int cant=0;
		 PilaTF aux = new PilaTF();
		 aux.InicializarPila();
		 PasarPila(origen,aux);
		 while(!aux.PilaVacia())
		 {
			 origen.Apilar(aux.Tope());
			 cant++;
			 aux.Desapilar();
		 }
		 return cant;
	 }
	  
	 public static float SumarPila(PilaTDA original)
	 {
		 PilaTF aux = new PilaTF();
		 aux.InicializarPila();
		 float total=0;
		 PasarPila(original, aux);
		 while(!aux.PilaVacia())
		 {
			 original.Apilar(aux.Tope());
			 total+=aux.Tope();
			 aux.Desapilar();
		 }
		 return total;
	 }
	 
	 public static float PromedioPila(PilaTDA original)
	 {
		 PilaTF aux = new PilaTF();
		 aux.InicializarPila();
		 float total=0;
		 int cant=0;
		 PasarPila(original, aux);
		 while(!aux.PilaVacia())
		 {
			 original.Apilar(aux.Tope());
			 total+=aux.Tope();
			 aux.Desapilar();
			 cant++;
		 }
		 return total/cant;
	 }

	 public static Boolean PilaCapicua(PilaTDA original)
	 {
		 PilaTDA aux = new PilaD();
		 PilaTDA invertida = new PilaD();
		 CopiarPila(original,aux);
		 CopiarPila(original,invertida);
		 InvertirPila(invertida);
		 while(!aux.PilaVacia())
		 {
			 if(aux.Tope()==invertida.Tope())
			 {
				 aux.Desapilar();
				 invertida.Desapilar();
			 }
			 else
				 return false;	 
		 }
		 return true; 
	 }
	 
	 public static PilaTDA EliminarRepeticiones (PilaTDA original)
	 {
		 PilaTDA aux = new PilaTF();
		 PilaTDA aux1 = new PilaTF();
		 ConjuntoTDA cjaux = new ConjuntoLD();
		 cjaux.InicializarConjunto();
		 aux.InicializarPila();
		 aux1.InicializarPila();
		 CopiarPila(original,aux);
		 CopiarPila(original,aux1);
		 while(!aux.PilaVacia())//PASO todo a un conjunto
		 {
			 cjaux.Agregar(aux.Tope());
			 aux.Desapilar();
		 }
		 
		 while(!aux1.PilaVacia())
		 {
			 if(cjaux.Pertenece(aux1.Tope()))
			 {
				 aux.Apilar(aux1.Tope());
				 cjaux.Sacar(aux1.Tope());
				 aux1.Desapilar();
			 }
			 else
			 {
				 aux1.Desapilar();
			 }
			 
		 }
		 
		 InvertirPila(aux);
		 return aux;
	 }
	 	 
	 public static void PartirPila (PilaTDA o,PilaTDA m1, PilaTDA m2)
	 {
		 PilaTDA aux = new PilaTF();
		 aux.InicializarPila();
		 m1.InicializarPila();
		 m2.InicializarPila();
		 CopiarPila(o,aux);
		 int cant = ContarElementos(aux)/2;
		 while(!aux.PilaVacia()&&cant>0)
		 {
			 m1.Apilar(aux.Tope());
			 aux.Desapilar();
			 cant--;
		 }
		 while(!aux.PilaVacia())
		 {
			 m2.Apilar(aux.Tope());
			 aux.Desapilar();
		 }	 
	 }
	 
	 public static ConjuntoTDA PasarPilatoConjunto(PilaTDA o)
	 {
		 PilaTDA copia = new PilaD();
		 copia.InicializarPila();
		 CopiarPila(o, copia);
		 
		 ConjuntoTDA conj = new ConjuntoTA();
		 conj.InicializarConjunto();
		 while(!copia.PilaVacia())
		 {
			 conj.Agregar(copia.Tope());
			 copia.Desapilar();
		 }
		 
		 return conj;
	 }
	 
	 public static ConjuntoTDA ElementosRepetidosPila (PilaTDA o)
	 {
		 PilaTDA copia = new PilaD();
		 copia.InicializarPila();
		 CopiarPila(o, copia);
		 
		 ConjuntoTDA repetidos = new ConjuntoTA();
		 repetidos.InicializarConjunto();
		 
		 ConjuntoTDA conj = new ConjuntoTA();//uso un conjunto para eliminar los rep
		 conj.InicializarConjunto();
		 conj = PasarPilatoConjunto(copia);
		 
		 while(!copia.PilaVacia())
		 {
			 if(conj.Pertenece(copia.Tope()))
			 {
				 conj.Sacar(copia.Tope());
				 copia.Desapilar();
			 }
			 else
			 {
				 conj.Agregar(copia.Tope());
				 repetidos.Agregar(copia.Tope());
				 copia.Desapilar();
			 }
					 
		 }
		 return repetidos;
	 }
	 
/*------------------METODOS COLA---------------------------------------*/	 
	 public static void PasarCola(ColaTDA o, ColaTDA d)
	 {
		 while(!o.ColaVacia())
		 {
			 d.Encolar(o.Primero());
			 o.DesEncolar();
		 }
	 }
	 
	 public static void MostrarCola(ColaTDA origen)
	 {
		 ColaPI aux = new ColaPI();
		 aux.InicializarCola();
		 PasarCola(origen,aux);
		 while(!aux.ColaVacia())
		 {
			 System.out.print(aux.Primero()+",");
			 origen.Encolar(aux.Primero());
			 aux.DesEncolar();
		 }
		 System.out.print(" \n");
	 }
	 
	 public static void InvertirCola1(ColaTDA origen)
	 {
		 PilaTF auxpila = new PilaTF();
		 auxpila.InicializarPila();
		 ColaPI aux = new ColaPI();
		 aux.InicializarCola();
		 PasarCola(origen,aux);
		 while(!aux.ColaVacia())
		 {
			 auxpila.Apilar(aux.Primero());
			 aux.DesEncolar();
		 }
		 while(!auxpila.PilaVacia())
		 {
			 origen.Encolar(auxpila.Tope());
			 auxpila.Desapilar();
		 }
	 }
	  
	 public static void InvertirCola(ColaTDA origen)
	{
		if(!origen.ColaVacia())
		  {
		  int primero = origen.Primero();
		  origen.DesEncolar();
		  InvertirCola(origen);
		  origen.Encolar(primero);
		  }
	}
	 
	 //Metodo que cuenta los elementos de una cola
	 private static int ContarCola (ColaTDA c1)
	 {
		 int cant=0;
		 ColaTDA auxCola = new ColaPI();
		 auxCola.InicializarCola();
		 
		 while(!c1.ColaVacia())
		 {
			 auxCola.Encolar(c1.Primero());
			 c1.DesEncolar();
			 cant++;
		 }
		 while(!auxCola.ColaVacia())
		 {
			 c1.Encolar(auxCola.Primero());
			 auxCola.DesEncolar();
		 }
		 return cant;
	 }
	 
	 //Metodo que verfica si una cola es capicua
	 public static boolean EsCapicua(ColaTDA c1)
	 {
		 
		 int cant = ContarCola(c1);
		 ColaPI auxCola = new ColaPI();
		 PilaTF auxPila = new PilaTF();
		 auxPila.InicializarPila();
		 auxCola.InicializarCola();
		 PasarCola(c1,auxCola);
		 int mitad = cant/2;//Aca se cual es la mitad de la cola para cargar solo  la mitada en la pila
		 while (!auxCola.ColaVacia()&&mitad >0)//pongo la mitad elementos de la cola en una pila
		 {
			auxPila.Apilar(auxCola.Primero());
			auxCola.DesEncolar(); 
			mitad--; 	
			//c1.Encolar(auxCola.Primero());
		 }
		
		  if(( cant %2) != 0)
			 auxCola.DesEncolar();
		 
		 while(!auxCola.ColaVacia()&&!auxPila.PilaVacia())//Comparo la mitad de la pila con la mitad de la cola
		 {
			 //c1.Encolar(auxPila.Tope());
			 if(auxCola.Primero()!=auxPila.Tope())
			 {
				 return false;
			 }
			 
			 auxCola.DesEncolar();
			 auxPila.Desapilar();
			 mitad--;
		 }
		 return (c1.ColaVacia()&&auxPila.PilaVacia());
	 }
	 
	 public static void CopiarCola(ColaTDA original, ColaTDA copia)
	{
		ColaTDA aux= new ColaPI();
		aux.InicializarCola();

			PasarCola(original,aux);
			while(!aux.ColaVacia())
			{
				original.Encolar(aux.Primero());
				copia.Encolar(aux.Primero());
				aux.DesEncolar();
			}
	}
	
	 public static boolean EsColaInversa(ColaTDA c1,ColaTDA c2)
	{
		ColaTDA auxc1 = new ColaPI();
		auxc1.InicializarCola();
		ColaTDA auxc2 = new ColaPI();
		auxc2.InicializarCola();
		CopiarCola(c2,auxc2);
		CopiarCola(c1,auxc1);
		InvertirCola(auxc2);
		while (!auxc1.ColaVacia()&&!auxc2.ColaVacia())
			if(auxc1.Primero()==auxc2.Primero())
			{
				auxc1.DesEncolar();
				auxc2.DesEncolar();
			}
			else
				return false;
		
		return true;
	}


	 /* Implementacion del profesor
		 ColaTDA aux1 = new ColaPI();
		 aux1.InicializarCola();
		 int cant = 0;
		 PilaTF p= new PilaTF();
		 p.InicializarPila();
		 while(!c1. ColaVacia())
		 {
			 aux1.Encolar(c1.Primero());
			 cant ++;
			 c1.DesEncolar();
		 }
		 // Devuelve la parte entera de una division
		 int mitad = cant/2;
		 
		 while(!aux1.ColaVacia() && mitad > 0) //Aca se lleva la mitad de la cola a una pila
		 {
			 p.Apilar(aux1 .Primero());
			 aux1.DesEncolar();
			 mitad--;
		 }
		 // Retorna 0 si el n´umero es par y 1 si es impar
		 if((cant %2) != 0){
		 aux1.DesEncolar();
		 }
		 while(!p.PilaVacia() && !aux1.ColaVacia())
		 {
			 if(p.Tope() != aux1.Primero())
			 return false;
			 
			 
			 p. Desapilar();
			 aux1.DesEncolar();
		 }
			 return (p.PilaVacia() && aux1.ColaVacia());
	 
	 }
	*/

	 public static ColaTDA SinRepet(ColaTDA original)
	 {
		 ColaTDA aux = new ColaPI();
		 aux.InicializarCola();
		 
		 ColaTDA sinRep = new ColaPI();
		 sinRep.InicializarCola();
		 
		 CopiarCola(original,aux);
		 int anterior = aux.Primero();
		 sinRep.Encolar(anterior);
		 while(!aux.ColaVacia())
		 {
			 if(anterior!=aux.Primero())
			 {
				 sinRep.Encolar(aux.Primero());
				 aux.DesEncolar();
				 anterior = aux.Primero();
			 }
			 else
			 {
				 aux.DesEncolar();
			 }
		 }
		 return sinRep;
	 }
	 
	 public static ConjuntoTDA PasarColatoConjunto (ColaTDA o)
	 {
		 ConjuntoTDA sinrep = new ConjuntoTA();
		 sinrep.InicializarConjunto();
		 ColaTDA copia = new ColaD();
		 copia.InicializarCola();
		 Metodos.CopiarCola(o, copia);
		 
		 while(!copia.ColaVacia())
		 {
			 sinrep.Agregar(copia.Primero());
			 copia.DesEncolar();
		 }
		 return sinrep;
	 }
	 
	 public static ColaTDA ElimRepCola(ColaTDA o)
	 {
		 ColaTDA copia = new ColaD();
		 copia.InicializarCola();
		 
		 ColaTDA sinrep = new ColaD();
		 sinrep.InicializarCola();
		 
		 ConjuntoTDA conj = new ConjuntoTA();//uso un conjunto para eliminar los rep
		 conj.InicializarConjunto();
		 
		 CopiarCola(o, copia);
		 conj = PasarColatoConjunto(copia);
		 
		 while(!copia.ColaVacia())
		 {
			 if(conj.Pertenece(copia.Primero()))
			 {
				 sinrep.Encolar(copia.Primero());
				 conj.Sacar(copia.Primero());
				 copia.DesEncolar();
			 }
			 else
				 copia.DesEncolar();
		 }
		 return sinrep;
	 }
	 	
	 public static void RepartirCola(ColaTDA o, ColaTDA m1, ColaTDA m2)
	 {
		 ColaTDA copia = new ColaD();
		 copia.InicializarCola();
		 CopiarCola(o, copia);
		 int cant = Metodos.ContarCola(o)/2;
		 while(!copia.ColaVacia())
		 {
			 while(cant>0)
			 {
				 cant--;
				 m1.Encolar(copia.Primero());
				 copia.DesEncolar();
			 }
			 m2.Encolar(copia.Primero());
			 copia.DesEncolar();
		 }
	 }
	 
	 public static ConjuntoTDA repetidosEnCola(ColaTDA o)
	 {
		 ColaTDA copia = new ColaD();
		 copia.InicializarCola();
		 CopiarCola(o, copia);
		 
		 ConjuntoTDA repetidos = new ConjuntoTA();
		 repetidos.InicializarConjunto();
		 
		 ConjuntoTDA conj = new ConjuntoTA();//uso un conjunto para eliminar los rep
		 conj.InicializarConjunto();
		 conj = PasarColatoConjunto(copia);
		 
		
		 
		// int anteulti = copia.Primero();
		 //copia.DesEncolar();
		 //int ulti  = copia.Primero();
		 
		 while(!copia.ColaVacia())
		 {
			 if(conj.Pertenece(copia.Primero()))
			 {
				 conj.Sacar(copia.Primero());
				 copia.DesEncolar();
			 }
			 else
			 {
				 conj.Agregar(copia.Primero());
				 repetidos.Agregar(copia.Primero());
				 copia.DesEncolar();
			 }
					 
//			 if(ulti==anteulti && !repetidos.Pertenece(ulti))
//			 {
//				 repetidos.Agregar(ulti);
//				 copia.DesEncolar();
//			 }
//			 
//			 copia.DesEncolar();
//			 
//			 if(!copia.ColaVacia())
//			 {
//				 
//				 anteulti = ulti;
//				 ulti=copia.Primero(); 
//			 }
			 
		 }
		 return repetidos;
	 }
	 
	 
	 //----------METODOS COLA Prioridad---------------------------------------------------------
	
	public static void PasarColaPrioridad(ColaPrioridadTDA original,ColaPrioridadTDA aux)
	{

		while(!original.ColaVacia())
		{
			aux.AcolarPrioridad(original.Primero(), original.Prioridad());
			original.Desacolar();
		}
	}
	
	public static void MostrarColaPrioridad(ColaPrioridadTDA original)
	{
		ColaPrioridadTDA aux = new ColaPrioridadAO();
		aux.InicializarCola();
		PasarColaPrioridad(original,aux);
		while(!aux.ColaVacia())
		{
			original.AcolarPrioridad(aux.Primero(), aux.Prioridad());
			System.out.println("N"+aux.Primero()+"->P"+aux.Prioridad());
			aux.Desacolar();
		}
	}
	
	/*Determinar si dos Colas con prioridad son idénticas.*/
	
	public static boolean SonColasIdenticas (ColaPrioridadTDA c1, ColaPrioridadTDA c2)
	{
		while(!c1.ColaVacia()&&!c2.ColaVacia())
		{
			if(c1.Primero()==c2.Primero()&&c1.Prioridad()==c2.Prioridad())
			{
				c1.Desacolar();
				c2.Desacolar();
			}
			else
				return false;
		}
		return true;
	}
	
	/*Combinar dos colas con prioridades CP1 y CP2, generando una nueva
	cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1
	son más prioritarios que los de la CP2.*/
	
	public static ColaPrioridadTDA CombinarColasPrioridad(ColaPrioridadTDA c1, ColaPrioridadTDA c2)
	{
		ColaPrioridadTDA AuxCola = new ColaPrioridadAO();
		AuxCola.InicializarCola();
		PasarColaPrioridad(c2,AuxCola);
		PasarColaPrioridad(c1,AuxCola);
		
		return AuxCola;
	}
	
	//________________________CONJUNTOS________________________________
	public static void MostrarConjunto (ConjuntoTDA origen)
	{
		ConjuntoTDA aux = new ConjuntoTA();
		aux.InicializarConjunto();
		while(!origen.ConjuntoVacio())
		{
			aux.Agregar(origen.Elegir());
			origen.Sacar(aux.Elegir());
			System.out.print(aux.Elegir()+",");
		}
		while(!aux.ConjuntoVacio())
		{
			origen.Agregar(aux.Elegir());
			aux.Sacar(origen.Elegir());
		}
		System.out.print("\n");
	}

	public static void PasarConjunto (ConjuntoTDA origen, ConjuntoTDA destino)
	{
		int a = origen.Elegir();
		while(!origen.ConjuntoVacio())
		{
			destino.Agregar(a);
			origen.Sacar(a);
			if(!origen.ConjuntoVacio())//me fijo que no sea conjunto vacio para que no rompa.
				a = origen.Elegir();
		}
	}
	
	public static ConjuntoTDA CopiarConjunto (ConjuntoTDA origen)
	{
		ConjuntoTDA back = new ConjuntoTA();
		back.InicializarConjunto();
		PasarConjunto(origen,back);
		
		ConjuntoTDA copia = new ConjuntoTA();
		copia.InicializarConjunto();
		
		int num = back.Elegir();
		while(!back.ConjuntoVacio())
		{
			
			copia.Agregar(num);
			origen.Agregar(num);
			back.Sacar(num);
			if(!back.ConjuntoVacio())//me fijo que no sea conjunto vacio para que no rompa.
				num = back.Elegir();
		}
		
		return copia;
	}
	
	public static ConjuntoTDA UnionConjunto (ConjuntoTDA A, ConjuntoTDA B)
	{
		ConjuntoTDA cA = new ConjuntoTA();
		cA.InicializarConjunto();
		ConjuntoTDA cB = new ConjuntoTA();
		cB.InicializarConjunto();
		ConjuntoTDA union = new ConjuntoTA();
		union.InicializarConjunto();
		cA = CopiarConjunto(A);
		cB = CopiarConjunto(B);
		
		while(!cA.ConjuntoVacio())
		{
			union.Agregar(cA.Elegir());
			cA.Sacar(cA.Elegir());
		}
		while(!cB.ConjuntoVacio())
		{
			union.Agregar(cB.Elegir());
			cB.Sacar(cB.Elegir());
		}
		return union;
	}
	
	public static ConjuntoTDA IntereseccionConjunto (ConjuntoTDA A, ConjuntoTDA B)
	{
		ConjuntoTDA ConjAux = new ConjuntoTA();
		ConjAux.InicializarConjunto();
		while(!A.ConjuntoVacio()&&!B.ConjuntoVacio())
		{
			int a = A.Elegir();
			while(!B.Pertenece(a))
			{
				A.Sacar(a);
				a = A.Elegir();
			}
				ConjAux.Agregar(a);
				A.Sacar(a);
		}
		return ConjAux;
	}
	
	public static ConjuntoTDA DiferenciaConjunto (ConjuntoTDA A, ConjuntoTDA B)
	{
		ConjuntoTDA ConjAux = new ConjuntoTA();
		ConjAux.InicializarConjunto();
		int a = A.Elegir();
		while(!A.ConjuntoVacio()&&!B.ConjuntoVacio())
		{
			a = A.Elegir();//corte de control
			if(B.Pertenece(a))
			{
				A.Sacar(a);
			}
			else
			{
				ConjAux.Agregar(a);
				A.Sacar(a);
			}
		}
		if(ConjAux.ConjuntoVacio())
			System.out.print("La sustraccion de A-B es igual al conjunto vacio");
		return ConjAux;
	}
	
	public static ConjuntoTDA DiferenciaSimetricav2 (ConjuntoTDA A, ConjuntoTDA B)
	{
		ConjuntoTDA diffsim = new ConjuntoTA();
		diffsim.InicializarConjunto();
		
		ConjuntoTDA c1A = new ConjuntoTA();
		c1A.InicializarConjunto();
		ConjuntoTDA c1B = new ConjuntoTA();
		c1B.InicializarConjunto();
		ConjuntoTDA c2A = new ConjuntoTA();
		c2A.InicializarConjunto();
		ConjuntoTDA c2B = new ConjuntoTA();
		c2B.InicializarConjunto();
		
		c1A = CopiarConjunto(A);
		c1B = CopiarConjunto(B);
		c1A = DiferenciaConjunto(c1A, c1B);
	
		c2A = CopiarConjunto(A);
		c2B = CopiarConjunto(B);
		
		c2A = DiferenciaConjunto(c2B, c2A);
		
		return diffsim = Metodos.UnionConjunto(c1A, c2A);
	}
	
	public static ConjuntoTDA DiferenciaSimetricav1 (ConjuntoTDA A, ConjuntoTDA B)
	{
		ConjuntoTDA diffsim = new ConjuntoTA();
		diffsim.InicializarConjunto();
		
		ConjuntoTDA ca = new ConjuntoTA();
		ca.InicializarConjunto();
		ConjuntoTDA cb = new ConjuntoTA();
		cb.InicializarConjunto();
		ca=CopiarConjunto(A);
		cb=CopiarConjunto(B);
		int a=0;
		while(!ca.ConjuntoVacio())
		{
			a=ca.Elegir();
			if(cb.Pertenece(a))
			{
				ca.Sacar(a);
				cb.Sacar(a);
			}
			else
			{
				diffsim.Agregar(a);
				ca.Sacar(a);
			}		
		}
		if(ca.ConjuntoVacio())
			
			while(!cb.ConjuntoVacio())
			{
				a=cb.Elegir();
				diffsim.Agregar(a);
				cb.Sacar(a);
			}
		
		return diffsim;
	}
	
	public static int CardinalidadConjunto (ConjuntoTDA o)
	{
		ConjuntoTDA copia = new ConjuntoTA();
		copia.InicializarConjunto();
		copia = Metodos.CopiarConjunto(o);
		int cant=0;
		while(!copia.ConjuntoVacio())
		{
			copia.Sacar(copia.Elegir());
			cant++;
		}
		return cant;
	}

	public static boolean SonConjuntosIguales (ConjuntoTDA A, ConjuntoTDA B)
	{
		if(CardinalidadConjunto(A)!=CardinalidadConjunto(B))
			return false;
		
		ConjuntoTDA cA = new ConjuntoTA();
		ConjuntoTDA cB = new ConjuntoTA();
		cA.InicializarConjunto();
		cB.InicializarConjunto();
		cA = CopiarConjunto(A);
		cB = CopiarConjunto(B);
		
		while(!cA.ConjuntoVacio() && !cB.ConjuntoVacio())
		{
			if(cB.Pertenece(cA.Elegir()))
				{
					int sacado = cA.Elegir();
					cA.Sacar(cA.Elegir());
					cB.Sacar(sacado);
				}
			else //Si no pertence ya no son iguales
				return false;
		}
				
		return true;
	}
	
	public static ConjuntoTDA PilaColaAConjunto (PilaTDA p, ColaTDA c)
	{
		ConjuntoTDA conj = new ConjuntoTA();
		conj.InicializarConjunto();
		while(!p.PilaVacia())
		{
			while(!c.ColaVacia())
			{
				conj.Agregar(c.Primero());
				c.DesEncolar();
			}
			conj.Agregar(p.Tope());
			p.Desapilar();
		}
		
		return conj;
	}
	//________________________DICCIONARIOS________________________________
	
	public static void PasarDiccionarioMultiple (DiccionarioMultipleTDA o,DiccionarioMultipleTDA d)
	{
		ConjuntoTDA index = new ConjuntoTA();
		index = o.Claves();//clave dic
		while(!index.ConjuntoVacio())
		{
			while(!o.Recuperar(index.Elegir()).ConjuntoVacio())//conjunto de 1 clave
			{
				d.Agregar(index.Elegir(), o.Recuperar(index.Elegir()).Elegir());
				o.EliminarValor(index.Elegir(), o.Recuperar(index.Elegir()).Elegir());
			}
			index.Sacar(index.Elegir());
		}
	}
	
	public static void CopiarDiccionarioMultiple (DiccionarioMultipleTDA o,DiccionarioMultipleTDA d)
	{
		DiccionarioMultipleTDA aux = new DicMultipleL();
		aux.InicializarDiccionario();
		Metodos.PasarDiccionarioMultiple(o, aux);
		ConjuntoTDA index = new ConjuntoLD();
		index = aux.Claves();
		
		while(!index.ConjuntoVacio())
		{
			while(!aux.Recuperar(index.Elegir()).ConjuntoVacio())//recupero el conjunto de una clave
			{
				d.Agregar(index.Elegir(),aux.Recuperar(index.Elegir()).Elegir());
				o.Agregar(index.Elegir(),aux.Recuperar(index.Elegir()).Elegir());
				aux.EliminarValor(index.Elegir(),aux.Recuperar(index.Elegir()).Elegir());
			}
			index.Sacar(index.Elegir());
		}
	}
	
	public static void MostrarDiccionarioMultiple(DiccionarioMultipleTDA o)
	{
		DiccionarioMultipleTDA aux = new DicMultipleL();
		aux.InicializarDiccionario();
		CopiarDiccionarioMultiple(o,aux);
		ConjuntoTDA index = new ConjuntoLD();
		index=aux.Claves();
		
		while(!index.ConjuntoVacio())
		{
			System.out.print("Clave " + index.Elegir()+"\n");
			while(!aux.Recuperar(index.Elegir()).ConjuntoVacio())
			{
				System.out.print(aux.Recuperar(index.Elegir()).Elegir()+"\t");
				aux.EliminarValor(index.Elegir(),aux.Recuperar(index.Elegir()).Elegir());
			}
			System.out.print("\n");
			index.Sacar(index.Elegir());
		}
	}

	public static void UnirDiccMultiple (DiccionarioMultipleTDA d1,DiccionarioMultipleTDA d2,DiccionarioMultipleTDA d1d2)
	{
		ConjuntoTDA indexd1 = new ConjuntoLD();
		ConjuntoTDA indexd2 = new ConjuntoLD();
		indexd1.InicializarConjunto();
		indexd2.InicializarConjunto();
		indexd1 = d1.Claves();
		indexd2 = d2.Claves();
		DiccionarioMultipleTDA d1c = new DicMultipleL();
		d1c.InicializarDiccionario();
		CopiarDiccionarioMultiple(d1, d1c);
		DiccionarioMultipleTDA d2c = new DicMultipleL();
		d2c.InicializarDiccionario();
		CopiarDiccionarioMultiple(d2,d2c);
		
		while(!indexd1.ConjuntoVacio()&&!indexd2.ConjuntoVacio())
		{
			while(!d1c.Recuperar(indexd1.Elegir()).ConjuntoVacio())//recupero conj
			{
				d1d2.Agregar(indexd1.Elegir() /*clave*/, d1c.Recuperar(indexd1.Elegir()).Elegir())/*valor*/;
				d1c.EliminarValor(indexd1.Elegir(), d1c.Recuperar(indexd1.Elegir()).Elegir());
			}
			indexd1.Sacar(indexd1.Elegir());
			
			while(!d2c.Recuperar(indexd2.Elegir()).ConjuntoVacio())
			{
				d1d2.Agregar(indexd2.Elegir(), d2c.Recuperar(indexd2.Elegir()).Elegir());
				d2c.EliminarValor(indexd2.Elegir(), d2c.Recuperar(indexd2.Elegir()).Elegir());
			}
			indexd2.Sacar(indexd2.Elegir());
		}
	}

	public static void DiccClavesComunes (DiccionarioMultipleTDA d1,DiccionarioMultipleTDA d2,DiccionarioMultipleTDA d1d2)
	{
		ConjuntoTDA indexd1 = new ConjuntoLD();
		ConjuntoTDA indexd2 = new ConjuntoLD();
		indexd1.InicializarConjunto();
		indexd2.InicializarConjunto();
		indexd1 = d1.Claves();
		indexd2 = d2.Claves();
		DiccionarioMultipleTDA d1c = new DicMultipleL();
		d1c.InicializarDiccionario();
		CopiarDiccionarioMultiple(d1, d1c);
		DiccionarioMultipleTDA d2c = new DicMultipleL();
		d2c.InicializarDiccionario();
		CopiarDiccionarioMultiple(d2,d2c);
		
		while(!indexd1.ConjuntoVacio()&&!indexd2.ConjuntoVacio())
		{
			if(indexd1.Pertenece(indexd2.Elegir()))
			{
				while(!d1c.Recuperar(indexd2.Elegir()).ConjuntoVacio())//recupero conj
				{
					d1d2.Agregar(indexd2.Elegir() /*clave*/, d1c.Recuperar(indexd2.Elegir()).Elegir())/*valor*/;
					d1c.EliminarValor(indexd2.Elegir(), d1c.Recuperar(indexd2.Elegir()).Elegir());
				}
				indexd1.Sacar(indexd2.Elegir());
				
				while(!d2c.Recuperar(indexd2.Elegir()).ConjuntoVacio())
				{
					d1d2.Agregar(indexd2.Elegir(), d2c.Recuperar(indexd2.Elegir()).Elegir());
					d2c.EliminarValor(indexd2.Elegir(), d2c.Recuperar(indexd2.Elegir()).Elegir());
				}
				indexd2.Sacar(indexd2.Elegir());
			}
			else
			{
				indexd2.Sacar(indexd2.Elegir());
			}
		}
	}
	
	public static void ClavesComElementosCom(DiccionarioMultipleTDA d1,DiccionarioMultipleTDA d2,DiccionarioMultipleTDA d1d2)
	{
		ConjuntoTDA indexd1 = new ConjuntoLD();
		ConjuntoTDA indexd2 = new ConjuntoLD();
		indexd1.InicializarConjunto();
		indexd2.InicializarConjunto();
		indexd1 = d1.Claves();
		indexd2 = d2.Claves();
		DiccionarioMultipleTDA d1c = new DicMultipleL();
		d1c.InicializarDiccionario();
		CopiarDiccionarioMultiple(d1, d1c);
		DiccionarioMultipleTDA d2c = new DicMultipleL();
		d2c.InicializarDiccionario();
		CopiarDiccionarioMultiple(d2,d2c);
		
		while(!indexd1.ConjuntoVacio()&&!indexd2.ConjuntoVacio())
		{
			if(indexd1.Pertenece(indexd2.Elegir()))
			{
				//mientras los conjuntos no sean vacios
			while(!d1c.Recuperar(indexd2.Elegir()).ConjuntoVacio() && !d2c.Recuperar(indexd2.Elegir()).ConjuntoVacio())
				
				{
					if(d1c.Recuperar(indexd2.Elegir()).Pertenece(d2c.Recuperar(indexd2.Elegir()).Elegir()))
					{
						d1d2.Agregar(indexd2.Elegir() /*clave*/, d1c.Recuperar(indexd2.Elegir()).Elegir())/*valor*/;
						d1c.EliminarValor(indexd2.Elegir(), d1c.Recuperar(indexd2.Elegir()).Elegir());
						//d2c.EliminarValor(indexd2.Elegir(), d2c.Recuperar(indexd2.Elegir()).Elegir());
					}
					else
					{
						
						d2c.EliminarValor(indexd2.Elegir(), d2c.Recuperar(indexd2.Elegir()).Elegir());
					}
				}
			}
			indexd1.Sacar(indexd2.Elegir());
			indexd2.Sacar(indexd2.Elegir());
		}
	}
			
/*------------------METODOS ARBOLES---------------------------------------*/		
	
	public static void Preorder (ABBTDA a)//usado para replicar el arbol imprime izq der
	{
		if(!a.ArbolVacio())
		{
			System.out.print(a.Raiz());
			Preorder(a.HijoIzq());
			Preorder(a.HijoDer());
		}
	}
	
	public static void Inorder (ABBTDA a)//izq imprimie der
	{
		if(!a.ArbolVacio())
		{
			Inorder(a.HijoIzq());
			System.out.print(a.Raiz());
			Inorder(a.HijoDer());
		}
	}
	
	public static void Postorder (ABBTDA a)//izq  der imprimie
	{
		if(!a.ArbolVacio())
		{
			Postorder(a.HijoIzq());
			Postorder(a.HijoDer());
			System.out.print(a.Raiz());
		}
	}
	
	public static int Profundidad (ABBTDA a, int elemento)//PRE CONDICION DEBO Verificar que el elemento a buscar exista
	{
		if(a.ArbolVacio()) 
			return -1;
		
		if(elemento==a.Raiz())//elemento igual a raiz
			return 0;
		if(elemento<a.Raiz())
			return 1 + Profundidad(a.HijoIzq(),elemento);
		else
			return 1 + Profundidad(a.HijoDer(),elemento);
		
	}
	
	public static int Altura (ABBTDA a)
	{
		if(a.ArbolVacio())
			return -1;
		
		if(!a.ArbolVacio())
		{
			int hi=Altura(a.HijoIzq());
			int hd=Altura(a.HijoDer());
			return hi>hd?hi+1:hd+1;
		}
		return 0;
	}

	public static boolean SonElementosIguales(PilaTDA p, ColaTDA c) 
	{	
		PilaTDA cp = new PilaTF();
		cp.InicializarPila();
		CopiarPila(p,cp);
		
		ColaTDA cc = new ColaPI();
		cc.InicializarCola();
		CopiarCola(c,cc);
		int i = 0;
		while(!cp.PilaVacia())
		{
			while(!cc.ColaVacia()&&cc.Primero()!=cp.Tope())
			{
				cc.DesEncolar();
				i++;
			}
			if(cc.ColaVacia())//vacie toda la cola y no encontre ningun valor de la pila
			{
				return false;		
			}
			else
			{
				if(cc.Primero()==cp.Tope())
				{
					cp.Desapilar();
					cc.InicializarCola();
					CopiarCola(c,cc);
					while(i!=0)
						{
							cc.DesEncolar();
							i--;
						}
				}
			}
		}
		
		return true;
	}
	
	public static boolean SonABBsIguales(ABBTDA a1, ABBTDA a2)
	{
		if(a1.ArbolVacio()&&a2.ArbolVacio())
			return true; //dos arboles vacios tienen misma forma
		
		if((a1.ArbolVacio()&&!a2.ArbolVacio())||(!a1.ArbolVacio()&&a2.ArbolVacio()))
			return false;//si no tienen la misma forma no son iguales
		else
			return SonABBsIguales(a1.HijoIzq(),a2.HijoIzq()) && SonABBsIguales(a1.HijoDer(),a2.HijoDer());
	}
	
	public static int ElementosHastaNiveln(ABBTDA a, int k)
	{		
		if(a.ArbolVacio())
			return 0;
		
		if(k==1)//llegue al nivel que estoy buscando
			return 1;
			
		return ElementosHastaNiveln(a.HijoIzq(),k--)+ElementosHastaNiveln(a.HijoDer(),k--)+1;
	}
	
	public static boolean PerteneceAlABB(ABBTDA a, int k)
	{
		if(a.ArbolVacio())
			return false;
		else
		{
			if(a.Raiz()==k)
			return true;
			else
				if(a.Raiz()>k)
					return PerteneceAlABB(a.HijoIzq(),k);
				else
					return PerteneceAlABB(a.HijoDer(),k);
		}
	}		
	
	public static boolean EsHoja(ABBTDA a, int k)
	{
		if(a.ArbolVacio())
			return false;
		else
		{
			if(a.Raiz()==k && a.HijoIzq().ArbolVacio()&&a.HijoDer().ArbolVacio())
				return true;
			else
			{
				if(a.Raiz()>k)
					return EsHoja(a.HijoIzq(),k);
				else
					return EsHoja(a.HijoDer(),k);
			}
		}
	}
	
	public static int ProfElemento(ABBTDA a, int k)
	{
		if(a.ArbolVacio())
			return 0;
		else
			if(a.Raiz()==k)
				return 1;
			else
			{
				if(a.Raiz()>k)
					return ProfElemento(a.HijoIzq(), k) + 1;
				else
					return ProfElemento(a.HijoDer(),k) + 1;
			}
	}
	
	public static int MenorElementoABB(ABBTDA a)
	{
		if(a.ArbolVacio())
			return -1;
		else
			if(a.HijoIzq().ArbolVacio()&&a.HijoDer().ArbolVacio())//es la hora mas chica del arbol
				return a.Raiz();
			else
				return MenorElementoABB(a.HijoIzq());
	}
	
	public static int CantElementosABB(ABBTDA a)
	{
		if(a.ArbolVacio())
			return 0;
		else
			return CantElementosABB(a.HijoIzq())+CantElementosABB(a.HijoDer())+1;
	}
	
	public static int SumarElementosABB(ABBTDA a)
	{
		if(a.ArbolVacio())
			return 0;
		else
			return SumarElementosABB(a.HijoIzq())+SumarElementosABB(a.HijoDer())+a.Raiz();
	}

	public static int CantidadHojasABB(ABBTDA a)
	{
		if(a.ArbolVacio())
			return 0;
		if(a.HijoIzq().ArbolVacio()&&a.HijoDer().ArbolVacio())
			return 1;
		
		return CantidadHojasABB(a.HijoIzq())+CantidadHojasABB(a.HijoDer());
	}
	
	public static int AlturaABB(ABBTDA a)
	{
		if(a.ArbolVacio())
			return -1;
		
		if(!a.ArbolVacio())
		{
			int izq = AlturaABB(a.HijoIzq());
			int der = AlturaABB(a.HijoDer());
			return izq>der? izq+1:der+1;
		}
		return 0;
	}
	
	public static boolean ABBconIgualForma(ABBTDA a,ABBTDA b)
	{
		if(a.ArbolVacio()&&b.ArbolVacio())
			return true;
		
		if((a.HijoIzq().ArbolVacio()&&!b.HijoIzq().ArbolVacio())||b.HijoDer().ArbolVacio()&&!a.HijoDer().ArbolVacio())
			return false;
		else
			return ABBconIgualForma(a.HijoIzq(),b.HijoIzq()) && ABBconIgualForma(a.HijoDer(),b.HijoDer());
	}
	
	public static boolean ABBIguales(ABBTDA a, ABBTDA b)
	{
		if(a.ArbolVacio()&&b.ArbolVacio())
			return true;
		else
			if(a.ArbolVacio()&&!b.ArbolVacio()||!a.ArbolVacio()&&b.ArbolVacio())
				return false;
		
		if(a.Raiz()==b.Raiz())
			return ABBIguales(a.HijoIzq(),b.HijoIzq()) && ABBIguales(a.HijoDer(),b.HijoDer());
		else
			return false;
	}
	
	public static int ABBNodosEnNivel(ABBTDA a, int k)
	{
		if(a.ArbolVacio())
			return 0;
		
		if(k==1)
			return 1;
		
		return ABBNodosEnNivel(a.HijoIzq(),k--) + ABBNodosEnNivel(a.HijoDer(),k--);
	}
	
	public static int ContarNodosABB(ABBTDA a,int k)
	{
		if(a.ArbolVacio())
			return 0;
		
		if(k>0 && !a.ArbolVacio())
			{
			k--;
			return ContarNodosABB(a.HijoIzq(),k) + ContarNodosABB(a.HijoDer(),k)+1;
			}
		
		return 0;
	}
	
	public static ConjuntoTDA ABBElementosMayoresQk(ABBTDA a,int k,ConjuntoTDA conj)
	{
		
		if(a.ArbolVacio())
			return conj;
		
		if(!a.ArbolVacio())
		{
			if(a.Raiz()>k){
				conj.Agregar(a.Raiz());
				return Metodos.UnionConjunto(ABBElementosMayoresQk(a.HijoDer(),k,conj), ABBElementosMayoresQk(a.HijoIzq(),k,conj));
			}
			else
				return Metodos.UnionConjunto(ABBElementosMayoresQk(a.HijoDer(),k,conj), ABBElementosMayoresQk(a.HijoIzq(),k,conj));
		}
		return conj;
	}
	///////////// GRAFOSS/////////////////
	
	/*
	 * ConjuntoTDA Predecesores (Grafo g, int v)
	 * Crear conjunto retorno
	 * ConjuntoTDA vertices = g.Vertices();
	 * if(vertices.pertences(v)
	 *{
	 *	while(!vertices.Conjuntovacio())
	 *		{
	 *			int elegido = vertices.Elegir();
	 *			vertices.Sacar(elegido);
	 *			if(g.ExisteArista(elegido,v)
	 *				{
	 *				retorno.Agregar(elegido)
	 *				}
	 *			
	 *		}
	 *}
	 */
	
}//Llave de cierre Clase metodos
	
	
