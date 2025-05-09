package week10;

public class MyData {
	int num;
	String name; 
	
	public MyData(int n, String str) {
		num =n;
		name = str;
	}
	@Override
	public String toString() {
		return name+"("+num+")";
	}
	@Override
	public boolean equals(Object that) { //오버라이드는 파라미터, 리턴, 싹 다 같아야 함
		return (this.num == ((MyData)that).num);
	}
}
