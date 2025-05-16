package week11;

public class MLLNew<T> {
	private class Node {
		T data;
		Node prev;
		Node next;

		Node(T d) {
			data = d;
			prev = null;
			next = null;
		}

		public String toString() {
			return String.valueOf(data);
		}
	}

	Node head;
	Node tail;
	int size;

	public MLLNew() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size(head);
	}

	private int size(Node p) {
		if(p==null) {
			return 0;
		}
		else return 1+size(head.next);
	}

	public void clear() {
		head = tail = null;
		size = 0;
	}

	public void add(T value) {
		addLast(value);
	}

	public void addFirst(T value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public void addLast(T value) {
		Node newNode = new Node(value);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	public void add(int idx, T value) {
		if (idx < 0 || idx > size)
			throw new IndexOutOfBoundsException();
		if (idx == 0) {
			addFirst(value);
		} else if (idx == size) {
			addLast(value);
		} else {
			Node newNode = new Node(value);
			Node p = head;
			for (int i = 0; i < idx; i++) {
				p = p.next;
				newNode.next = p;
				newNode.prev = p.prev;
				p.prev.next = newNode;
				p.prev = newNode;
				size++;
			}
		}
	}

	public T get(int idx) {
		int i = 0;
		Node p = head;
		while (p != null) {
			if (i == idx)
				return p.data;
			i++;
			p = p.next;
		}
		return null;
	}

	public void set(int idx, T value) {
		if (idx < 0 || idx >= size)
			throw new IndexOutOfBoundsException();
		Node p = head;
		for (int i = 0; i < idx; i++) {
			p = p.next;
		}
		p.data = value;
	}

	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	public int indexOf(T value) {
		Node p = head;
		int idx = 0;
		while (p != null) {
			if (p.data == null ? value == null : p.data.equals(value)) {
				return idx;
			}
			p = p.next;
			idx++;
		}
		return -1;
	}

	public T remove(int idx) {
	    if (!checkIndexRange(idx)) {
	        return null;
	    }
	    Node p = head;
	    for (int i = 0; i < idx; i++) {
	        p = p.next;
	    }
	    return removeANode(p);
	}
		

	private boolean checkIndexRange(int idx) {
		return idx >= 0 && idx < size;
	}
	
	private T removeANode(Node p) { //p!=null
		T ret = p.data;
		
		if(p.prev==null) {
			head=p.next;
		}
		else p.prev.next = p.next;
		
		if(p.next==null) tail=p.prev;
		else p.next.prev=p.prev;
		
		size--;
		return ret;
	}

	private T removeFirst() {
		if(head!=null) {
			return removeANode(head);
		}
		else return null;
	}

	private T removeLast() {
		if(tail!=null) {
			return removeANode(tail);
		}
		else return null;
	}
	
	public boolean remove(T value) {
		Node p = head;
		while(p!=null) {
			if(p.data.equals(value)) {
				removeANode(p);
				return true;}
			else p=p.next;
			}
		return false;
		}

//	public boolean remove(T value) {
//		Node p = head;
//		while (p != null) {
//			if (p.data == null ? value == null : p.data.equals(value)) {
//				if (p == head) {
//					removeFirst();
//				} else if (p == tail) {
//					removeLast();
//				} else {
//					p.prev.next = p.next;
//					p.next.prev = p.prev;
//					size--;
//				}
//				return true;
//			}
//			p = p.next;
//		}
//		return false;
//	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node p = head;
		while (p != null) {
			sb.append(p.data).append("  ");
			p = p.next;
		}
		return sb.toString();
	}

	public void showList() {
		System.out.println(toString());
	}

	public static void main(String[] args) {

		Object[][] data2 = { { 1, "kim" }, { 2, "lee" }, { 3, "park" }, { 4, "choi" }, { 5, "jung" }, { 6, "kang" },
				{ 7, "cho" }, { 8, "yoon" }, { 9, "jang" } };
		MLLNew<MyData> list2 = new MLLNew<>();
		for (int i = 0; i < data2.length; i++) {
			list2.add(new MyData((int) data2[i][0], (String) data2[i][1]));
			list2.showList();
		}
		System.out.println(list2.get(0));
		System.out.println(list2.get(5));
		System.out.println(list2.get(8));
		list2.add(0, new MyData(10, "Lim"));
		list2.add(5, new MyData(11, "han"));
		list2.add(list2.size(), new MyData(12, "oh"));
		list2.showList();
		System.out.println(">>>  " + list2.indexOf(new MyData(2, "lee")));
		System.out.println(list2.remove(0));
		list2.showList();
		System.out.println(list2.remove(5));
		list2.showList();
		System.out.println(list2.remove(list2.size() - 1));
		list2.showList();
		System.out.println(list2.indexOf(new MyData(11, "han")));
		System.out.println(list2.remove(new MyData(11, "han")));
		list2.showList();
	}
}
