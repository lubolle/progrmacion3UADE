package Implementacion;

import api.ColaTDA;

public class ColaPI implements ColaTDA {

	int a[];
	int indice;
	
	public void InicializarCola() {
		a = new int[10];
		indice=0;	
	}

	
	public void Encolar(int x) {
		a[indice] = x;
		indice++;
	}

	
	public void DesEncolar() {
		for ( int i = 0; i < indice -1; i++)
		a[i] = a[i +1];
		indice --;
	}

	
	public Boolean ColaVacia() {
		return (indice==0);
	}

	
	public int Primero() {
		return a[0];
	}

}
