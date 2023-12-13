package prepPinamar;

public class busquedaBinaria {

	public int busqBinaria(int[] arr, int key) {
	    int start = 0;
	    int end = arr.length - 1;

	    while (start <= end) {
	        int mid = (start + end) / 2;

	        if (arr[mid] == key) {
	            return mid;
	        } else if (arr[mid] < key) {
	            start = mid + 1;
	        } else {
	            end = mid - 1;
	        }
	    }

	    return -1; // elemento no encontrado
	}
//complejidad n log n
}
