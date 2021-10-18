
public class SW_Subset {
	// static int[] arr = {-1, 3, -9, 6, 7, -6, 1, 5, 4, -2};
	static int[] arr = {1, 2, 3};
	static int[] output;

	public static void main(String[] args) {
		
		for(int i = 1; i <= arr.length; i++) {
			output = new int[i];
			combination(arr.length, i);
		}
	}
	
	public static void combination(int n, int r) {
		if(r == 0) {
			// calculate();
			print();
		} else if(n < r) {
			System.out.println("n : " + n + ", r : " + r + " -> return");
			return;
		} else {
			output[r-1] = arr[n-1];
			System.out.println("1 ---- r-1 : " + (r-1) + ", n-1 : " + (n-1) + "\n");
			combination(n-1, r-1);
			System.out.println("2 ---- n-1 : " + (n-1) + ", r : " + r + "\n");
			combination(n-1, r);
		}
	}
	
	public static void calculate() {
		int sum = output[0];
		for(int i = 1; i < output.length; i++) {
			sum += output[i];
		}

		if(sum == 0) {
			print();
		}
	}
	
	public static void print() {
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println("\n");
	}

}
