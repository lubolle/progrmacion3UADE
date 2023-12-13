package api;

public interface GrafoTDA {
	void InicializarGrafo(); 
	// siempre que el grafo este� inicializado y no exista el nodo 
	void AgregarVertice(int v); 
	// siempre que el grafo este� inicializado y exista el nodo 
	void EliminarVertice(int v); // siempre que el grafo este� inicializado
	
	//Te devuelve un conjunto con todos los vertices(nodos)
	ConjuntoTDA Vertices();
	
	// siempre que el grafo este� inicializado, no exista la arista , pero existan ambos nodos 
	void AgregarArista(int vo, int vd, int peso); 
	// siempre que el grafo este� inicializado y exista la arista 
	void EliminarArista(int vo, int vd); 
	// siempre que el grafo este� inicializado y existan los nodos 
	boolean ExisteArista(int vo, int vd);
	// siempre que el grafo este� inicializado y exista la arista
	int PesoArista(int vo, int vd);
}
