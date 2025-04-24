package middle2023;

public class Md2023 {
	// no.1 : Num & namd, 
	// in. num. :             name :
	
	
	// no.2 : change MyStack with MyArrayList2 for Record type data
	static class MyStack {
		MyArrayList2<String> stack ;
		public int stackPointer() {
			return stack.size();
		}
		public MyStack() {
			stack= new MyArrayList2<>();
		}
		public void push(String d) {
			if(stack.isEmpty())
			stack.addLast(d);;
		}
	
		public String pop() {
			// fill here
			return stack.removeLast();
		}
		public boolean isEmpty() {
			return stack.isEmpty(); 
		}
		public String peek() {
			// fill here
			int idx = stack.size();
			return stack.get(idx-1);
		}
		public void showStack() {
			stack.showList();
		}
	}
	

	
	public static void main(String[] args) {

		// no. 1 : id. num & name !
		
		// no.2 : new MyStack for Record using MyArrayList2
		System.out.println("\n[2] Stack ==================");
		MyStack s = new MyStack();
		System.out.println("\nInitial Stack Status : Empty is "+s.isEmpty());
		s.push( "aaa");
		s.push("bbb");
		s.push("ccc");
		System.out.print("After 3 pushes : ");
		s.showStack();
		System.out.println("\nPeek Test : "+s.peek()+ " >> The size is "+s.stackPointer());
		System.out.println("Pop Test : "+s.pop()+ " >> The size is"+s.stackPointer());
		System.out.print("Stack is : ");
		s.showStack();

	
}
}


