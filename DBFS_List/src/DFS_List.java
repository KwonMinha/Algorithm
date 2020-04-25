/**
 * @author Minha Gwon
 * @date 2020. 4. 25.
 * 
 * DFS 인접리스트(Adjacency List)로 구현 
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_List {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); //정점의 개수 
		int m = sc.nextInt(); //간선의 개수 
		int v = sc.nextInt(); //탐색을 시작할 정점의 번호 

		boolean c[] = new boolean[n + 1]; // 방문 check

		LinkedList<Integer>[] adjList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		//두 정점 사이에 여러 개의 간선이 있을 수 있다.
		//입력으로 주어지는 간선은 양방향이다.
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(adjList[i]);
		}

		//DFS - 인접리스트 
		System.out.println("DFS - 인접리스트로 구현");
		dfs_list(v, adjList, c);
		Arrays.fill(c, false);
	}
	

	//DFS - 인접리스트
	public static void dfs_list(int v, LinkedList<Integer>[] a, boolean[] visited) {
		// 재귀로 구현
		visited[v] = true;
		System.out.print(v + " ");

		Iterator<Integer> iter = a[v].listIterator();
		while (iter.hasNext()) {
			int n = iter.next();
			if (!visited[n])
				dfs_list(n, a, visited);
		}
	}

}
