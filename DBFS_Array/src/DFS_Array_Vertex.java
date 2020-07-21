/**
 * @author Minha Gwon
 * @date 2020. 7. 21.
 * 
 * 시작 정점에서 종료 정점까지 인접행렬을 바탕으로 DFS 구현 
 * 재귀로 구현 
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class DFS_Array_Vertex {
	public static int N, E;
	public static int[][] edge = {{0, 1}, {0, 2}, {0, 5}, {1, 4}, {1, 3}, {2, 3}, {5, 6}, {4, 7}, {3, 10}, {3, 6}, {6, 7}, {6, 9}, {7, 9}, {6, 8}, {7, 10}, {8, 9}}; ;
	public static int[] weigth = {1, 2, 4, 1, 2, 2, 3, 1, 2, 1, 1, 3, 1, 2, 2, 2};
	public static int[][] adjArray;
	public static boolean[] visited;
	public static Stack<Integer> stack = new Stack<>();


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 11; //정점의 개수 (0 ~ 10)
		E = edge.length; //간선의 개수 
		adjArray = new int[N][N];
		Arrays.sort(edge, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	return o1[0] - o2[0];
		    }
		});
		visited = new boolean[N]; //방문 check
		int start = sc.nextInt(); //탐색을 시작할 정점의 번호 
		int end = sc.nextInt(); //탐색을 종료할 정점의 번호
		
		for(int i = 0; i < E; i++) {
			adjArray[edge[i][0]][edge[i][1]] = 1;
		}

		dfs(start, end);
	}

	public static void dfs(int start, int end) {
		//DFS 구현 부분
		visited[start] = true;
		stack.push(start); //스택에 값을 넣어준다.

		if(start == end){ //목표노드에 왔으면
			//// 스택값 출력
			int count = stack.size(); //스택의 크기를 받을 변수
			for(int i = 0; i < count; i++){
				System.out.print(stack.elementAt(i) + " ");
			}
			System.out.println("출력완료");
			//// 스택값 출력

			stack.pop(); //DFS에서 빠져나올땐  pop을 합니다.
			System.out.println("pop");
			return;
		}

		for(int i = 0; i < N; i++){
			if(adjArray[start][i] == 1 && !visited[i]){
				//노드가 이어져있고 방문을 하지 않았으면
				dfs(i, end);   
				visited[i] = false; //DFS에서 빠져나오면 해당노드는 방문하지 않은 것으로 한다.
			}          
		}
	}
	
	

}

