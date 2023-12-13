package DivedAndConquer;

public class torresHanoi {
	
		
	    public static void hanoi(int n, int origen, int auxiliar, int destino) {
	        if (n == 1) {
	            System.out.println("Mover disco 1 desde la torre " + origen + " hasta la torre " + destino);
	        } else {
	            hanoi(n - 1, origen, destino, auxiliar);
	            System.out.println("Mover disco " + n + " desde la torre " + origen + " hasta la torre " + destino);
	            hanoi(n - 1, auxiliar, origen, destino);
	        }
	    }
}
