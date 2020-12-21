/**
 * @author Gwon Minha
 * 
 * 클래스로 구현한 이진 트리의 전위, 중위, 후위, 반복, 레벨 순회 결과 출력 프로그램 
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

class Node {
	int data; 
	Node left; 
	Node right;

	Node(int data){ 
		this.data = data;
	}
}

public class TreeOrderMaster {
	public Node root; //초기 root는 null

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

	//전위순회 Preorder : Root -> Left -> Right
	public void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			if(node.left != null) preOrder(node.left);
			if(node.right != null) preOrder(node.right);
		}
	}

	//중위 순회 Inorder : Left -> Root -> Right
	public void inOrder(Node node) {
		if(node != null) {
			if(node.left != null) inOrder(node.left);
			System.out.print(node.data + " ");
			if(node.right != null) inOrder(node.right);
		}
	}

	//후위순회 Postorder : Left -> Right -> Root
	public void postOrder(Node node) {
		if(node != null) {
			if(node.left != null) postOrder(node.left);
			if(node.right != null) postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}

	//반복적 순회 - Stack 사용 
	public void iterativeOrder(Node curr) {
		Stack<Node> stack = new Stack<>(); 

		while (curr != null || !stack.isEmpty()) { 
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} 
			curr = stack.pop(); 
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

	//레벨 순회 - Queue 사용 
	public void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data + " ");

			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right); 
		}
	}

	//레벨별 노드 출력 
	public void levelByLevel(Node root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(); 

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<>();

			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Node node = queue.poll();
				level.add(node.data); 

				if(node.left != null) queue.offer(node.left); 
				if(node.right != null) queue.offer(node.right); 
			}

			list.add(level);
		}

		for (ArrayList<Integer> i : list) {
			System.out.println(i);
		}
	}
	
	public static int getNodeCount(Node root) {
		int count = 0;
		
		if(root != null)
			count = 1 + getNodeCount(root.left) + getNodeCount(root.right);
		
		return count;
	}
	
	public static int getLeafCount(Node root) {
		int count = 0;
		
		if(root != null) {
			if(root.left == null && root.right == null)
				return 1;
			else
				count = getLeafCount(root.left) + getLeafCount(root.right);
		}
		
		return count;
	}
	
	public static int getHeight(Node root) {
		int height = 0;
		
		if(root != null) 
			height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
		
		return height;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeOrderMaster t = new TreeOrderMaster();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			t.createNode(a, b, c);
		}

		System.out.println("전위 순회");
		t.preOrder(t.root);

		System.out.println("\n\n중위 순회");
		t.inOrder(t.root);

		System.out.println("\n\n후위 순회");
		t.postOrder(t.root);

		System.out.println("\n\n반복적 순회");
		t.iterativeOrder(t.root);

		System.out.println("\n\n레벨 순회");
		t.levelOrder(t.root);

		System.out.println("\n\n레벨별 노드");
		t.levelByLevel(t.root);
		
		System.out.println("\n노드의 개수 : " + getNodeCount(t.root));
		
		System.out.println("\n단말 노드의 개수 : " + getLeafCount(t.root));
		
		System.out.println("\n트리의 높이 : " + getHeight(t.root));
	}

}