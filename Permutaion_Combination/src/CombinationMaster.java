import java.util.Scanner;

public class CombinationMaster {
	public static int N, R;
	public static int[] indexArr;
	public static int[] valueArr;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();
		indexArr = new int[N];
		valueArr = new int[N];
		visited = new boolean[N];

		//customArr에 넣을 값 입력 받음 
		for(int i = 0; i < N; i++) {
			valueArr[i] = sc.nextInt();
		}

//		indexComb(0, R, 0);
//		System.out.println();
//		
//		visitedComb(R, 0);
//		System.out.println();
//		
//		backVisitedComb(R, 0);
//		System.out.println();
		
		indexComb2(0, 0);
	}

	//index 변수와 재귀를 이용해 구현 
	public static void indexComb(int index, int r, int target) {
		if(r == 0) { //r개를 다 뽑았으니 종료 = 조합 완성!
			for(int i = 0; i < R; i++) 
				System.out.print(valueArr[indexArr[i]] + " ");
			System.out.println();
		} else if(target == N) { //뽑았건 안 뽑았건 모든 index를 다 봤으니 종료 
			return;
		} else {
			indexArr[index] = target;
			indexComb(index+1, r-1, target+1); //현재 index를 뽑는 경우 / 중복조합일 경우 target
			indexComb(index, r, target+1); //안 뽑는 경우 
		}
	}
	
	public static void indexComb2(int index, int target) {
		if(index == R) {
			for(int i = 0; i < R; i++) 
				System.out.print(valueArr[indexArr[i]] + " ");
			System.out.println();
			
			return;
		}
		
		for(int i = target; i < N; i++) {
			indexArr[index] = i;
			indexComb2(index+1, i+1);
		}
	}

	//visited 배열과 재귀를 이용해 구현 
	public static void visitedComb(int r, int target) {
		if(r == 0) { 
			for(int i = 0; i < N; i++) {
				if(visited[i])
					System.out.print(valueArr[i] + " ");
			}
			System.out.println();
			return;
		}

		if(target == N) {
			return;
		} else {
			visited[target] = true;
			visitedComb(r-1, target+1);
			visited[target] = false;
			visitedComb(r, target+1);
		}
	}

	//visited 배열과 백트래킹을 사용해 구현 
	public static void backVisitedComb(int r, int target) {
		if(r == 0) {
			for(int i = 0; i < N; i++) {
				if(visited[i])
					System.out.print(valueArr[i] + " ");
			}
			System.out.println();
			return;
		} 
		
		for(int i = target; i < N; i++) {
			visited[i] = true;
			backVisitedComb(r-1, i+1);
			visited[i] = false;
		}
	}


}
