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
		count=0;
	}
	
	public int getCount() {
		return count;
	}
	
	public int fiboIter(int n) {
		int [] val = new int[n+1];
		val[0]=0;
		val[1]=1;
		
		for(int i=2;i<=n;i++) {
			val[i]=val[i-1]+val[i-2];
		}
		return val[n];
	}
	
	public int fiboRec(int n) {
		if(n<2) return memo[n];
		else {
			if(memo[n-1]==-1)memo[n-1]=fiboRec(n-1);
			if(memo[n-2]==-1)memo[n-2]=fiboRec(n-2);
			return memo[n-1]+ memo[n-2];
			
		}
	}
	
	public int fiboRecMemo(int n) {
		if(n<=2)return 1;
		else return fiboRec(n-1)+fiboRec(n-2);
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

}
