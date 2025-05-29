package week12;


public class BinarySearchTree2 {

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
	
	public BinarySearchTree2() {
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
	    // case1 : no child
	    if (node.left == null && node.right == null) {
	        return null;
	    }
	    // case2 : one child
	    else if (node.left == null) {
	        return node.right;
	    }
	    else if (node.right == null) {
	        return node.left;
	    }
	    // case3 : two children —> predecessor 사용
	    else {
	        Node pred = node.left;
	        Node parentOfPred = node;
	        while (pred.right != null) {
	            parentOfPred = pred;
	            pred = pred.right;
	        }

	        node.key = pred.key;

	        if (parentOfPred == node) {
	            parentOfPred.left = pred.left;
	        } else {
	            parentOfPred.right = pred.left;
	        }

	        return node;
	    }
	}

	public static void main(String[] args) {
		int [] keys = {4,7,5,1,0,3,9,2,6,8};
		

		BinarySearchTree2 t = new BinarySearchTree2();
		
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
