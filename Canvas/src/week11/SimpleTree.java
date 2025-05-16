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
			
			public String toString() {
				return ""+data;
			}
		}
		
	
		SimpleTree(){
			
		}
		
		public Node makeTree(char ch) {


		}
		public Node makeTree(SimpleTree leftSubtree, char ch, SimpleTree rightSubtree) {


		}
		
		public void showTree() {


		}
		
		private void showTree(Node p) {


		
		
		
		}
		
		public char[] toArray() {
	
			
			return null;
		}

		public int getNodeCount() {

			
			return 0;
		}
		
		public int getHeight() {

		
			return 0;
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