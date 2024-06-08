package api;

public interface ABBTDA {
	int Raiz();
	ABBTDA HijoIzq();
	ABBTDA HijoDer();
	boolean ArbolVacio();
	void InicializarArbol();
	void AgregarElem(int x);
	void EliminarElem(int x);
}
