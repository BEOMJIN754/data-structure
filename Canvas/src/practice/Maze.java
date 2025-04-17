package practice;

public class Maze {
	private int[][]maze;
	private int[][]memo;
	private int count;
	
	public Maze(int[][] input) {
		maze = input;
		memo = new int[maze.length][maze[0].length];
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze[0].length;j++) {
				memo[i][j]=-1;
			}
		}
	}
	
	public void resetCount() {
		count =0;
	}
	
	public int getCount() {
		return count;
	}

    public static void main(String[] args) {
        int[][] maze = {
            {1, 2, 1, 5, 8, 4},
            {4, 1, 9, 4, 2, 3},
            {8, 5, 4, 3, 8, 2},
            {1, 5, 3, 5, 7, 3},
            {4, 7, 7, 9, 2, 8},
            {2, 4, 6, 3, 1, 4}
        };
        Maze me = new Maze(maze);
        me.resetCount();
        System.out.println("MaxSum (Iter) = " + me.findMaxIter(maze.length - 1, maze[0].length - 1) + "  count = " + me.getCount());
        me.resetCount();
        System.out.println("MaxSum (Rec) = " + me.findMaxRec(maze.length - 1, maze[0].length - 1) + "  count = " + me.getCount());
        me.resetCount();
        System.out.println("MaxSum (RecMemo) = " + me.findMaxRecMemo(maze.length - 1, maze[0].length - 1) + "  count = " + me.getCount());
    }

	private int findMaxRecMemo(int m, int n) {
		count++;
		if(memo[m][n]!=-1) {
			return memo[m][n];
		}
		if(m==0&&n==0) {return maze[0][0];}
		else if(m==0) memo[m][n] = maze[m][n] + findMaxRecMemo(m, n-1);
		else if(n==0) memo[m][n] = maze[m][n] + findMaxRecMemo(m-1, n);
		else memo[m][n] = maze[m][n] + Math.max(findMaxRecMemo(m, n-1), findMaxRecMemo(m-1, m));
		return memo[m][n];
	}

	private int findMaxRec(int m, int n) {
		count++; 
		if(m==0&&n==0)return maze[0][0];
		else if(m==0)return maze[m][n]+findMaxRec(m, n-1);
		else if(n==0)return maze[m][n]+findMaxRec(m-1,n);
		else return maze[m][n] + Math.max(findMaxRec(m, n-1), findMaxRec(m-1, n)); 
	}

	public int findMaxIter(int m, int n) {
		int[][] temp = new int[m+1][n+1];
		temp[0][0] = maze[0][0];
		for(int i=1;i<=m;i++) {
			count++;
			temp[i][0] = temp[i-1][0] + maze[i][0];
		}
		for(int j=1;j<=n;j++) {
			count++;
			temp[0][j] = temp[0][j-1]+maze[0][j];
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				count++;
				temp[i][j] = Math.max(temp[i-1][j],temp[i][j-1])+maze[i][j];
			}
		}
		showMatrix("Iteration Result : ",temp );
		return temp[m][n];
	}

	private void showMatrix(String string, int[][] temp) {
		System.out.println("Matrix "+string);
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp[0].length;j++) {
				System.out.printf("%5d",temp[i][j]);
			}
			System.out.println();
		}
		
	}
    
}
