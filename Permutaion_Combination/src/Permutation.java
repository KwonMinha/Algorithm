/**
 * @author Minha Gwon
 * @date 2020. 4. 25.
 * 순열
 * 블로그 : https://minhamina.tistory.com/37
 */

public class Permutation {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4}; //순열을 만들 배열 
		int n = arr.length; //배열의 길이 
		int[] output = new int[n]; //순열 출력을 위한 배열 
		boolean[] visited = new boolean[n]; //중복해서 뽑지 않기 위해 방문했는지를 체크하는 배열 

		System.out.println("-------- 1. Swap ---------");
		per1(arr, 0, n, 3);

		System.out.println("\n-------- 2. DFS ---------");
		per2(arr, output, visited, 0, n, 2); //r = 3, 3개를 뽑을 것 
	}

	//1. Swap 함수를 이용해 구현 - 순서 없이 n 개중에서 r 개를 뽑는 경우
	static void per1(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			print(arr, r);
			return;
		}

		for(int i=depth; i<n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) { //두 배열의 값을 바꾸는 Swap 함수 
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	//2. DFS를 이용해 구현  - 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
	static void per2(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if(depth == r) {
			print(output, r); //순열 출력을 위한 print 함수 
			return;
		}

		for(int i=0; i<n; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				per2(arr, output, visited, depth + 1, n, r);    
				visited[i] = false;
			}
		}
	}

	// 배열 출력
	static void print(int[] arr, int r) {
		for(int i=0; i<r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}