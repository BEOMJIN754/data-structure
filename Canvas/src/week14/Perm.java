package week14;

public class Perm {
	char[] data;

	public Perm(char[] d) {
		data = d;
	}

	public void perm() {
		perm(0);
	}

	private void perm(int depth) {
		if (depth == data.length) {
			System.out.println(data);
			return;
		}
		for (int i = depth; i < data.length; i++) {
			swap(depth, i);
			perm(depth + 1);
			swap(depth, i);
		}
	}

	private void swap(int i, int j) {
		char temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		char[] data = { 'a', 'b', 'c', 'd', 'e' };
		Perm p = new Perm(data);
		p.perm();
	}
}
