package DivedAndConquer;

public class potencia {
	
	public static int Pot (int base, int expo) {
		
	if(expo==2){//Caso base donde el exponente es igual a 2
		return base*base;
	}
	else {
		int quad = Pot(base,expo/2);
		return quad * quad;
		//return Pot(base,expo/2)* Pot(base,expo/2); (No hace falta hacer dos llamados recursivos)
				}
	}
}