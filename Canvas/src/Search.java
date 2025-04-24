
public class Search {

	public int seqS(int[] d,int key) {
//		for(int i=0;i<d.length;i++) {
//			if(d[i]==key) {
//				return i;
//			}
//			
//		} return -1;
		
		int index =0;
		while(index<d.length) {
			if(d[index]==key) 
				return index;
			else index++;
		}
		return -1;
	}
	
	public int seqSortedS(int[]d, int key) {
		int index =0;
//		while(index<d.length) {
//			if(d[index]==key)return index;
//			else if(d[index]>key)return-1;
//			else index++;
//		}
//		return -1;
		
		while(index<d.length&&d[index]<=key) {
			if(d[index]==key)return index;
			else index++;
		}
		return -1;
	}
	
	private int binS(int[] d, int key, int s, int e) {
	    if (s > e) return -1; 
	    int mid = (s + e) / 2;

	    if (key == d[mid]) return mid; 
	    else if (key < d[mid]) return binS(d, key, s, mid - 1); 
	    else return binS(d, key, mid + 1, e); 
	}
	
//	public int binS_iter(int[] d, int key) {
//		int start = 0, end = d.length - 1;
//		while (start <= end) {
//			int mid = (start + end) / 2;
//			if (d[mid] == key)
//				return mid;
//			else if (d[mid] < key)
//				start = mid + 1;
//			else
//				end = mid - 1;
//		}
//		return -1;
//	}
	
//	public int binS_memo_arr(int[] d, int key, int s, int e, int[] memo) {
//		if (memo[key] != -2) return memo[key];
//		if (s > e) {
//			memo[key] = -1;
//			return -1;
//		}
//
//		int mid = (s + e) / 2;
//		if (d[mid] == key) {
//			memo[key] = mid;
//			return mid;
//		} else if (key < d[mid]) {
//			int res = binS_memo_arr(d, key, s, mid - 1, memo);
//			memo[key] = res;
//			return res;
//		} else {
//			int res = binS_memo_arr(d, key, mid + 1, e, memo);
//			memo[key] = res;
//			return res;
//		}
//	}

	public int seqSRect(int[]d,int n,int key) {
		if(n==0)return -1;
		else if(d[n-1]==key)return n-1;
		else return seqSRect(d, n-1, key);
	}
	
//	public int seqS_memo_arr(int[] d, int key, int[] memo) {
//		if (memo[key] != -2) return memo[key]; // -2는 "계산 안 됨" 표시
//
//		for (int i = 0; i < d.length; i++) {
//			if (d[i] == key) {
//				memo[key] = i;
//				return i;
//			}
//		}
//		memo[key] = -1;
//		return -1;
//	}
	
	
	
	public static void main(String[] args) {
		int[] data = {10,45,40,20,15,50,25,5,31,35,55};
		int[] sdata = {5,10,15,20,25,30,35,40,45,50,55};
		Search me = new Search();
		
		System.out.println(me.seqS(data, 25));
		System.out.println(me.seqSortedS(sdata, 27));
		
		System.out.println(me.binS(sdata,25,0,sdata.length-1));
		System.out.println(me.seqSRect(data,data.length, 25));
		
//		System.out.println(me.binS_iter(sdata, 25));
	
//		int MAX_KEY = 100;
//		int[] seqMemo = new int[MAX_KEY + 1];
//		int[] binMemo = new int[MAX_KEY + 1];
//		Arrays.fill(seqMemo, -2);  // -2는 초기값
//		Arrays.fill(binMemo, -2);
//
//		Search me = new Search();
//
//		System.out.println(me.seqS_memo_arr(data, 25, seqMemo));
//		System.out.println(me.binS_memo_arr(sdata, 25, 0, sdata.length - 1, binMemo));
	
	
	}



}
