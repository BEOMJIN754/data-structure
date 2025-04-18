package week07;

public class MyData {
	int n;
	String name;
	
	public MyData(int n, String s) {
		n =n;
		name =s;
	}
	
	public String toString() {
		return name+"("+n+")";
	}
	
	public boolean equals(Object that) {
		return (this.n==((MyData)that).n);
	}
}
