import java.util.Scanner;

public class SW_BabyGin {
	static boolean isFind = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//		int T = sc.nextInt();
		//		sc.nextLine();
		//		
		//		int[] arr = new int[T];
		//		
		//		for(int i = 0; i < T; i++) {
		//			String str = sc.nextLine();
		//			arr[i] = Integer.parseInt(str);
		//		}

		String num = sc.nextLine();
		int[] arr = new int[num.length()];
		for(int i = 0; i < num.length(); i++) {
			arr[i] = num.charAt(i) - '0';
		}

		permutation(arr, 6, 0);

	}

	public static void permutation(int[] arr, int n, int k) {
		if(isFind) {
			return;
		}
		
		if(k == n) {
			print(arr, n);
			babyGin(arr);
		}

		for(int i = k; i < n; i++) {
			swap(arr, k, i);
			permutation(arr, n, k+1);
			swap(arr, k, i);

		}
	}

	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	static void babyGin(int[] arr) {
		boolean[] flag = new boolean[2];
		int flagIndex = 0;
		
		for(int i = 0; i < arr.length; i+=3) {
			// run
			if(arr[i]+1 == arr[i+1] && arr[i]+2 == arr[i+2]) {
				flag[flagIndex] = true;
				flagIndex++;
				continue;
			}
			
			// triplet
			if(arr[i] == arr[i+1] && arr[i+1] == arr[i+2]) {
				flag[flagIndex] = true;
				flagIndex++;
			}
		}
		
		if(flag[0] && flag[1]) {
			System.out.println("Baby-Gin!");
			isFind = true;
		} else {
			System.out.println("No Baby-Gin");
		}
	}

	static void print(int[] arr, int r) {
		for(int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
