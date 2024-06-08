package Implementacion;
import api.VectorTDA;

public class VectorMIO implements VectorTDA {
	int S[];
	int indice;
	@Override
	public void InicializarVector() {
		S = new int[50];
		// TODO Auto-generated method stub
	}

	@Override
	public void agregarEnVector(int x) {
		
		S[indice] = x;
		indice++;
		
	}

	@Override
	public int obtenerValorVector(int pos) {
		// TODO Auto-generated method stub
		return S[pos];
		
	}

	@Override
	public void vaciarVector() {
		// TODO Auto-generated method stub
		indice =0;
	}






}
