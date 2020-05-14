/**
 * @author Minha Gwon
 * @date 2020. 4. 25.
 * 
 * 순열 / 중복순열
 * 조합 / 중복조합 (뽑을 갯수만큼 뽐음)
 * 
 * LinkedList 사용해 구현 
 * 리스트안의 값 n까지의 순서대로 주어짐(바꿀 수 없음) 
 * input : 3 2
   (0, 1, 2) 3개의 숫자 생성 그 중 2개를 뽑을 것
 *
 * 저작자 https://limkydev.tistory.com/178
 * 블로그
   순열 - https://minhamina.tistory.com/37
   조합 - https://minhamina.tistory.com/38
*/

import java.util.LinkedList;
import java.util.Scanner;
 
public class PerComb {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //숫자 개수 
        int r = sc.nextInt(); //뽑을 개수 
        
        System.out.println("원소 개수 : " + n + ", 뽑을 개수 : " + r);
        System.out.print("( ");
        for(int i = 0; i < n; i++) {
        	System.out.print(i + " ");
        }
        System.out.println(")");
         
        //순열 (순서있게 배열)
        System.out.println("\n순열");
        LinkedList<Integer> perArr = new LinkedList<Integer>(); 
        int[] perCheck = new int[n];
        permutation(n, r, perArr, perCheck);
        
        //중복순열 (순서있게 배열 + 자기 자신도 포함)
        System.out.println("\n중복순열");
        LinkedList<Integer> rePerArr = new LinkedList<Integer>();   
        rePermutation(n, r, perArr);
         
        //조합 (순서 관심 없고 뽑은 유무만 생각)
        System.out.println("\n조합");
        int[] comArr = new int[r];
        combination(comArr, n, r, 0, 0);
        
        //중복 조합 (순서 관심 없고 뽑은 유무만 생각 + 자기 자신도 포함)
        System.out.println("\n중복조합");
        int[] reComArr = new int[r];
        reCombination(reComArr, n, r, 0, 0);
    }
    
    //순열(순서있게 배열)
    private static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck) {
        if(perArr.size() == r){
            for(int i : perArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(perCheck[i] == 0){
                perArr.add(i); //값을 넣는 부분 
                perCheck[i] = 1;
                permutation(n, r, perArr, perCheck);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        } 
    }
    
    //중복순열 (순서있게 배열 + 자기 자신도 포함)
    private static void rePermutation(int n, int r, LinkedList<Integer> rePerArr) {
        if(rePerArr.size() == r){
            for(int i : rePerArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
         
        for(int i=0; i<n; i++){  
            rePerArr.add(i);
            rePermutation(n, r, rePerArr);
            rePerArr.removeLast();
        } 
    }
    
    //조합 (순서 관심 없고 뽑은 유무만 생각)
    private static void combination(int[] comArr, int n, int r, int index, int target) {
        if(r==0){
            for(int i : comArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        if(target == n)return;
         
        comArr[index] = target;
        combination(comArr, n, r-1, index+1, target+1); //뽑는 경우
        combination(comArr, n, r, index, target+1); //안 뽑는 경우   
    }
    
    //중복 조합 (순서 관심 없고 뽑은 유무만 생각 + 자기 자신도 포함)
    private static void reCombination(int[] reComArr, int n, int r, int index, int target) {
        if(r==0){
            for(int i : reComArr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }       
        if(target == n)return;
         
        reComArr[index] = target;
        reCombination(reComArr, n, r-1, index+1, target);//뽑는 경우
        reCombination(reComArr, n, r, index, target+1);//안 뽑는 경우
    }
 
}