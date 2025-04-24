package week07;

public class MyData {
	int n;
	String name;
	
	public MyData(int n, String s) {
		this.n =n;
		this.name =s;
	}
	
	public String toString() {
		return name+"("+n+")";
	}
	
	public boolean equals(Object that) {
		return (this.n==((MyData)that).n);
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) return true;
//		if (obj == null || getClass() != obj.getClass()) return false;
//		MyData other = (MyData) obj;
//		return this.n == other.n;
//	}
}
