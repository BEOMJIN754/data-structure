package week07;

import java.util.Arrays;

public class MyArrayList0 implements MyList {

	int[] arr;
	int capacity;
	int size;

	public MyArrayList0(int n) {
		capacity = n;
		arr = new int[capacity];
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int indexOf(Object value) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == (int) value)
				return i;
		}
		return -1; // -1 means not found
	}

	@Override
	public void add(Object value) {
		if (!isFull())
			arr[size++] = (int) value;

	}

	private boolean isFull() {
		return (size == capacity);
	}

	@Override
	public void add(int index, Object value) {
		if (checkIndexRange(index)) { // ? 0<=index <- size-1
			if (!isFull()) {
//				for (int i = size - 1; i >= index; i--) 
//					arr[i+1]=arr[i];
					System.arraycopy(arr, index, arr, index + 1, size - index);
					arr[index] =(int) value;
					size++;
				
			}
		} else if (index == size)
			add(value);
	}

	private boolean checkIndexRange(int index) {
		if (index >= 0 && index < size)
			return true;
		else
			return false;
	}

	@Override
	public void clear() {
		Arrays.fill(arr, 0);
		size = 0;
	}

	@Override
	public boolean contains(Object value) { // 우리는 isdexOf 만들어둠 ㅇㅇ
//		for(int i=0;i<size;i++) {
//			if(arr[i]==(int)value)return true;
//		}
//		return false; 
		return (indexOf(value) != -1);
	}

	@Override
	public boolean remove(Object value) {
		int idx = indexOf(value);
		if (checkIndexRange(idx)) {
			for (int i = idx + 1; i < size; i++) 
				arr[i - 1] = arr[i];
				System.arraycopy(arr, idx+1, arr, idx, size-idx-1);
				size--;
			return true;
		}
		else return false;
	}

	@Override
	public Object remove(int index) {
		if (checkIndexRange(index)) {
		//	for (int i = index + 1; i < size; i++) {
//				arr[i - 1] = arr[i];

			//}
		System.arraycopy(arr, index+1, arr, index, size-index-1);
		size--;
			return true;
		}
		else return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int index) {
		if(checkIndexRange(index))
		return arr[index];
		return null;
	}

	@Override
	public void set(int index, Object value) {
		if(checkIndexRange(index))arr[index]=(int)value;
	}

	@Override
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

		MyArrayList0 list = new MyArrayList0(20);

		for (int i = 0; i < 10; i++)
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

	}

	private void showList() {
		System.out.println("Current List Status");
		System.out.println(toString());
	}
}
