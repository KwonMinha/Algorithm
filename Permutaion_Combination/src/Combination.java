/**
 * @author Minha Gwon
 * @date 2020. 4. 25.
 * 
 * 조합 : n 개 중에서 r 개 선택
 * r(뽑는 갯수 1, 2, 3... 늘려가며 뽑음)
 * 
 * Array 사용 
 * 배열 안의 값 임의로 바꿀 수 있음 
 * 둘 다 순서(O) 1. 백트래킹 사용 2. 재귀 사용 
 * 
 * 연습문제 : https://www.acmicpc.net/problem/2309
 * 참고 : https://bcp0109.tistory.com/15?category=848939
 */
 
public class Combination {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
 
        //1. 백트래킹 사용해 구현
        for(int i = 1; i <= n; i++) {
            comb1(arr, visited, 0, n, i);
        }
        
        System.out.println();
        
        //2. 재귀 사용해 구현 
        for(int i = 1; i <= n ;i++) {
            comb2(arr, visited, 0, n, i);
        }
    }
 
    // 백트래킹 사용
    // 사용 예시 : comb1(arr, visited, 0, n, r)
    static void comb1(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        } else {
            for(int i = start; i < n; i++) {
                visited[i] = true;
                
                comb1(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
 
    // 재귀 사용
    // 사용 예시 : comb2(arr, visited, 0, n, r)
    static void comb2(int[] arr, boolean[] visited, int depth, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        }
        
        if(depth == n) {
            return;
        } else {
            visited[depth] = true;
            comb2(arr, visited, depth + 1, n, r - 1);
 
            visited[depth] = false;
            comb2(arr, visited, depth + 1, n, r);
        }
    }
 
    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for(int i=0; i<n; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}