/**
 * @author Minha Gwon
 * @date 2020. 4. 25.
 * 조합
 * 블로그 https://minhamina.tistory.com/38
 */
 
public class Combination {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; //조합을 만들 배열 
        int n = arr.length;
        boolean[] visited = new boolean[n];
 
        //1. 백트래킹 사용해 구현
        for(int i = 1; i <= n; i++) {
            comb1(arr, visited, 0, n, i); //i 값이 뽑을 r의 개수이다.
        }
        
        System.out.println();
        
        //2. 재귀 사용해 구현 
        for(int i = 1; i <= n ;i++) {
            comb2(arr, visited, 0, n, i);
        }
    }
 
    //1. 백트래킹 사용해 구현
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
 
    //2. 재귀 사용해 구현 
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