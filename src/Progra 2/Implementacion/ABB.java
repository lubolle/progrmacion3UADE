package Implementacion;

import api.ABBTDA;

public class ABB implements ABBTDA {
	
	class NodoABB{
		int info;
		ABBTDA HijoDer;
		ABBTDA HijoIzq;//Hace que los nodos se comporten como arboles
	}
	
	NodoABB raiz;

	public int Raiz() {
		return raiz.info;
	}


	public ABBTDA HijoIzq() {
		return raiz.HijoIzq;
	}


	public ABBTDA HijoDer() {
		return raiz.HijoDer;
	}


	public boolean ArbolVacio() {
		return raiz == null;
	}


	public void InicializarArbol() {
		raiz = null;
	}
	
	public void AgregarElem(int x) {
		if(raiz ==null) {
			raiz = new NodoABB();
			raiz.info = x;
			raiz.HijoIzq = new ABB();//Creo los nodos de la raiz
			raiz.HijoIzq.InicializarArbol();
			raiz.HijoDer = new ABB();
			raiz.HijoDer.InicializarArbol();
		}else {
			if(raiz.info > x) {
				raiz.HijoIzq.AgregarElem(x);
			}else {
				if(raiz.info<x)
					raiz.HijoDer.AgregarElem(x);
			}
		}
	}
	
	public void EliminarElem(int x) {
		if(raiz != null) {
			// Si se cumple la condicion de abajo es una hoja
			if(raiz.info == x && raiz.HijoIzq.ArbolVacio() && raiz.HijoDer.ArbolVacio()) {
				raiz = null;
			}else {
				if(raiz.info == x && !raiz.HijoIzq.ArbolVacio()){
					raiz.info = this.mayor(raiz.HijoIzq);//Remplazo la info con el mayor de los menores
					raiz.HijoIzq.EliminarElem(raiz.info);
				}
				if(raiz.info == x && raiz.HijoIzq.ArbolVacio()) {
					raiz.info = this.menor(raiz.HijoDer); //Rempla la info con el menor de los mayores
					raiz.HijoDer.EliminarElem(raiz.info);
				}
				if(raiz.info <x) {
					raiz.HijoDer.EliminarElem(x);
				}else {
					raiz.HijoIzq.EliminarElem(x);
				}
			}
		}
	}
	
	/*
	 Implementacion que dio en clase
	 
	 public void Eliminar (int x)
	 {
		if(raiz!=null)
			if(raiz.info==x)
			{
				if(raiz.HijoIzq.ArbolVacio() && raiz.HijoDer.ArbolVacio())
				raiz=null;
				else
				{
					if(!raiz.HijoIzq.Arbolvacio())
					{
						raiz.info=Mayor(raiz.HijoIzq);
						raiz.HijoIzq.Eliminar(raiz.info);
					}
					else
					{
						raiz.info=menor(raiz.HijoDer);
						raiz.HijoDer.Eliminar(raiz.info);
					}
				}
			}
			
			else
			{
				if(raiz.info>x)
					raiz.HijoDer.Eliminar(x);
				else
					raiz.HijoIzq.Eliminar(x);
			}
	 }
	 
	 
	 **/
	
	private int mayor(ABBTDA a) {
		if(a.HijoDer().ArbolVacio()) {
			return a.Raiz();
		}else {
			return mayor(a.HijoDer());
		}
	}
	
	private int menor(ABBTDA a) {
		if (a.HijoIzq().ArbolVacio()) {
			return a.Raiz();
		}else {
		return menor(a.HijoIzq());
		}
	}
	
}