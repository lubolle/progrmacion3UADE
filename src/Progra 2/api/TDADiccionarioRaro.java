package api;

public interface TDADiccionarioRaro 
{
	void InicializarDiccionarioRaro ();
	// siempre que el diccionario est´e inicializado
	void Agregar( int clave , int valor);
	// siempre que el diccionario est´e inicializado
	void Eliminar( int clave);
	// siempre que el diccionario est´e inicializado
	void EliminarValor( int clave , int valor);
	// siempre que el diccionario est´e inicializado
	ConjuntoTDA Recuperar( int clave);
	// siempre que el diccionario est´e inicializado
	ConjuntoTDA Claves();
}
