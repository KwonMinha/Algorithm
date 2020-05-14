////순서 없이 n 개중에서 r 개를 뽑는 경우 - SWAP을 이용해 구현 
//static void per2(int[] arr, int depth, int n, int r) {
//	if(depth == r) {
//		print(arr, r); //순열 출력을 위한 print 함수
//		return;
//	}
//
//	for(int i=depth; i<n; i++) {
//		swap(arr, depth, i);
//		per2(arr, depth + 1, n, r);
//		swap(arr, depth, i);
//	}
//}
//
//static void swap(int[] arr, int depth, int i) {
//	int temp = arr[depth];
//	arr[depth] = arr[i];
//	arr[i] = temp;
//}