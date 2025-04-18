package week07;

public class NewStack01<T> {
	
	MyArrayList2<T> stack;

	public NewStack01() {
		stack =new MyArrayList2<>(); 
	}
	
	public void push(T value) {
		stack.add(value);
	}	
	
	public T pop() {
		return stack.remove(stack.size()-1);
	}
	
	public T peek() {
		return stack.get(stack.size-1);
	}
	
	public void showStack() {
		stack.showList();
	}
	
	public static void main(String[] args) {
		int [] data= {3,5,4,1,7,2,9,8,6,0};
		
		
		NewStack01<Integer> stack = new NewStack01<>();
		
		for (int i=0; i<data.length;i++) {
			stack.push(data[i]);
			stack.showStack();
		}
		
		for (int i=0; i<data.length;i++) {
			stack.pop();
			stack.showStack();
		}
		
		NewStack01<String> stack2 = new NewStack01<>();
		
		stack2.push("aaa");
		stack2.push("aaa");
		stack2.showStack();
		// 타입이 하나밖에 안되네? -> 오버로딩으로 잘 처리 
	}
}
