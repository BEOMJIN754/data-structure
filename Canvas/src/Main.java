import java.io.*;
import java.util.*;

public class Main {
    static class Document {
        int index; 
        int priority;	  

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken()); 

            st = new StringTokenizer(br.readLine());
            Queue<Document> queue = new LinkedList<>();
            List<Integer> priorities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, p));
                priorities.add(p);
            }


            priorities.sort(Collections.reverseOrder());

            int count = 0;  
            int priorityIndex = 0;  
            while (!queue.isEmpty()) {
                Document curr = queue.poll();
                if (curr.priority == priorities.get(priorityIndex)) {
                    count++;
                    if (curr.index == M) {
                        System.out.println(count);
                        break;
                    }
                    priorityIndex++;
                } else {
                    queue.add(curr);  
                }
            }
        }
    }
}
