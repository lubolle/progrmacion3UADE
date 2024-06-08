package api;

public interface ColaTDA {

	void InicializarCola();
	void Encolar(int x);
	//Siempre que la pila este inicializada
	void DesEncolar();
	//Siempre que la pila este inicializada y no vacia
	Boolean ColaVacia();
	// siempre que la pila este inicializada
	int Primero();
	
}
