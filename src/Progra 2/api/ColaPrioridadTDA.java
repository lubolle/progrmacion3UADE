package api;

public interface ColaPrioridadTDA {
	
	void InicializarCola();
	
	/*siempre que la cola este inicializada
	 * permite agregar un elemento a la cola con una cierta
	prioridad dada. Se supone que la cola est´a inicializada.
	*/
	void AcolarPrioridad( int x, int prioridad);
	
	/*siempre que la cola este inicializada y no este vacia
	permite eliminar el elemento con mayor prioridad en la cola
	(en caso de tener dos elementos con la misma prioridad sale el primero
	ingresado). Se supone como precondicion que la cola no este vacia*/
	void Desacolar();
	
	// siempre que la cola este inicializada y no este vacia
	int Primero();
	
	// siempre que la cola este inicializada
	boolean ColaVacia();
	
	// siempre que la cola este inicializada y no este vacia
	int Prioridad();

}
