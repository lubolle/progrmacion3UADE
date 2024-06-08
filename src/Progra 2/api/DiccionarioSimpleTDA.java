package api;

public interface DiccionarioSimpleTDA {
	
	// siempre que el diccionario est´e inicializado
	void InicializarDiccionario ();
	// siempre que el diccionario est´e inicializado
	void Agregar( int clave , int valor);
	// siempre que el diccionario est´e inicializado
	void Eliminar( int clave);
	// siempre que el diccionario est´e inicializado y la clave exista en el mismo
	int Recuperar( int clave);
	// siempre que el diccionario est´e inicializado
	ConjuntoTDA Claves();
}
