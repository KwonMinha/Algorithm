////1. 백트래킹 사용해 구현
//static void comb1(int[] arr, boolean[] visited, int start, int n, int r) {
//	if(r == 0) {
//		print(arr, visited, n);
//		return;
//	} else {
//		for(int i = start; i < n; i++) {
//			visited[i] = true;
//
//			comb1(arr, visited, i + 1, n, r - 1);
//			visited[i] = false;
//		}
//	}
//}