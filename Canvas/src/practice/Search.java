package practice;

public class Search {
	public static void main(String[] args) {
	    int[] data = {10,45,40,20,15,50,25,5,31,35,55}; // 정렬되지 않은 배열
	    int[] sdata = {5,10,15,20,25,30,35,40,45,50,55}; // 오름차순으로 정렬된 배열
	    Search me = new Search(); // Search 클래스의 객체 생성

	    System.out.println(me.seqS(data, 40));         // 선형 탐색
	    System.out.println(me.seqSortedS(sdata, 40));  // 정렬 배열에서의 순차 탐색
	    System.out.println(me.binS(sdata,40,0,sdata.length-1)); // 이진 탐색
		System.out.println(me.seqSRect(data,data.length, 25));
	}

	private int seqSRect(int[] data, int length, int i) {
		if(length ==0)return -1;
		if(data[length-1]==i) return length-1;
		else return seqSRect(data, length-1,i);
	}

	private int binS(int[] sdata, int key, int s, int e) {
		if(s>e) return -1;
		int mid = (s+e)/2;
		
		if(sdata[mid]==key)return mid;
		else if(sdata[mid]<key)return binS(sdata,key,mid+1,e);
		else return binS(sdata,key,s,mid-1);
	}

	private int seqSortedS(int[] sdata, int t) {
		for(int i=0;i<sdata.length;i++) {
			if(sdata[i]==t) {return i;}
		}
		return -1;
	}

	private int seqS(int[] data, int target) {
		
		for(int i=0;i<data.length;i++) {
			if(data[i]==target) return i;
		}
		return -1;
	}

	
}
