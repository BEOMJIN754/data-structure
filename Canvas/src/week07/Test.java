package week07;
//중요
public class Test {
	public static void main(String[] args) {
	
		MyArrayList2<MyArrayList1> list = new MyArrayList2<>();
		
		MyArrayList1 a = new MyArrayList1();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		
		MyArrayList1 b = new MyArrayList1();
		b.add(11);
		b.add(21);
		b.add(31);
		
		list.add(a);
		list.add(b);
		
		list.showList();
		
		list.get(0).set(2,30);
		list.showList();
	}

}
