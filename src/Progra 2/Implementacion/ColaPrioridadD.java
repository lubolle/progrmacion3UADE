package Implementacion;

import api.ColaPrioridadTDA;

public class ColaPrioridadD implements ColaPrioridadTDA {
	
	private class NodoPrioridad{
		int dato;
		int prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad inicio;
	
	public void InicializarCola() {
		inicio= null;
	}

	public void AcolarPrioridad(int x, int prioridad) {
		// Creo el nuevo nodo que voy a acolar 
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.prioridad = prioridad;
		nuevo.dato = x;
		
		//Si la cola esta vacia o bien es mas prioritario que 
		//el primero hay que agregarlo al principio 
		
		if(ColaVacia() || prioridad > inicio.prioridad) {
			nuevo.sig = inicio;
			inicio = nuevo;
		}else {
			//Sabemos que inicio no es null 
			NodoPrioridad ant = null; //OJO
			NodoPrioridad act = inicio;
			while(act != null && prioridad<= act.prioridad) {
				ant = act;
				act = act.sig;
			}
			nuevo.sig = act;
			ant.sig = nuevo;
		}
	}


	public void Desacolar() {
		inicio = inicio.sig;
	}


	public boolean ColaVacia() {
		return inicio == null;
	}


	public int Primero(){
		return inicio.dato;
	}
	
	public int Prioridad(){
		return inicio.prioridad;
	}

}
