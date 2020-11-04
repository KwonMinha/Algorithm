/**
 * @author Gwon Minha
 * 
 * 이진트리의 전위, 중위, 후위 순회 결과 출력하는 프로그램 
 * Class 구조체에 노드값, 왼쪽 자식 노드값, 오른쪽 자식 노드값 저장해 구현 
 * 
 *       1
 *      / \
 *     2   3
 *    / \
 *   4   5 
 */

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
		// TODO Auto-generated method stub
		TreeClass t = new TreeClass();
		Node n4 = t.createNode(null, 4, null);
		Node n5 = t.createNode(null, 5, null);
		Node n2 = t.createNode(n4, 2, n5);
		Node n3 = t.createNode(null, 3, null);
		Node n1 = t.createNode(n2, 1, n3);

		t.setRoot(n1);

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
