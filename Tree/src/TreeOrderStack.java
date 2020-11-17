/**
 * @author Gwon Minha
 * 
 * 스택을 이용해 이진 트리를 반복적 순회한 결과를 출력하는 프로그램 

   입력 : 첫 번째 줄에 트리의 노드 개수 n이 주어진다. ( 1 ≤ n ≤ 100 ) 
         두 번째 줄부터 트리의 정보가 주어진다. 각 줄은 3개의 숫자 a, b, c로 이루어지며, 
         그 의미는 노드 a의 왼쪽 자식노드가 b, 오른쪽 자식노드가 c라는 뜻이다. 
         자식노드가 존재하지 않을 경우에는 -1이 주어진다.

   출력 : 반복적 순회를 한 결과를 출력한다. (중위 순회 결과와 같음)

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

class Node { 
	int data; 
	Node left;
	Node right; 

	Node(int data){ 
		this.data = data;
	}
}

public class TreeOrderStack {
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

	public void stackOrder(Node curr) {
		Stack<Node> stack = new Stack<>(); // 반복적 순회를 위한 스택 생성 
	
		//처음엔 루트 노드부터 시작 
		while (curr != null || !stack.isEmpty()) { 
			//현재 노드의 왼쪽 노드들을 null에 도달할 때까지(마지막 왼쪽 자식 노드까지) 스택에 추가한다. 
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} 

			//null 노드에 도달하면 스택에서 하나씩 삭제한다. 
			curr = stack.pop(); 
			System.out.print(curr.data + " "); //삭제된 노드 방문 -> 삭제된 노드의 값 출력 

			//삭제된 노드를 방문한 후에 이 노드의 오른쪽 노드로 이동한다.
			curr = curr.right;
			//다시 이 노드를 기준으로 왼쪽 노드들을 null에 도달할 때까지 스택에 추가한다.
			// -> 이를 스택이 빌 때까지 반복하면 이진트리를 중위순회할 수 있다.
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeOrderStack t = new TreeOrderStack();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			t.createNode(a, b, c);
		}
		
		t.stackOrder(t.root);
	}

}