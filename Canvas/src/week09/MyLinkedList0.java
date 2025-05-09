package week09;

import week07.MyArrayList2;

public class MyLinkedList0 {

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}

		public String toSrting() {
			return "" + data;
		}
	}

	Node head;
	int size;

	public MyLinkedList0() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void add(int value) {
		addFirst(value);
		addLast(value);
	}

	private void addLast(int value) {
		if (isEmpty())
			addFirst(value);
		else {
			Node newNode = new Node(value);
			Node p = head;
			while (p.next != null) {
				p = p.next;
			}
			p.next = newNode;
		}
	}

	private void addFirst(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public int indexOf(int value) {
		int index = 0;
		Node p = head;
		while (p != null) {
			if (p.data == value)
				return ++index;
			else {
				index++;
				p = p.next;
			}
		}
		return -1;
	}

	public void add(int index, int value) { // 0<=index <=size()
		if (checkInndexRange(index)) {
			if (index == 0)
				addFirst(value);
			else {
				Node newNode = new Node(value);
				int i = 1;
				Node p = head;
				while (p.next != null) {
					if (i == index) {
						newNode.next = p.next;
						p.next = newNode;
						size++;
						return;
						
					} else {
						i++;
						p = p.next;
					}
				}

			}
		} else if (index == size()) {
			addLast(value);
		}
	}

	private int size() {
//		int n = 0;
//		Node p = head;
//		while (p != null) {
//			n++;
//			p = p.next;
//		}
//		return n;
		return size;
	}
	
	public void clear() {
		head=null;
	}
	
	public boolean contains(int value) {
		return (indexOf(value)!=-1);
	}

	public int get(int idx) {
		int i =0;
		Node p = head;
		while(p !=null) {
			if(i==idx) return p.data;
			i++;
			p=p.next;
		}
		return -999;
	}
	
	public void set(int idx, int value) {
		int i =0;
		Node p = head;
		while(p !=null) {
			if(i==idx) p.data=value;
			i++;
			p=p.next;
		}
		//error massage
	}
	
	public int remove(int idx) { // return the value
		int ret = -9999;
		if(checkInndexRange(idx)) {
			if(idx==0) {
				ret = removeFirst();
			}
			else {
				int i=1;
				Node p = head;
				Node q = p.next;
				while( q!=null) {
					if(i==idx) {
						ret = q.data;
						p.next=q.next;
						break;
					}
					i++;
					p=q;
					q=q.next;
				}
			}
		}
		return ret;
	}
	
	public int remove(Object value) {
		if(head!=null) {
			if(head.data==(int)value) {
				return removeFirst();
			}
			else {
				Node p = head;
				Node q = p.next;
				while(q!=null) {
					if(q.data==(int)value) {
						p.next=q.next;
						return q.data;
					}
					p=q;
					q=p.next;
				}
			}
		}
		return -9999;
	}
	
	private int removeFirst() {
		int ret = -999;
		if(head!=null) {
			ret = head.data;
			head = head.next;
		}
		return ret;
	}

	private boolean checkInndexRange(int index) {
		if (index >= 0 && index <= size())
			return true;
		else
			return false;
	}

	public String toString() {
		String str = "";
		Node p = head;
		while (p != null) {
			str = str + p.data + " ";
			p = p.next;
		}
		return str;
	}


	public static void main(String[] args) {

		int[] data = { 113, 336, 74, 71, 86, 176, 313, 80, 225, 342, 170, 292, 275, 266, 79, 16, 109, 175, 245, 156, 50,
				61, 277, 167, 81, 24, 76, 186, 78, 101, 301, 62, 152, 219, 294 };

		MyLinkedList0 list = new MyLinkedList0();

		for (int i = 0; i < 4; i++)
			list.add(data[i]); // cf : list[i]=data[i]
		list.toString();
		for (int i = 4; i < 10; i++)
			list.add(data[i]); // cf : list[i]=data[i]
		list.toString();
		list.remove(74);
		System.out.println("After removing 74: " + list.toString());
		
		list.remove((Integer) 336);

		list.add(3, 111);
		list.add(list.size(), 222);

		list.clear();

	}
}
