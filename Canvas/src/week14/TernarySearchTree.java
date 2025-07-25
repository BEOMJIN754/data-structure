package week14;

import java.util.LinkedList;
import java.util.Queue;

public class TernarySearchTree {
	class Node {
		Integer key1, key2;
		Node left, middle, right, parent;
		Node() {
			key1 = null; key2 = null;
			left = null; middle = null; right = null; parent = null;
		}
		public String toString() {
			return "[" + key1 + "," + key2 + "]";
		}
	}
	Node root;
	public void insert(int input) {
		if (root == null) {
			root = new Node();
			root.key1 = input;
			return;
		}
		Node cur = root;
		while (true) {
			if (input < cur.key1) {
				if (cur.left == null) {
					cur.left = new Node();
					cur.left.key1 = input;
					cur.left.parent = cur;
					return;
				} else {
					cur = cur.left;
				}
			} else {
				if (cur.key2 == null) {
					cur.key2 = input;
					return;
				} else if (input < cur.key2) {
					if (cur.middle == null) {
						cur.middle = new Node();
						cur.middle.key1 = input;
						cur.middle.parent = cur;
						return;
					} else {
						cur = cur.middle;
					}
				} else {
					if (cur.right == null) {
						cur.right = new Node();
						cur.right.key1 = input;
						cur.right.parent = cur;
						return;
					} else {
						cur = cur.right;
					}
				}
			}
		}
	}
	public void showTree() {
		inorder(root);
		System.out.println();
	}

	void inorder(Node n) {
		if (n == null) return;
		inorder(n.left);
		System.out.print(n.key1 + " ");
		if (n.key2 != null) {
			inorder(n.middle);
			System.out.print(n.key2 + " ");
		}
		inorder(n.right);
	}
	public void showLevel() {
		if (root == null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int currentLevel = 0;
		while (!q.isEmpty()) {
			int size = q.size();  // 현재 레벨 노드 수
			System.out.print("level " + currentLevel + " : ");
			for (int i = 0; i < size; i++) {
				Node n = q.poll();
				System.out.print(n + " ");
				if (n.left != null) q.add(n.left);
				if (n.middle != null) q.add(n.middle);
				if (n.right != null) q.add(n.right);
			}
			System.out.println();
			currentLevel++;
		}
	}
	private int level(Node node) {
		if (node == root) return 0;
		return 1 + level(node.parent);
	}
	public static void main(String[] args) {
		int[] data = {45,21,78,97,91,26,11,57,15,49,36,38,86,20,56,17,99,82,71,98};
		TernarySearchTree t = new TernarySearchTree();
		for (int i=0;i<data.length;i++) {
			t.insert(data[i]);
			t.showTree();
		}
		System.out.println();
		t.showLevel();
	}
}
