package api;

public interface ConjuntoTDA {
	
		void InicializarConjunto ();
		// siempre que el conjunto este inicializado
		boolean ConjuntoVacio();
		// siempre que el conjunto este inicializado
		void Agregar( int x);
		// siempre que el conjunto este inicializado y no este vacio
		int Elegir();
		// siempre que el conjunto este inicializado
		void Sacar( int x);
		// siempre que el conjunto este inicializado
		boolean Pertenece( int x);

}
