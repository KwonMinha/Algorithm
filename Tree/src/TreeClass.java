/**
 * @author Gwon Minha
 * 
 * 클래스로 구현한 이진 트리의 전위, 중위, 후위 순회 결과 출력 프로그램 
 * Class 구조체에 노드값, 왼쪽 자식 노드값, 오른쪽 자식 노드값 저장해 구현 
 
   입력 : 첫 번째 줄에 트리의 노드 개수 n이 주어진다. ( 1 ≤ n ≤ 100 ) 
         두 번째 줄부터 트리의 정보가 주어진다. 각 줄은 3개의 숫자 a, b, c로 이루어지며, 
         그 의미는 노드 a의 왼쪽 자식노드가 b, 오른쪽 자식노드가 c라는 뜻이다. 
         자식노드가 존재하지 않을 경우에는 -1이 주어진다.

   출력 : 첫 번째 줄에 전위순회, 두 번째 줄에 중위순회, 세 번째 줄에 후위순회를 한 결과를 출력한다.

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

import java.util.*;

class Node { //트리의 노드 정보를 저장할 클래스 구조체 
	int data; //노드 값 
	Node left; //왼쪽 자식 노드 참조 값 
	Node right; //오른쪽 자식 노드 참조 값 
}

public class TreeClass {
	public Node root;

	public void setRoot(Node node) {
		this.root = node;
	}

	public Node getRoot() {
		return root;
	}

	public Node createNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;

		return node;
	}

	public static void main(String[] args) {
//		TreeClass t = new TreeClass();
//        Node n4 = t.createNode(null, 4, null);
//        Node n5 = t.createNode(null, 5, null);
//        Node n2 = t.createNode(n4, 2, n5);
//        Node n3 = t.createNode(null, 3, null);
//        Node n1 = t.createNode(n2, 1, n3);
//        
//        t.setRoot(n1);
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeClass t = new TreeClass();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			Node a1 = null;
			Node c1 = null;
			
			
			if(a == -1)
				a = null;
			t.createNode(a, b, c);
			tree[a][0] = b; // 0은 left
			tree[a][1] = c; // 1은 right
		}
		
		
        
        System.out.println("전위 순회");
        t.preOrder(t.getRoot());
        
        System.out.println("\n중위 순회");
        t.inOrder(t.getRoot());
        
        System.out.println("\n후위 순회");
        t.postOrder(t.getRoot());
	}
	
	//전위순회 Preorder : Root -> Left -> Right
	//1 -> 2 -> 4 -> 5 -> 3
	public void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	//중위 순회 Inorder : Left -> Root -> Right
	//4 -> 2 -> 5 -> 1 -> 3
	public void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}

	//후위순회 Postorder : Left -> Right -> Root
	//4 -> 5 -> 2 -> 3 -> 1
	public void postOrder(Node node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}

}