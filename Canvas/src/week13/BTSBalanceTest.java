package week13 ;

import java.util.ArrayDeque;
import java.util.Deque;

public class BTSBalanceTest {

	class Node {
		int key;
		Node left, right;
		
		Node(int d){
			key = d;
			left=null;
			right=null;
		}
		
		public String toString() {
			return ""+key+" ";
		}
	}
	
	Node root;
	
	public BTSBalanceTest() {
		root=null;
	}
	
	public void insert(int d) {
		if(root==null) root=new Node(d);
		else {
//			Node parent = null;
//			Node node = root;
//			while(node!=null) {
//				parent=node;
//				if(d<node.key) node=node.left;
//				else node = node.right;
//			}
//			Node newNode = new Node(d);
//			if(d<parent.key) parent.left = newNode;
//			else parent.right = newNode;
	//advenced code
			insert(root,d);

		
		}

	}
	
	private Node insert(Node node, int d) {
		if(node==null) return new Node(d);
		if(d<node.key) {
			node.left =insert(node.left,d); 
			return node;
		}
		else {
			node.right =insert(node.right,d);
			return node;
		}
		}

	public void showTree() {
		System.out.println();
		showTree(root);
		System.out.println();
	}

	private void showTree(Node p) {
		if (p!=null) {
			showTree(p.left);
			System.out.print(p.toString());
			showTree(p.right);
		}

		}
	
	
	public boolean search(int d) {
		return search(root,d);
	}
	
	private boolean search(Node node, int d) {
		if(node==null) return false;
		if(d==node.key) return true;
		if(d<node.key) return search(node.left,d);
		else return search(node.right,d);
		
	}

	public void delete(int d) {
		Node parent = null;
		Node node = root;
		while(node!=null&&node.key!=d) {
			parent = node;
			if(d<node.key) {node = node.left;}
			else node = node.right;
		}
		if(node!=null) { //node.key == d;
			if(node==root) root=deleteANode(root);
			else {
				if(node.key<parent.key) parent.left=deleteANode(node);
				else parent.right=deleteANode(node);
			}
		}
	}

	private Node deleteANode(Node node) {
		//case1 : no child
		if(node.left==null&&node.right==null) return null;
		//case2 : 1child
		else if(node.left==null&&node.right!=null)return node.right; // node.right !=null
		else if (node.right==null&&node.left!=null)return node.left; //node.left !=null
		//case3
		else {
			//successor or predecessor
			Node s = node.right;
			Node parent = node;
			while(s.left!=null) {
				parent =s;
				s=s.left;
			}
		
			//now, s means successor
			node.key = s.key;
			if(s==node.right)
				node.right = s.right; //=>s is delete
			else
				parent.left = s.right;
			return node;
		}
		// 숙제 프리디세서로 진행 석섹서 => 프리디세서
	}
	
//	private void rotateLeft(Node pp) {
//        if (pp == null || pp.right == null) {
//            return; // 회전할 수 없음
//        }
//
//        Node r = pp.right;
//
//        if (pp == root) {
//            root = r;
//            r.parent = null;
//        } else {
//            // pp의 부모에 연결
//            if (pp == pp.parent.left) {
//                pp.parent.left = r;
//            } else {
//                pp.parent.right = r;
//            }
//            r.parent = pp.parent;
//        }
//
//        // r의 왼쪽 서브트리(있다면) 를 pp의 오른쪽 자식으로 이전
//        pp.right = r.left;
//        if (r.left != null) {
//            r.left.parent = pp;
//        }
//
//        // pp를 r의 왼쪽 자식으로 연결
//        r.left = pp;
//        pp.parent = r;
//    }

	
//	public void showLevel() {
//		if(root!=null) {
//			showLevel(root);
//		}
//	}

//	private void showLevel(Node node) {
//		Deque<Node> q = new ArrayDeque<>();
//		q.add(node);
//		int curLevel =1;
//		while(!q.isEmpty()) {
//			Node p =q.removeFirst();
//			if(curLevel<level(p)) {
//				curLevel++;
//				System.out.println("\nLevel "+curLevel+": ");
//			}
//			System.out.println(p.key);
//			if(p.left!=null)q.add(p.left);
//			if(p.right!=null)q.add(p.right);
//		}
//	}
//	private int level(Node node) {
//		if(node==root)return 0;
//		else return 1+level(node.parent);
//	}

	public static void main(String[] args) {
		int [] keys = {4,7,5,1,0,3,9,2,6,8};
		

		BTSBalanceTest t = new BTSBalanceTest();
		
		for (int i=0; i<keys.length;i++) {
			t.insert(keys[i]);
			t.showTree();
		}
		
		
		System.out.println(t.search(3));
		System.out.println(t.search(11));
		
		t.delete(3);
		System.out.println("\nAfter delete 3 (case2 : only left child)");
		t.showTree();
		t.delete(4);
		System.out.println("\nAfter delete 4 (case3) ");
		t.showTree();
		t.delete(2);
		System.out.println("\nAfter delete 2 (case1 : right end) :");
		t.showTree();
		t.delete(10);
		System.out.println("\nAfter delete 10 (Not Found) :");
		t.showTree();

	}

}
