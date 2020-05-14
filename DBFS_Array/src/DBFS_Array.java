/**
 * @author Minha Gwon
 * @date 2020. 4. 25.
 * 
 * DFS와 BFS 인접행렬(Adjacency Array)로 구현 
 * 
 * <input>
   4 5 1
   1 2
   1 3
   1 4
   2 4
   3 4

   <output>
   DFS - 인접행렬 / 재귀로 구현
   1 2 4 3 

   DFS - 인접행렬 / 스택으로 구현
   1 2 4 3 

   BFS - 인접행렬
   1 2 3 4 
 * DFS 참고 https://minhamina.tistory.com/22
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DBFS_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); //정점의 개수 
		int m = sc.nextInt(); //간선의 개수 
		int v = sc.nextInt(); //탐색을 시작할 정점의 번호 

		boolean c[] = new boolean[n + 1]; // 방문 check

		int[][] adjArray = new int[n+1][n+1];

		//두 정점 사이에 여러 개의 간선이 있을 수 있다.
		//입력으로 주어지는 간선은 양방향이다.
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			adjArray[v1][v2] = 1;
			adjArray[v2][v1] = 1;
		}

		System.out.println("DFS - 인접행렬 / 재귀로 구현");
		dfs_array_recursion(v, adjArray, c);
		Arrays.fill(c, false);

		System.out.println("\n\nDFS - 인접행렬 / 스택으로 구현");
		dfs_array_stack(v, adjArray, c, true);
		Arrays.fill(c, false);

		System.out.println("\n\nBFS - 인접행렬");
		bfs_array(v, adjArray, c);
	}


	//DFS - 인접행렬 / 재귀로 구현 
	public static void dfs_array_recursion(int v, int[][] a, boolean[] c) {
		int l = a.length-1;
		c[v] = true;
		System.out.print(v + " ");

		for(int i = 1; i <= l; i++) {
			if(a[v][i] == 1 && !c[i]) {
				dfs_array_recursion(i, a, c);
			}
		}
	}

	//DFS - 인접행렬 / 스택으로 구현 
	public static void dfs_array_stack(int v, int[][] a, boolean[] c, boolean flag) {
		int l = a.length-1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		c[v] = true;
		System.out.print(v + " ");

		while(!stack.isEmpty()) {
			int k = stack.peek();
			flag = false; 

			for(int i = 1; i <= l; i++) {
				if(a[k][i] == 1 && !c[i]) {
					stack.push(i);
					System.out.print(i + " ");
					c[i] = true;
					flag = true;
					break;
				}
			}

			if(!flag) {
				stack.pop();
			}
		}
	}

	//BFS - 인접행렬
	public static void bfs_array(int v, int[][] a, boolean[] c) {
		Queue<Integer> q = new LinkedList<>();
		int n = a.length - 1;

		q.add(v);
		c[v] = true;

		while (!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");

			for (int i = 1; i <= n; i++) {
				if (a[v][i] == 1 && !c[i]) {
					q.add(i);
					c[i] = true;
				}
			}
		}
	}
}
