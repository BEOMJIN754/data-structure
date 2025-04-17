package practice;

import java.util.Arrays;

public class Fibo {
	int[] memo;
	int count;
	
	public Fibo() {
		memo = new int[50];
		Arrays.fill(memo, -1);
		memo[0]=0; memo[1]=1;
	}
	
	public void resetCount() {
		count = 0 ;
	}
	
	public int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		Fibo f = new Fibo();
		f.resetCount();
		System.out.println("Iteration : "+f.fiboIter(20));
		System.out.println("Iteration Count : "+ f.getCount());
		f.resetCount();
		System.out.println("Recursion : "+f.fiboRec(20));
		System.out.println("Recursion Count : "+f.getCount());
		f.resetCount();
		System.out.println("Recursion + Memoization : "+f.fiboRecMemo(20));
		System.out.println("Memoization Count : "+f.getCount());
	}

	private int fiboRecMemo(int n) {
		count++;
		if(memo[n]!=-1) return memo[n];
		memo[n]=fiboRecMemo(n-1)+fiboRecMemo(n-2);
		return memo[n];
	}

	private int fiboRec(int n) {
		count++;
		if(n<2)return memo[n];
		else {
			if(memo[n-1]==-1) memo[n-1]=fiboRec(n-1);
			if(memo[n-2]==-1)memo[n-2]=fiboRec(n-2);
			return memo[n-1]+memo[n-2];
		}
	}

	private int fiboIter(int n) {
		count++;
		int[] temp = new int[n+1];
		temp[0]=0;
		temp[1]=1;
		
		for(int i=2;i<=n;i++) {
			temp[i] = temp[i-1]+temp[i-2];
		}
		return temp[n];
	}
	
	
}
