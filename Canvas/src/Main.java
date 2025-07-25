import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			for(int j=0;j<size;j++) {
				
			}
		}

	}
}