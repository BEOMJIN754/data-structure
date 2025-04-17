package lib;


public class MyStack<T> {
	
	Object[] stack;
//	int[] stack;
	int top;
	int stackSize;
	
	public MyStack(int n) {
		stackSize=n;
		stack = new Object[stackSize];
		top=0;
	}
	
	public boolean isEmpty() {
		return (top==0);
	}
	
	private boolean isFull() {
		return (top == stackSize);
	}
//	
//	public void push(T value) {
//		if(isFull()) {
//			System.out.println(">>> Stack Full...");
//			return;
//		}
//		else stack[top++]=value;
//	}
	
	public void push(T value) {
		if(isFull()) {
			System.out.println(">>> Stack Full...");
			return;
		}
		else stack[top++]=value;
	}
	
	//오버로딩은 리턴 밸루가 다른게 아닌 파라미터가 다른 것이다.
//	public int pop() {
//		if(isEmpty()) {
//			System.out.println(">>> Stack Empty...");
//			return -999;
//		}
//		else {
//			return (int) stack[--top];
//		}
//	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.println(">>> Stack Empty...");
			return null;
		}
		else {
			return (T) stack[--top];
		}
	}
	
	public void showStack() {
		for(int i=0;i<top;i++) {
			System.out.print("  "+stack[i].toString());
			
		}
		System.out.println();
	}



}
