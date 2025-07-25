package week14;

public class ScoreManager {

	class ScoreCard{
		String name;
		int score;
		public ScoreCard(String n, int s) {
			name=n;
			score=s;
		}
		public String toString() {
			return name+"("+score+")";
		}
	}

	ScoreCard[] heap;
	int size;

	public ScoreManager(int max) {
		heap=new ScoreCard[max];
		size=0;
	}
	public void insert(String n, int s) {
		size++;
		heap[size]=new ScoreCard(n,s);
		heapifyUpward(size);
	}
	private void heapifyUpward(int k) {
		while(k>1 && heap[k].score>heap[k/2].score) {
			swap(k,k/2);
			k=k/2;
		}
	}
	private void swap(int i, int j) {
		ScoreCard temp=heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}
	public ScoreCard award() {
		if(size<1) return null;
		ScoreCard top=heap[1];
		heap[1]=heap[size];
		size--;
		heapifyDownward(1);
		insert(top.name,10);
		return top;
	}

	private void heapifyDownward(int k) { //make Heap with the tree of root data[k]
		while(true) {
			int left=2*k;
			int right=2*k+1;
			int largest=k;
			if(left<=size && heap[left].score>heap[largest].score) largest=left;
			if(right<=size && heap[right].score>heap[largest].score) largest=right;
			if(largest!=k) {
				swap(k,largest);
				k=largest;
			} else break;
		}
	}
	public void update(String n, int point) {
		int idx=0;
		for(int i=1;i<=size;i++){
			if(heap[i].name.equals(n)){
				idx=i;
				break;
			}
		}
		if(idx==0) return;
		heap[idx].score+=point;
		heapifyUpward(idx);
		heapifyDownward(idx);
	}
	public void delete(String n) {
		int idx=0;
		for(int i=1;i<=size;i++){
			if(heap[i].name.equals(n)){
				idx=i;
				break;
			}
		}
		if(idx==0) return;
		swap(idx,size);
		size--;
		heapifyUpward(idx);
		heapifyDownward(idx);
	}

	//////////////////////////////////////////////////////////////
	public void showHeap() {
		for (int i=1;i<=size;i++)
			System.out.print(heap[i]);
		System.out.println();
	}

	public void showLevel() {
		int h=(int)(Math.log(size)/Math.log(2));
		for (int level=0;level<=h;level++) {
			System.out.print("\n Level "+level+" : ");
			int levelStart=(int) Math.pow(2,level);
			int levelEnd=(int) Math.min(Math.pow(2,level+1)-1, size);
			for (int i=levelStart;i<=levelEnd;i++ )
				System.out.print(heap[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Object[][] data = {{"aaa",10},{"bbb",20},{"ccc",15},{"ddd",10},{"eee",13},
				{"fff",12},{"ggg",25},{"hhh",30},{"iii",22},{"jjj",18}  };
		ScoreManager heap = new ScoreManager(30);
		for (int i=0;i<data.length;i++) {
			heap.insert((String)data[i][0], (int)data[i][1]);
			//heap.showHeap();
		}
		System.out.println("\n<< Tree Created >>");
		heap.showLevel();
		System.out.println("\n<< Operation ...  >>");
		heap.update("aaa", 5);
		heap.update("ccc", -5);
		heap.showLevel();
		heap.update("iii", -2);
		heap.update("kkk", 5);
		heap.update("lll", 8);
		heap.showLevel();
		for (int i=1;i<=5;i++) {
			System.out.print("\n>>> "+i+"-th Winner : ");
			System.out.println(heap.award());
			heap.showLevel();
		}
		heap.delete("kkk");
		heap.delete("lll");
		heap.showLevel();
	}
}
