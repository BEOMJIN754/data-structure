import java.util.LinkedList;

public class test {
    public class WordList {
        LinkedList<String> list;
        public WordList() {
            list = new LinkedList<>();
        }
        public void makeList(String s) {
            if (s == null) return;
            s = s.trim();
            if (s.isEmpty()) return;
            String[] parts = s.split(" ", 2);
            list.add(parts[0]);
            if (parts.length == 2) {
                makeList(parts[1]);
            }
        }
        public int getCount() {
            return list.size();
        }
        public void showList() {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        String input = "hi, this is a question list for final evaluation. do your best. good luck!";

        System.out.println("\n==[Q1]================");
        test test = new test();
        WordList q1 = test.new WordList();
        q1.makeList(input);
        System.out.println("\nNumber of words = " + q1.getCount());
        q1.showList();
    }
}
