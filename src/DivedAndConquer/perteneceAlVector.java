package DivedAndConquer;

public class perteneceAlVector {
	
	public boolean pertenece (int[] vec, int num, int ini) {
		
		if(vec[ini]==num)
			return true;
		else {
			if(ini<vec.length-1)
			{
				return pertenece(vec, num,ini +1);
			}
			else
				return false;
		}

	}

}
