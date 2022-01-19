import java.util.*;

class Node_1991 {
	char data;
	Node_1991 left,right;
	
	public Node_1991(char data) {
		this.data=data;
	}
}

class Tree {
	Node_1991 root;
	
	public void add(char data, char left_data, char right_data) {
		// 루트노드가 비었다면 루트에 data, 왼쪽 자식에 left_data, 오른쪽 자식에 right_data를 삽입한다.
		if(root==null) {
			if(data!='.') // 루트
				root=new Node_1991(data);
			if(left_data!='.') // 왼쪽 자식
				root.left=new Node_1991(left_data);
			if(right_data!='.') // 오른쪽 자식
				root.right=new Node_1991(right_data);
		}
		// 루트가 널이 아니라면 탐색
		else
			Search(root,data,left_data,right_data);
	}
	
	public void Search(Node_1991 root, char data, char left_data, char right_data) {
		if(root==null) // 루트가 널이라면 return
			return;
		
		// 루트노드이 데이터가 data라면
		else if(root.data==data) {
			if(left_data!='.') // 왼쪽 노드에 값 삽입
				root.left=new Node_1991(left_data);
			if(right_data!='.') // 오른쪽 노드에 값 삽입
				root.right=new Node_1991(right_data);
		}
		
		// 아니라면 탐색
		else {
			Search(root.left, data, left_data, right_data);
			Search(root.right, data, left_data, right_data);
		}
	}
	
	// 전위순회 : 루트 -> 왼쪽 자식 -> 오른쪽 자식
	public void PreOrder(Node_1991 root) {
		System.out.print(root.data);
		
		if(root.left!=null)
			PreOrder(root.left);
		if(root.right!=null)
			PreOrder(root.right);
	}
	// 중위순회 : 왼쪽 자식 -> 루트 -> 오른쪽 자식
	public void InOrder(Node_1991 root) {
		if(root.left!=null)
			InOrder(root.left);
		
		System.out.print(root.data);
		
		if(root.right!=null)
			InOrder(root.right);
	}
	// 후위순회 : 왼쪽 자식 -> 오른쪽 자식 -> 루트
	public void PostOrder(Node_1991 root) {
		if(root.left!=null)
			PostOrder(root.left);
		
		if(root.right!=null)
			PostOrder(root.right);
		
		System.out.print(root.data);
	}
}

public class BaekJoon_1991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		Tree tree=new Tree();
		for(int i=0;i<n;i++) 
			tree.add(sc.next().charAt(0),sc.next().charAt(0),sc.next().charAt(0));
		
		tree.PreOrder(tree.root);;
		System.out.println();
		tree.InOrder(tree.root);
		System.out.println();
		tree.PostOrder(tree.root);
		System.out.println();
	}

}
