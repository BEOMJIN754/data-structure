package week10;

import week10.MyLinkedList2.Node;

public class MyLinkedList<T> {
	class Node{
		T data;
		Node prev;
		Node[] next;
		
		
		Node(T d){
			data =d;
			prev = null;
			next = null;
		}
		public String toString() {
			return ""+data.toString();
		}
	}
	
	Node head, tail;
	int size;
	
	public MyLinkedList() {
		head = null;
		tail = null;
	}
	
	public void add(T value) {
		addFirst(value);
	}

	private void addFirst(T value) {
		Node newNode = new Node(value);
		if(isEmpty()) {
			head = newNode;
			tail = head;
		}
		else {
			newNode=head;
			head.prev=newNode;
			head = newNode;
		}
		size++;
	}
	
	private void addLast(T value) {
		
	}

	public void add(int idx,T value) {
		if (checkIndexRange(idx)||idx==size()) {
			if (idx == 0)
				addFirst(value);
			else if (idx == size()) {
				addLast(value);
				}
			
			else {
				Node newNode = new Node(value);
				Node p = head;
				for(int i=0;i<idx-1;i++)
					p=p.next;
				newNode.prev =p;
				newNode.next=p.next;
				p.next.prev=newNode;
				p.next = newNode;
				size++;
			}
		}
	}
	
	private int size() {
		return size;
	}
	private boolean isEmpty() {
		return head==null;
	}
	
}
