package week6;

import lib.MyStack;

public class StackApp {
	
	public static void main(String[] args) {
		int [] data= {3,5,4,1,7,2,9,8,6,0};
		
		
		MyStack<Integer> stack = new MyStack<>(10);
		
		for (int i=0; i<data.length;i++) {
			stack.push(data[i]);
			stack.showStack();
		}
		
		for (int i=0; i<data.length;i++) {
			stack.pop();
			stack.showStack();
		}
		
		MyStack<String> stack2 = new MyStack<>(5);
		
		stack2.push("aaa");
		stack2.push("aaa");
		stack2.showStack();
		// 타입이 하나밖에 안되네? -> 오버로딩으로 잘 처리 
	}
}
