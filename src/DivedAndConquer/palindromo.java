package DivedAndConquer;

public class palindromo {
	
	public Boolean Palindromo(int[] vec, int ini, int fin ) {
		
		//cond de corte
		if(ini>=fin)
			return true;
		else {
			if(vec[ini]!=vec[fin])
				return false;
			else {
				return Palindromo(vec,ini+1,fin-1);
			}
		}
	}
}
