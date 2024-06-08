package api;

public interface PilaTDA {

	//ACA en API declaro los metodos de las pilas
	
	void InicializarPila();
	void Apilar(int x);
	//Siempre que la pila este inicializada
	void Desapilar();
	//Siempre que la pila este inicializada y no vacia
	Boolean PilaVacia();
	// siempre que la pila este inicializada
	int Tope();

}
