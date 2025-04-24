package practice;


public class MyStack {
	
	public MyStack(int n) {
		
	}
	
	public void push(int value) {
		
	}
	
	public int pop() {
		
		return 0;
	}
	
	public void showStack() {
		
	}

	
	public static void main(String[] args) {
		int [] data= {3,5,4,1,7,2,9,8,6,0};
		
		
		MyStack stack = new MyStack(10);
		
		for (int i=0; i<data.length;i++) {
			stack.push(data[i]);
			stack.showStack();
		}
		
		for (int i=0; i<data.length;i++) {
			stack.pop();
			stack.showStack();
		}
		
	}

}
