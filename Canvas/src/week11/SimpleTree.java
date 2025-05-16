package week11;

public class SimpleTree {

		class Node {
			char data;
			Node left;
			Node right;
			
			Node(char d){
				data=d;
				left=null;
				right=null;
			}
			
			Node(Node lc,char d,Node rc){
				data=d;
				left=lc;
				right=rc;
			}
			
			public String toString() {
				return ""+data;
			}
		}
		
		Node root;
		char[] array;
		SimpleTree(){
			root = null;
			array = new char[20];
		}
		
		public Node makeTree(char ch) {
			root  =new Node(ch);
			return root;
		}
		public Node makeTree(SimpleTree leftSubtree, char ch, SimpleTree rightSubtree) {
//			root = new Node(ch);
//			root.left = leftSubtree.root;
//			root.right = rightSubtree.root;
			
			root = new Node(leftSubtree.root,ch,rightSubtree.root);
			return root;

		}
		
		public void showTree() {
			System.out.println("\n<Tree in Nodes>");
			showTree(root);
			System.out.println();
		}
		
		private void showTree(Node p) {
			if(p!=null) {
				showTree(p.left);
				System.out.print(p.data);
				showTree(p.right);
			}
		}
		
		public void toArray() {
			toArray(root,1);
			System.out.println("\n<Tree in Array>");
			for(int i=1;i<=7;i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
		}

		private void toArray(Node root2, int i) {
			if(root2!=null) {
				array[i]=root2.data;
				toArray(root2.left,i*2);
				toArray(root2.right,i*2+1);
			}
		}

		public int getNodeCount() {

			
			return 0;
		}
		
		public int getHeight() {
			return getHeight(root);
		}

		private int getHeight(Node p) {
			if(p==null)return 0;
			else return 1+Math.max(getHeight(p.left),getHeight(p.right));
		}

		public boolean contains(char d) {


			return true;
		}

		public static void main(String[] args) {
			// a*b+c%d
		
			SimpleTree t1= new SimpleTree(); t1.makeTree('a');
			SimpleTree t2= new SimpleTree(); t2.makeTree('b');
			SimpleTree t3= new SimpleTree(); t3.makeTree('c');
			SimpleTree t4= new SimpleTree(); t4.makeTree('d');

			SimpleTree t5= new SimpleTree(); t5.makeTree(t1, '*', t2);
			SimpleTree t6= new SimpleTree(); t6.makeTree(t3, '%', t4);
			
			SimpleTree t7= new SimpleTree(); t7.makeTree(t5, '+', t6);
			
			t7.showTree();
			t7.toArray();
			
			System.out.println(t7.getNodeCount());
			System.out.println(t7.getHeight());
			
			System.out.println(t7.contains('a'));
			System.out.println(t7.contains('k'));
			

		}

	}