package week10;


public class MyLinkedList2<T> {
    class Node {
        T data;
        Node next;

        Node(T d) {
            data = d;
            next = null;
        }

        public String toString() {
            return data.toString();
        }
    }

    private Node head;
    private int size;

    public MyLinkedList2() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T value) {
        add(size, value); // default to addLast
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            System.out.println("❌ Invalid index: " + index);
            return;
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
        size++;
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size) return null;
        Node p = head;
        for (int i = 0; i < idx; i++) {
            p = p.next;
        }
        return p.data;
    }

    public int size() {
        return size;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public int indexOf(T value) {
        Node p = head;
        int index = 0;
        while (p != null) {
            if (p.data.equals(value)) return index;
            p = p.next;
            index++;
        }
        return -1;
    }

    public T remove(int idx) {
        if (idx < 0 || idx >= size) return null;

        T ret;
        if (idx == 0) {
            ret = head.data;
            head = head.next;
        } else {
            Node p = head;
            for (int i = 0; i < idx - 1; i++) {
                p = p.next;
            }
            ret = p.next.data;
            p.next = p.next.next;
        }
        size--;
        return ret;
    }

    public T remove(Object value) {
        if (head == null) return null;

        if (head.data.equals(value)) {
            T ret = head.data;
            head = head.next;
            size--;
            return ret;
        }

        Node p = head;
        while (p.next != null) {
            if (p.next.data.equals(value)) {
                T ret = p.next.data;
                p.next = p.next.next;
                size--;
                return ret;
            }
            p = p.next;
        }

        return null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void showList() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p != null) {
            sb.append(p.data).append("\n");
            p = p.next;
        }
        return sb.toString().trim();
    }


		
		public static void main(String[] args) {
			
//			String [] data = {"kim","lee","park","choi","jung","kang","cho","yoon","jang"};
			Object [][] data = {{1,"kim"},{2,"lee"},{3,"park"},{4,"choi"},{5,"jung"},
					{6,"kang"},{7,"cho"},{8,"yoon"},{9,"jang"}};
			
			MyLinkedList2<MyData> list = new MyLinkedList2<>();

			for (int i=0;i<data.length; i++) {
				list.add(new MyData((int)data[i][0], (String)data[i][1]));
				list.showList();
			}
			
			System.out.println(list.get(0));
			System.out.println(list.get(5));
			System.out.println(list.get(8));
			
			list.add(0,new MyData(10, "Lim"));
			list.add(5,new MyData(11, "han"));
			list.add(list.size(),new MyData(12, "oh"));
			list.showList();

			System.out.println(list.indexOf(new MyData(2, "lee")));

			System.out.println(list.remove(0));
			list.showList();
			System.out.println(list.remove(5));
			list.showList();
			System.out.println(list.remove(list.size()-1));
			list.showList();
			
			System.out.println(list.indexOf(new MyData(11, "han")));
			System.out.println(list.remove(new MyData(11, "han")));
			list.showList();

			
		}

	}


