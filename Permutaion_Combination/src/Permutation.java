/**
 * @author Minha Gwon
 * @date 2020. 4. 25.
 * 
 * 순열 : n 개 중에서 r 개 선택
 * 
 * 배열 안의 값 임의로 바꿀 수 있음 
 * 1. 순서(O) 2. 순서(X)
 * 
 * 연습문제 : https://www.acmicpc.net/problem/10974
 * 참고 : https://bcp0109.tistory.com/14?category=848939
 */

public class Permutation {
	public static void main(String[] args) {
		int n = 5; //배열 개수 
		int[] arr = {1, 2, 3, 4, 7}; // 배열 안에 들어갈 값 
		int[] output = new int[n];
		boolean[] visited = new boolean[n];

		//1. 순서O
		per1(arr, output, visited, 0, n, 3);
		
		//2. 순서X 
		System.out.println();
		
		per2(arr, 0, n, 3);
	}

	//1. 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
	//사용 예시 : per1(arr, output, visited, 0, n, r);
	static void per1(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if(depth == r) {
			print(output, r);
			return;
		}

		for(int i=0; i<n; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				per1(arr, output, visited, depth + 1, n, r);       
				// output[depth] = 0; // 이 줄은 없어도 됨
				visited[i] = false;
			}
		}
	}

	//2. 순서 없이 n 개중에서 r 개를 뽑는 경우
	//사용 예시 : per2(arr, 0, n, r);
	static void per2(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			print(arr, r);
			return;
		}

		for(int i=depth; i<n; i++) {
			swap(arr, depth, i);
			per2(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	// 배열 출력
	static void print(int[] arr, int r) {
		for(int i=0; i<r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}