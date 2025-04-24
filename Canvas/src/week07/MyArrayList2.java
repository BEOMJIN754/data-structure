package week07;

import java.util.Arrays;

public class MyArrayList2<T> {
	
	final int INITIAL_CAPACITY =5;
	
	T[] arr;
	int capacity;
	int size;

	public MyArrayList2() {
		capacity = INITIAL_CAPACITY;
		arr = (T[]) new Object[capacity];
		size = 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int indexOf(T value) {
		for (int i = 0; i < size; i++) {
			if (arr[i].equals(value))
				return i;
		}
		return -1; // -1 means not found
	}

	public void add(T value) {
		if(isFull())
			grow();
		arr[size++] = value;
	}

	private boolean isFull() {
		return (size == capacity);
	}
	public void add(int index, T value) {
		if (checkIndexRange(index)) { // ? 0<=index <- size-1
			if (isFull()) {
				grow();
			}
			System.arraycopy(arr, index, arr, index + 1, size - index);
			arr[index] = value;
			size++;
			}
		else if(index==size) add(value);
		} 

	private void grow() {
		T[] tempArray = (T[]) new Object[capacity*2];
		for(int i=0;i<capacity;i++) {
			tempArray[i]=arr[i];
		}
		arr=tempArray;
		capacity *=2;
	}

	private boolean checkIndexRange(int index) {
		if (index >= 0 && index < size)
			return true;
		else
			return false;
	}

	public void clear() {
		Arrays.fill(arr, null);
		size = 0;
	}

	public boolean contains(T value) { // 우리는 isdexOf 만들어둠 ㅇㅇ
		return (indexOf(value) != -1);
	}

	public boolean remove(T value) {
		int idx = indexOf(value);
		if (checkIndexRange(idx)) {
				System.arraycopy(arr, idx+1, arr, idx, size-idx-1);
				size--;
			return true;
		}
		else return false;
	}

	public T remove(int index) {
		if (checkIndexRange(index)) {
			T removed = arr[index];
			System.arraycopy(arr, index + 1, arr, index, size - index - 1);
			size--;
			return removed; 
		}
		return null;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if(checkIndexRange(index))
		return arr[index];
		return null;
	}

	public void set(int index, T value) {
		if(checkIndexRange(index))arr[index]=value;
	}

	public String toString() {
		String ret="";
		for(int i=0;i<size;i++) {
			ret = ret + arr[i]+" ";
		}
		return ret;
	}
	
	public static void main(String[] args) {

		int[] data = { 113, 336, 74, 71, 86, 176, 313, 80, 225, 342, 170, 292, 275, 266, 79, 16, 109, 175, 245, 156, 50,
				61, 277, 167, 81, 24, 76, 186, 78, 101, 301, 62, 152, 219, 294 };

		MyArrayList2<Integer> list = new MyArrayList2<>();

		for (int i = 0; i < 4; i++)
			list.add(data[i]); // cf : list[i]=data[i]
		list.showList();
		for (int i = 4; i < 10; i++)
			list.add(data[i]); // cf : list[i]=data[i]
		list.showList();

		
		
		list.set(5, 999); // list[5]=999
		int x = (int) list.get(5); // cf : x = list[5]
		System.out.println("\nx = " + x);

		list.remove((Integer) 336);
		list.showList();

		list.add(3, 111);
		list.showList();
		list.add(list.size(), 222);
		list.showList();

		list.clear();
		list.showList();
		
		MyArrayList2<MyData> list2 = new MyArrayList2<>();
		
		MyData a = new MyData(1,"aaa");
		MyData b = new MyData(2,"bbb");
		MyData c = new MyData(3,"ccc");
		
		list2.add(a);
		list2.add(b);
		list2.add(c);
		
		list2.showList();
		
		list2.contains(a);
		System.out.println(list2.contains(a));
		System.out.println(list2.contains(new MyData(1,"aaa")));
	}

	public void showList() {
		System.out.println("Current List Status");
		System.out.println(toString());
		System.out.println(">>> Current Capacity ="+capacity+" Size = "+size);
	}
	
	
//  public static void main(String[] args) {
//      // MyArrayList1 객체를 담는 리스트 하나 생성
//      MyArrayList1 list1 = new MyArrayList1();
//      list1.add(10);
//      list1.add(20);
//      list1.add(30);
//
//      // 또 다른 MyArrayList1 객체 생성
//      MyArrayList1 list2 = new MyArrayList1();
//      list2.add(100);
//      list2.add(200);
//
//      // 이제 이 두 리스트를 MyArrayList2에 담아보자 (리스트 안에 리스트)
//      MyArrayList2<MyArrayList1> bigList = new MyArrayList2<>();
//
//      bigList.add(list1);
//      bigList.add(list2);
//
//      // 중첩 리스트 출력
//      System.out.println("=== 중첩된 리스트 출력 ===");
//      for (int i = 0; i < bigList.size(); i++) {
//          System.out.println("리스트 " + i + ": " + bigList.get(i));
//      }
//
//      // 예시: 리스트1의 두 번째 값 가져오기
//      int value = (int) bigList.get(0).get(1); // list1의 두 번째 요소
//      System.out.println("\n리스트0의 인덱스1 값: " + value);
//  }
	
	 // 스택들을 저장할 리스트 생성
//    ArrayList<Stack<Integer>> stackList = new ArrayList<>();
//
//    // 첫 번째 스택 생성 및 추가
//    Stack<Integer> stack1 = new Stack<>();
//    stack1.push(10);
//    stack1.push(20);
//    stack1.push(30);
//    stackList.add(stack1);
//
//    // 두 번째 스택 생성 및 추가
//    Stack<Integer> stack2 = new Stack<>();
//    stack2.push(100);
//    stack2.push(200);
//    stackList.add(stack2);
//
//    // 리스트 안의 스택들 출력
//    System.out.println("=== 스택 목록 출력 ===");
//    for (int i = 0; i < stackList.size(); i++) {
//        System.out.println("스택 " + i + ": " + stackList.get(i));
//    }
//
//    // 특정 스택에서 값 꺼내보기
//    int value = stackList.get(0).peek(); // 첫 번째 스택의 top 값
//    System.out.println("\n첫 번째 스택의 top 값: " + value);
//}
}
