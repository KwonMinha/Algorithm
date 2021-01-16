/**
 * @author Minha Gwon 
 * 이진 탐색 트리 
 *
 * 클래스로 구현한 이진 탐색 트리에서의 탐색, 삽입, 삭제 프로그램 
 * Class 구조체에 노드값, 왼쪽 자식 노드값, 오른쪽 자식 노드값 저장해 구현 

   입력 : 첫 번째 줄에 트리의 노드 개수 n이 주어진다. ( 1 ≤ n ≤ 100 ) 
         두 번째 줄에 루트 노드의 값이 주어진다.
         세 번째 줄부터 n-1까지의 노드 값이 주어진다. 

10
35
18
68
7
26
99
3
12
22
30

 */

import java.util.Scanner;

public class BinarySearchTree {
	class Node {
		int data; 
		Node left; 
		Node right;

		Node(int data){ 
			this.data = data;
		}
	}
	
	public Node root;

	// 순환적인 탐색 
	public static Node circularSearch(Node node, int key) {
		if(node == null) {
			return null;
		} 

		if(key == node.data) {
			return node;
		} else if(key < node.data) {
			return circularSearch(node.left, key);
		} else {
			return circularSearch(node.right, key);
		}
	}

	// 반복적인 탐색 
	public static Node repetitiveSearch(Node node, int key) {
		while(node != null) {
			if(key == node.data) {
				return node;
			} else if(key < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}

		return null; // 탐색 실패했을 경우 
	}

	// 노드 삽입 
	public Node insertNode(Node node, int key) {
		if(node == null) { 
			return new Node(key); // 노드가 빈 경우, 새로운 노드 삽입후 반환 
		}
		
		// 그렇지 않으면 순환적으로 트리를 내려감 
		if(key < node.data) {
			node.left = insertNode(node.left, key);
		} else if(key > node.data) {
			node.right = insertNode(node.right, key);
		}
		
		// 변경된 루트 노드 반환 
		return node;
	}

	// 노드 삭제 
	public Node deleteNode(Node root, int key) {
		if(root == null) {
			return root;
		}

		if(key < root.data) { // 키가 루트보다 작다면, 왼쪽 서브 트리에 있는 것 
			root.left = deleteNode(root.left, key);
		} else if(key > root.data) { // 키가 루트보다 크다면, 오른쪽 서브 트리에 있는 것 
			root.right = deleteNode(root.right, key);
		} else { // 키가 루트와 같다면 이 노드를 삭제하면 됨 
			Node temp;
			
			if(root.left == null) { // 1번, 2번의 경우 - 단말 노드인 경우 / 하나의 서브트리만 있는 경우 
				System.out.println("left");
				temp = root.right;
				return temp;
			} else if(root.right == null) {
				System.out.println("right");
				temp = root.left;
				return temp;
			}

			// 3번의 경우 - 두개의 서브 트리가 있는 경우 
			temp = minValueNode(root.right); // 오른쪽 서브 트리에서 가장 작은 값이 후계 노드 

			root.data = temp.data; // 중위 순회시 후계 노드 복사 
			root.right = deleteNode(root.right, temp.data); // 중위 순회시 후계 노드 삭제 
		}

		return root;
	}

	// 오른쪽 서브트리에서 최소 키 값을 가지는 노드 반환 
	public Node minValueNode(Node node) { // 오른쪽 서브트리에서 가장 작은 값 반환 
		Node currentNode = node;

		while(currentNode.left != null) {
			currentNode = currentNode.left; // 맨 왼쪽 단말 노드를 찾으러 내려감 
		}
		return currentNode;
	}

	// 중위 순회 
	public void inOrder(Node node) {
		if(node != null) {
			if(node.left != null) inOrder(node.left);
			System.out.print(node.data + " ");
			if(node.right != null) inOrder(node.right);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BinarySearchTree t = new BinarySearchTree();

		for (int i = 0; i < n; i++) {
			int key = sc.nextInt();
			
			if(circularSearch(t.root, key) == null) {
				t.root = t.insertNode(t.root, key);
			}
		}
		
		System.out.println("\n이진 탐색 트리 중위 순회");
		t.inOrder(t.root);
	
		
		if(repetitiveSearch(t.root, 68) != null) {
			System.out.println("\n\n68 탐색 성공");
		} else {
			System.out.println("\n\n68 탐색 실패");
		}
		
		
//		System.out.println("\n\n1. 단말 노드 삭제 - 30 삭제 ");
//		t.deleteNode(t.root, 30);
//		t.inOrder(t.root);
		
//		System.out.println("\n\n2. 하나의 서브트리만 가진 노드 삭제 - 68 삭제 ");
//		System.out.println(t.deleteNode(t.root, 68).data);
//		t.inOrder(t.root);
		
//		System.out.println("\n\n3. 두개의 서브트리를 가진 노드 삭제 - 18 삭제 ");
//		t.deleteNode(t.root, 18);
//		t.inOrder(t.root);
		
		
	}
}
