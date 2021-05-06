/**
 * @author Gwon Minha
 * 
 * 큐를 이용해 이진 트리를 레벨 순회한 결과와 레벨별 노드들을 출력하는 프로그램 

   입력 : 첫 번째 줄에 트리의 노드 개수 n이 주어진다. ( 1 ≤ n ≤ 100 ) 
         두 번째 줄부터 트리의 정보가 주어진다. 각 줄은 3개의 숫자 a, b, c로 이루어지며, 
         그 의미는 노드 a의 왼쪽 자식노드가 b, 오른쪽 자식노드가 c라는 뜻이다. 
         자식노드가 존재하지 않을 경우에는 -1이 주어진다.

   출력 : 레벨 순회를 한 결과와 레벨별 노드들을 아래 배열의 형태로 출력한다
   		 0 1 2 3 4 5
   		 [ [0],
     	   [1, 2],
     	   [3, 4, 5]
   		 ]
   
   예제 :  

6
0 1 2
1 3 4
2 -1 5
3 -1 -1
4 -1 -1
5 -1 -1

       0
      / \
     1   2
    / \   \
   3   4   5
   
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeOrderLevel {
	static class Node { 
		int data; 
		Node left;
		Node right; 

		Node(int data){ 
			this.data = data;
		}
	}
	
	public Node root; 

	public void createNode(int data, int leftData, int rightData) {
		if(root == null) {
			root = new Node(data);

			if(leftData != -1) {
				root.left = new Node(leftData); 
			}
			if(rightData != -1) {
				root.right = new Node(rightData); 
			}
		} else {
			searchNode(root, data, leftData, rightData);
		}
	}


	public void searchNode(Node node, int data, int leftData, int rightData) { 
		if(node == null) { 
			return;
		} else if(node.data == data) { 
			if(leftData != -1) { 
				node.left = new Node(leftData);
			}
			if(rightData != -1) {
				node.right = new Node(rightData);
			}
		} else {
			searchNode(node.left, data, leftData, rightData);
			searchNode(node.right, data, leftData, rightData); 
		}
	}

	//레벨 순회한 결과 출력 
	public void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data + " ");
			
			if(node.left != null) queue.offer(node.left); // 왼쪽 자식 노드가 있다면 추가 
			if(node.right != null) queue.offer(node.right); // 오른쪽 자식 노드가 있다면 추가 
		}
	}
	
	//레벨별 노드들을 배열로 묶어서 출력 
	public void levelByLevel(Node root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 전체 레벨을 담기 위한 ArrayList
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<>(); //레벨 별 값을 담기 위한 ArrayList
			
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Node node = queue.poll();
				level.add(node.data); //큐에서 꺼낸 노드 level list에 저장 
				
				if(node.left != null) queue.offer(node.left); // 왼쪽 자식 노드가 있다면 추가 
				if(node.right != null) queue.offer(node.right); // 오른쪽 자식 노드가 있다면 추가 
			}
			
			list.add(level); // 한 레벨이 끝날 때마다 레벨별 저장된 값들을 전체 list에 저장 
		}
		
		for (ArrayList<Integer> i : list) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeOrderLevel t = new TreeOrderLevel();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			t.createNode(a, b, c);
		}
		
		System.out.println("레벨 순회 결과 출력");
		t.levelOrder(t.root);
		
		System.out.println("\n레벨별 노드 출력");
		t.levelByLevel(t.root);
	}

}
