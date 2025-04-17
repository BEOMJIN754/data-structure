package week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyQueue {

	int[] queue;
	int front, rear,queueSize;
	
	
	public MyQueue(int n) {
		queueSize=n;
		queue = new int[queueSize];
		front =0; rear=1;
	}
	
	public boolean isEmpty() {
		return ((front+1)%queueSize) ==rear;
	}
	
	public boolean isFull() {
		return front ==rear;
	}
	
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println(">>> Queue Full...");
			return;
		}
		else {
			queue[rear]=value;
			rear=(rear+1)%queueSize;
		}
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println(">>> Queue Empty...");
			return-999;
		}
		else {
			front = (front+1)%queueSize;
			return queue[front];
		}
	}
	
	public void showQueue() {
		System.out.println(Arrays.toString(queue));
	}

	public static void main(String[] args) {
		int [] data= {3,5,4,1,7,2,9,8,6,0};
		
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		
		MyQueue queue = new MyQueue(10);
		
		for (int i=0; i<data.length;i++) {
			queue.enqueue(data[i]);
			queue.showQueue();
		}
		
		for (int i=0; i<data.length;i++) {
			System.out.println(queue.dequeue());
		}
	}	
}
