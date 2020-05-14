/**
 * @author Minha Gwon
 * @date 2020. 5. 14.
 * 
 * 순열 : n 개 중에서 r 개 선택
 */

import java.util.HashSet;
import java.util.Iterator;

public class Permutation_String {
	static HashSet<HashSet<String>> set = new HashSet();
	static int answer = 0;
	
	public static void main(String[] args) {
		String[] arr = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		int n = arr.length;
		String[] output = new String[n];
		
		boolean[] visited = new boolean[n];

		per(arr, output, visited, 0, n, 3);

		System.out.println(answer);
		
		Iterator<HashSet<String>> iterator = set.iterator(); 
		while(true) { 
			System.out.print(iterator.next()); 
			if(iterator.hasNext()) 
				System.out.println(); 
			else break; 
			} 
		System.out.println();
	}

	//순서를 지키면서 n 개중에서 r 개를 뽑는 경우
	static void per(String[] arr, String[] output, boolean[] visited, int depth, int n, int r) {
		if(depth == r) {
			print(output, r);
			return;
		}

		for(int i=0; i<n; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				per(arr, output, visited, depth + 1, n, r);  
				visited[i] = false;
			}
		}
	}


	// 출력 
	static void print(String[] arr, int r) {
		HashSet<String> result = new HashSet();
		
		for(int i=0; i<r; i++) {
			result.add(arr[i]);
			//System.out.print(arr[i] + " ");
		}
		if(!set.contains(result)) {
			answer++;
			set.add(result);
		}
	}
}