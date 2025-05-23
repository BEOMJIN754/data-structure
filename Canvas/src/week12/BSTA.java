package week12;

import java.util.Arrays;

public class BSTA {
	
	int[] arr;
	int nNode;
	
	public BSTA() {
		arr = new int[200];
		Arrays.fill(arr, -1);
		nNode=0;
	}
	public static void main(String[] args) {
		int [] keys = {4,7,5,1,0,3,9,2,6,8};
		

		BSTA t = new BSTA();
		for (int i=0; i<keys.length;i++) {
			t.insert(keys[i]);
			t.showTree();
		}
	}
	private void showTree() {
		for(int i=1;i<=30;i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}
	private void insert(int d) {
		
		if(nNode==0) {
			arr[1]=d;
			nNode++;
		}
		else {
			int i =1;
			while(arr[i]!=-1) {
				if(d<arr[i]) i=i*2;
				else i= i*2+1;
			}
			arr[i]=d;
			nNode++;
		}
	}
	
	
}
