package Implementacion;

import api.PilaTDA;

public class PilaTF implements PilaTDA {
	
	int a[]; //array donde guardo la info de la pila
	int indice; //Me inidica la cantidad de elementos que tengo en la pila
	
	public void InicializarPila() {
		a = new int[10];
		indice = 0;	
	}
	
	public void Apilar(int x) {
		a[indice]=x;
		indice++;
	}

	public void Desapilar() {
		indice--;
	}

	public Boolean PilaVacia() {
		return (indice==0);
	}

	public int Tope() {
		return a[indice-1];
	}

	

}
