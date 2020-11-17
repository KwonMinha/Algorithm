/**
 * @author Minha Gwon
 * @date 2020. 4. 25.
 * 
 * DFS와 BFS 인접리스트(Adjacency List)로 구현 
 * 
 * <input>
   5 5 3
   5 4
   5 2
   1 2
   3 4
   3 1

   <output>
   DFS - 인접리스트
   3 1 2 5 4 

   BFS - 인접리스트
   3 1 4 2 5 

 * 블로그
   DFS - https://minhamina.tistory.com/22
   BFS - https://minhamina.tistory.com/36
 */

import java.util.*;

public class DBFS_List {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점의 개수 
		int m = sc.nextInt(); // 간선의 개수 
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 

		boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 

		LinkedList<Integer>[] adjList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		// 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 1; i <= n; i++) { 
			Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬 
		}

		System.out.println("DFS - 인접리스트로 구현");
		dfs_list(v, adjList, visited);
		Arrays.fill(visited, false);

		System.out.println("\n\nBFS - 인접리스트로 구현");
		bfs_list(v, adjList, visited);
		Arrays.fill(visited, false);
	}


	// DFS - 인접리스트 - 재귀로 구현 
	public static void dfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		visited[v] = true; // 정점 방문 표시
		System.out.print(v + " "); // 정점 출력

		Iterator<Integer> iter = adjList[v].listIterator(); // 정점 인접리스트 순회
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w]) // 방문하지 않은 정점이라면 
				dfs_list(w, adjList, visited); // 다시 DFS
		}
	}

	// BFS - 인접리스트 
	public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true; 
		queue.add(v);

		while(queue.size() != 0) { 
			v = queue.poll(); 
			System.out.print(v + " ");

			Iterator<Integer> iter = adjList[v].listIterator();
			while(iter.hasNext()) { 
				int w = iter.next(); 
				if(!visited[w]) { 
					visited[w] = true; 
					queue.add(w); 
				} 
			}
		}
	}

}
