package Implementacion;

import api.ConjuntoTDA;

public class ConjuntoTA implements ConjuntoTDA {

	int a[];
	int cant;
	
	public void InicializarConjunto() {
		// TODO Auto-generated method stub
		a = new int [100];
		cant = 0;
	}


	public boolean ConjuntoVacio() {
		// TODO Auto-generated method stub
		return cant==0;
	}


	public void Agregar(int x) {
		// TODO Auto-generated method stub
		if(!this.Pertenece(x))
		{
			a[cant] = x;
			cant ++;
		}

	}


	public int Elegir() {
		//Elegir no elige nada, saca solo el utlimo
		return a[ cant - 1];
	}


	public void Sacar(int x) {
		// TODO Auto-generated method stub
		int i=0;
		while(i<cant&&a[i]!=x)
			i++;
		
		if (i<cant)
		{
			a[i]=a[cant-1];
			cant--;
		}
	}


	public boolean Pertenece(int x) {
		int i = 0;
		while (i< cant && a[i]!= x)
		i++;
		return ( i < cant );
	}

}
