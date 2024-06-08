package api;

public interface VectorTDA {

	void InicializarVector();
	void agregarEnVector(int x);
	//Siempre que la pila este inicializada
	int obtenerValorVector(int pos);
	//Siempre que la pila este inicializada y no vacia
	void vaciarVector();


}
