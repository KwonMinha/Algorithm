
public class SW_SelectionSort {

	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1};
		
		selectionSort(arr, 0);
		
		print(arr);
	}
	
	public static void selectionSort(int[] arr, int start) {
		if(start < arr.length-1) {
			int minIndex = start;
			
			for(int i = start+1; i < arr.length; i++) {
				if(arr[minIndex] > arr[i]) {
					minIndex = i;
				}
			}
			
			swap(arr, start, minIndex);
			
			selectionSort(arr, start+1);
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
