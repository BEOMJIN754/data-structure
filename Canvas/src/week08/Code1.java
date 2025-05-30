package week08;

import java.util.Arrays;

public class Code1 {

	public int sum(int n) {
		int sum=0;
		for (int i=1;i<=n;i++)
			sum=sum+i;
		return sum;
	}

	//     Q1 : Complete sumRecursion	1부터 N 까지의 합
	public int sumRecursion(int n) {
		if(n<=1) return 1;
		else return n + sumRecursion(n-1);
	}

//	//	     Q2 : Complete merge in recursion				
//	public int[] merge(int[] d1, int[] d2) {
//		int [] result = new int[d1.length+d2.length];
//		return merge(result, 0, d1, 0, d2, 0);
//	}

//	private int[] merge(int[] result,int k, int[] d1, int i, int[] d2, int j) {
//
//
//	
//	
//		
//	
//	
//	
//	
//	
//	
//	}

	//	     Q3 : Complete the methods of NewQueue class				
	public static class NewQueue {

		MyArrayList2<Integer> queue = new MyArrayList2<>();

		public void enqueue(int data) {
			queue.add(data);
		}

		public int dequeue() {
			return  queue.remove(0);
		}

		public int peek() {
			 return queue.get(0);
		}

		public void showQueue() {
			System.out.println("Queue : "+queue.toString());
		}
	}

	public static void main(String[] args) {
		Code1 q1 = new Code1();
		System.out.println("\n<Q1> ");
		System.out.println("Sum Iteration : "+q1.sum(15));
		System.out.println("Sum Recursion : "+q1.sumRecursion(15));


		int [] d1= {10, 20, 55, 60, 80};
		int [] d2= {15, 30, 40, 75, 90};
		System.out.println("\n<Q2> ");
//		System.out.println("Merge Result : "+ Arrays.toString(q1.merge(d1, d2)));

		int [] data= {3,5,4,1,7,2,9,8,0,6};
		NewQueue queue = new NewQueue();
		System.out.println("\n<Q3> ");

		for (int i=0; i<data.length;i++) {
			queue.enqueue(data[i]);
			queue.showQueue();
		}
		System.out.println("Peek Result : "+queue.peek());
		for (int i=0; i<data.length;i++) {
			queue.dequeue();
			queue.showQueue();
		}
	}
}
