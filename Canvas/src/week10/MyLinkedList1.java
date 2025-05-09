package week10;

public class MyLinkedList1 {
	class Node {
		String data;
		Node next;

		Node(String d) {
			data = d;
			next = null;
		}

		public String toString() {
			return "" + data;
		}
	}

	Node head;
	int size;

	public MyLinkedList1() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void add(String value) {
		addFirst(value);
		addLast(value);
	}

	private void addLast(String value) {
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

	private void addFirst(String value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public int indexOf(String value) {
		int index = 0;
		Node p = head;
		while (p != null) {
			if (p.data.equals(value))
				return index;
			else {
				index++;
				p = p.next;
			}
		}
		return -1;
	}

	public void add(int index, String value) {
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
		return size;
	}

	public void clear() {
		head = null;
	}

	public boolean contains(String value) {
		return (indexOf(value) != -1);
	}

	public String get(int idx) {
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

	public void set(int idx, String value) {
		int i = 0;
		Node p = head;
		while (p != null) {
			if (i == idx)
				p.data = value;
			i++;
			p = p.next;
		}
	}

	public String remove(int idx) {
		String ret = null;
		if (checkInndexRange(idx)) {
			if (idx == 0) {
				ret = removeFirst();
			} else {
				int i = 1;
				Node p = head;
				Node q = p.next;
				while (q != null) {
					if (i == idx) {
						ret = q.data;
						p.next = q.next;
						size--;
						break;
					}
					i++;
					p = q;
					q = q.next;
				}
			}
		}
		return ret;
	}

	public String remove(Object value) {
		if (!(value instanceof String)) return null;
		String val = (String) value;

		if (head != null) {
			if (head.data.equals(val)) { // ==> equals, <> -> compareTo
				return removeFirst();
			} else {
				Node p = head;
				Node q = p.next;
				while (q != null) {
					if (q.data.equals(val)) {
						p.next = q.next;
						size--;
						return q.data;
					}
					p = q;
					q = p.next;
				}
			}
		}
		return null;
	}

	private String removeFirst() {
		String ret = null;
		if (head != null) {
			ret = head.data;
			head = head.next;
			size--;
		}
		return ret;
	}

	private boolean checkInndexRange(int index) {
		return (index >= 0 && index <= size());
	}

	public String toString() {
		String str = "";
		Node p = head;
		while (p != null) {
			str = str + p.data + " ";
			p = p.next;
		}
		return str.trim();
	}
	
	public static void main(String[] args) {
	    String[] data = {
	        "Lee", "Kim", "Park", "Choi", "Jung", "Kang", "Yoon", "Lim", "Han", "Shin",
	        "Jo", "Jang", "Oh", "Hwang", "Ahn", "Seo", "Moon", "Yang", "Hong", "Do"
	    };

	    MyLinkedList1 list = new MyLinkedList1();

	    for (int i = 0; i < 4; i++)
	        list.add(data[i]);
	    System.out.println(list.toString());

	    for (int i = 4; i < 10; i++)
	        list.add(data[i]);
	    System.out.println(list.toString());

	    list.remove("Park");
	    list.remove("Kim");

	    list.add(3, "Baek");
	    list.add(list.size(), "Nam");

	    System.out.println(list.toString());

	    list.clear();
	    System.out.println(list.toString());
	}


}
