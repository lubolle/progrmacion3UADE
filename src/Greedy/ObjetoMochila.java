package Greedy;

import java.util.Comparator;

public class ObjetoMochila {
	    // Atributos
	    private int peso;
	    private int valor;
	    private double VxP;
	
	public ObjetoMochila (int peso, int valor, double VxP) {
	    this.peso = peso;
	    this.valor = valor;
	    this.VxP = VxP;
	}

	public ObjetoMochila() {
		// TODO Auto-generated constructor stub
	}
	
    // Métodos para acceder a los atributos
    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }

    public double getVxP() {
        return VxP;
    }
	
    public class ComparadorPorVxP implements Comparator<ObjetoMochila> {
        @Override
        public int compare(ObjetoMochila o1, ObjetoMochila o2) {
            if (o1.getVxP() < o2.getVxP()) {
                return -1;
            } else if (o1.getVxP() > o2.getVxP()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
