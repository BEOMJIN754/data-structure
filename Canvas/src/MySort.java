import java.util.Arrays;

public class MySort {
	
	public int[] quickSort(int[] data) {
	    return quickSort(data, 0, data.length - 1);
	}

	private int[] quickSort(int[] data, int p, int r) {  // overloading   cf. overriding
	    if (p < r) {
	        int q = partition(data, p, r);
	        quickSort(data, p, q - 1);
	        quickSort(data, q + 1, r);
	    }
	    return data;
	}

	private int partition(int[] data, int p, int r) {
//	    int pivot = r;
//	    int left = p;
//	    int right = r;
//
//	    while (left < right) {
//	        while (data[left] < data[pivot])
//	            left++;
//	        while (right > left && data[right] >= data[pivot])
//	            right--;
//	        if (left < right)
//	            swap(data, left, right);
//	    }
//
//	    swap(data, left, pivot);
//	    return left;
		
	    int x = data[r];       
	    int k = p - 1;   

	    for (int i = p; i < r; i++) {
	        if (data[i] <= x) {
	            swap(data, ++k, i);
	        }
	    }

	    swap(data, k + 1, r);   
	    return k + 1;      
	}
	
	
	public int[] selectionSort(int[] data) {
//		int n = data.length;
//		
//		
//		for(int i=n-1;i>0;i--) {
//			int maxIndex =i;
//			for(int j=0;j<i-1;j++){
//				if(data[i]>data[maxIndex]) {
//					maxIndex = j;
//				}
//			}
//			swap(data,maxIndex,i);
//		}
//		
//		return data;
		return selectionSort2(data, data.length-1);
	}
	
	public int[] selectionSort2(int[] data,int n) {
		if(n==0) return data;
		else {
			int maxIndex =n;
			for(int j=0;j<=n-1;j++){
				if(data[j]>data[maxIndex]) {
					maxIndex = j;
				}
			}
			swap(data,maxIndex,n);
			return selectionSort2(data, n-1);
		}
		}
	
	private int[] swap(int[] d,int i,int j) {
		int temp = d[i];
		d[i]=d[j];
		d[j]=temp;
		return d;
	}
	
	public int[] insertionSort(int[] data) {
		int n = data.length;
		
		for(int i=1;i<n;i++) {
			int value = data[i];
			int j=i-1;
//			while(j>=0) {
//				if(data[j]>value) j--;
//			}
			while(j>=0&&(data[j]>value)) {
			if(data[j]>value) j--;
		}
			int myPosition = j+1;
			int k=i-1;
			while(k>=myPosition) {
				data[k+1]=data[k];
				k--;
			}
			data[myPosition]=value;
		}
		return data;
	}
	
	public int[] bubbleSort(int[] data) {
		int n = data.length;
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<=i-1;j++) {
				if(data[j]>data[j+1])swap(data,j,j+1); 
			}
		}
		return data;
	}
	
	public int[] mergeSort(int[] data) {
	    return mergeSort(data, 0, data.length - 1);
	}

	private int[] mergeSort(int[] data, int p, int r) {
	    if (p < r) {
	        int q = (p + r) / 2;
	        mergeSort(data, p, q);
	        mergeSort(data, q + 1, r);
	        merge(data, p, q, r);
	    }
	    return data;
	}
	
	private int[] merge(int[] data, int p, int q, int r) {
	    int[] temp = new int[data.length];

	    int i = p;
	    int j = q + 1;
	    int k = p;

	    while (i <= q && j <= r) {
	        if (data[i] < data[j])
	            temp[k++] = data[i++];
	        else
	            temp[k++] = data[j++];
	    }

	    while (i <= q) {
	        temp[k++] = data[i++];
	    }

	    while (j <= r) {
	        temp[k++] = data[j++];
	    }

	    for (int l = p; l <= r; l++) {
	        data[l] = temp[l];
	    }

	    return data;
	}


	public static void main(String[] args) {
		int [] data = {113,  336,  74,  71,  86,  176,  313,  80,  225,  342,
				  170,  292,  275,  266 , 79,  16,  109,  175 , 245,  156,
				  50,  61,  277,  167,  81,  24,  76,  186,  78,  101,
				  301,  62,  152,  219,  294};

		System.out.println("\n< Initial Data >");
		showData(data);
		
		MySort ms = new MySort();
// deep copy data to another array, dataSorted, for argument...
// call each sort method
// showData(dataSorted)
//		
		int[] toBeSorted = data.clone();
		
		//shallow copy
		int[] sample = new int[35];
		sample = data;
		//샘플은 뉴 해서 빈자리를 이미 잡았다. 그래서 얕은 커피를 통해서 그 객체 빈자리가 사라짐
		int[] sample2 = data;
		// 샘플 2 는 만드는 순간 가리키게 됨
		
		//deep copy
		for(int i=0;i<20;i++) {
			sample[i]=data[i];
		}
		
		sample = data.clone();
		
		sample = Arrays.copyOf(data, data.length);
		
		System.arraycopy(data, 0, sample, 0, 20);
		
		
		
		ms.selectionSort(toBeSorted);
		System.out.println("\n<   Selection Sort   >");
		toBeSorted = data.clone();
		ms.selectionSort2(toBeSorted, toBeSorted.length-1);
		showData(toBeSorted);
		
		System.out.println("\n<   Insertion Sort   >");
		toBeSorted = data.clone();
		ms.insertionSort(toBeSorted);		
		showData(toBeSorted);
		
		System.out.println("\n<   Bubble Sort   >");
		toBeSorted = data.clone();
		ms.bubbleSort(toBeSorted);		
		showData(toBeSorted);
		
//		MySort ms = new MySort();
//		int [] dataSorted = new int[data.length];
//		
		System.out.println("\n< Quick Sort >");
		toBeSorted=data.clone();
		ms.quickSort(toBeSorted);
		showData(toBeSorted);
		
		System.out.println("\n< Merge Sort >");
		toBeSorted=data.clone();
		ms.quickSort(toBeSorted);
		showData(toBeSorted);
		
	}
	private static void showData(int[] data) {
		int nData = data.length;
		int nPrinted=0;
		while(nPrinted<nData) {
			for (int i=0;(nPrinted<nData)&&(i<10); i++) {
				System.out.printf("%6d ",data[nPrinted++]);
			}
			System.out.println();
		}
	}

}
