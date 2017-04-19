import java.util.Random;

public class scint {
	
	public static void main(String[] args) {
		int n;
		int M1[][];
		n = Integer.parseInt(args[0]);
		M1= new int[n][n];
		System.out.println(n);
		Matrixx.generateRandomFloatMatrix(M1);
		Matrixx.printMatrix(M1);
		System.out.println();
		Matrixx.generateRandomFloatMatrix(M1);
		Matrixx.printMatrix(M1);
		System.out.println();
	}
}
class Matrixx {
	
	public static void generateRandomFloatMatrix(int arr[][]) {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = rand.nextInt(10000);
			}
		}
	}
	
	public static void printMatrix(int arr[][]) {
		for (int[] fs : arr) {
			for (int f : fs) {
				System.out.print(f+" ");
			}
			System.out.println();
		}
	}
}

