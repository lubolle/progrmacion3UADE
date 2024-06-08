package Implementacion;


import Implementacion.ConjuntoLD;
import api.DiccionarioMultipleTDA;

public class DicMultipleL implements DiccionarioMultipleTDA {

	class NodoClave{
		int clave;
		NodoValor valores; //Origen de este nodo
		NodoClave sigClave;
	}
	
	class NodoValor{
		int valor;
		NodoValor sigValor;
	}
	
	NodoClave origen; //Origen del nodo clave
	
	public void InicializarDiccionario() {
		origen = null;
	}


	public void Agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave( clave); 
		if (nc==null) {
			nc= new NodoClave();
			nc.clave=clave; 
			nc.sigClave= origen; 
			origen = nc;
		}
		
		NodoValor aux = nc.valores;
		while (aux!= null && aux.valor!=valor){
			aux= aux.sigValor;
		}
		if (aux==null){
			NodoValor nv = new NodoValor();
			nv.valor = valor; 
			nv.sigValor = nc.valores; 
			nc.valores = nv; 
		}
	}

	public void Eliminar(int clave) {
		if (origen!= null){
			if (origen.clave == clave){
				origen = origen.sigClave; 
			}else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave !=clave){
					aux = aux.sigClave; 
				} 
				if (aux.sigClave!= null){
					aux.sigClave= aux.sigClave.sigClave;
				}
			}
		}
	}

	public void EliminarValor(int clave, int valor) {
		if (origen!= null){
			if (origen.clave == clave){
				EliminarValorEnNodo(origen , valor);
				if (origen.valores==null){
					origen = origen.sigClave;
				}
			}else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave !=clave){
					aux = aux.sigClave; 
				} 
				if (aux.sigClave!= null){
					EliminarValorEnNodo(aux.sigClave , valor);
					if (aux.sigClave.valores== null) {
						aux.sigClave= aux.sigClave.sigClave;
					}
				}
			}
		}
	}
	
	private void EliminarValorEnNodo(NodoClave nodo, int valor) {
		if (nodo.valores!=null){
			if (nodo.valores.valor == valor){
				nodo.valores = nodo.valores.sigValor;
			}else {
				NodoValor aux = nodo.valores;
				while (aux.sigValor != null && aux.sigValor.valor !=valor){
					aux = aux.sigValor;
				} 
				if (aux.sigValor!= null){
					aux.sigValor= aux.sigValor.sigValor;
				}
			}
		}
	}

	public ConjuntoLD Recuperar(int clave) {
		NodoClave n = Clave2NodoClave(clave);
		ConjuntoLD c = new ConjuntoLD();
		c.InicializarConjunto(); 
		if (n!= null){
			NodoValor aux = n.valores; 
			while (aux != null){
				c.Agregar(aux.valor);
				aux = aux.sigValor;
			} 
		} 
		return c;

	}

	public ConjuntoLD Claves() {
		ConjuntoLD c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoClave aux = origen; 
		while (aux != null){
			c.Agregar(aux.clave);
			aux = aux.sigClave; 
		} 
		return c;
	}
	
	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen;
		while(aux!= null && aux.clave!=clave){
			aux = aux.sigClave;
		} 
		return aux;
	}

}
