package week14;

import java.util.Arrays;

public class NQueens {
    int N;
    int[] cols;

    public NQueens(int n) {
        N = n;
        cols = new int[N];
        Arrays.fill(cols, -1);
    }

    public boolean solve() {
        return probe(0);
    }

    private boolean probe(int row) {
        if (row == N) {
            // print one solution
            for (int k = 0; k < N; k++) {
                System.out.print(cols[k]);
            }
            System.out.println();
            return true;
        } else {
            for (int c = 0; c < N; c++) {
                cols[row] = c;
                if (feasible(row)) {
                    if (probe(row + 1)) {
//                        return true;
                    	System.out.println(cols[row]);
                    }
                }
            }
        }
        return false;
    }

    private boolean feasible(int row) {
        for (int prev = 0; prev < row; prev++) {
            // same column?
            if (cols[prev] == cols[row]) {
                return false;
            }
            // same diagonal?
            if (Math.abs(cols[row] - cols[prev]) == row - prev) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n;
        NQueens q;

        n = 2;
        q = new NQueens(n);
        System.out.print("N = " + n + ": ");
        System.out.println(q.solve());

        n = 3;
        q = new NQueens(n);
        System.out.print("N = " + n + ": ");
        System.out.println(q.solve());

        n = 4;
        q = new NQueens(n);
        System.out.print("N = " + n + ": ");
        System.out.println(q.solve());

        n = 5;
        q = new NQueens(n);
        System.out.print("N = " + n + ": ");
        System.out.println(q.solve());

        n = 6;
        q = new NQueens(n);
        System.out.print("N = " + n + ": ");
        System.out.println(q.solve());
    }
}