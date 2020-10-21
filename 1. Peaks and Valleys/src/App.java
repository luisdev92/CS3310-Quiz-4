
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
	public static int[] generateRandomArray(int size) {
		int[] arr = new int[size];
		Random rand = new Random();
		
		for(int i = 0; i < size; i++) {
			arr[i] = rand.nextInt(size);
		}
		
		return arr; 
	}
	
	public static void main(String[] args) {		
		
		int[] list = generateRandomArray(100000); 
		
		
		long start = System.currentTimeMillis();
		
		runAlgorithm(list); 
		
		long end = System.currentTimeMillis(); 
		
		System.out.println("Running Time: " + (end - start) + "ms"); 
	}
	
	public static void runAlgorithm(int[] list) {
		List<Integer> peaks = new ArrayList<>(); 
		List<Integer> valleys = new ArrayList<>();
		
		for (int i = 0; i < list.length; i++) {
			if (i + 1 == list.length) 
				peaks.add(list[i]);
			else if (list[i] > list[i + 1]) 
				peaks.add(list[i]); 
			else 
				valleys.add(list[i]); 
		}
		
		int i = 0, j = 0, k = 0; 
		
		int[] arr3 = new int[peaks.size() + valleys.size()];
		
		while (i < peaks.size() && j < valleys.size()) {
			arr3[k++] = peaks.get(i++); 
			arr3[k++] = valleys.get(j++);
		}
		
		while (i < peaks.size()) 
			arr3[k++] = peaks.get(i++); 
		
		while(j < valleys.size())
			arr3[k++] = valleys.get(j++); 
		
		System.out.println("Sample Size N= " + list.length);
		for(i = 0; i < arr3.length; i++)
			System.out.print( arr3[i] + " "); 
		
		System.out.println(); 
	}
}