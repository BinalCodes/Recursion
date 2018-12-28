/*
 * https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
 */
public class RatInMaze {
	int N = 4;
	public static void main(String[] args) {
		RatInMaze rat = new RatInMaze();
		
		int maze[][] = {{1, 0, 0, 0}, 
	            {1, 1, 0, 1}, 
	            {0, 1, 0, 0}, 
	            {1, 1, 1, 1} 
	        }; 
		System.out.println(rat.solveMaze(maze));
	}
	public boolean solveMaze(int[][] maze) {
		int sol[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		if(!solveMazeUtil(maze,0,0,sol)) {
			System.out.println("No solution exists");
			return false;
		}
		printSolution(sol);
		return true;
	}
	public boolean isSafe(int x, int y, int maze[][]) {
		return (x<N && y<N && x>=0 && y>=0 && maze[x][y] ==1);
	}
	public void printSolution(int[][] sol) {
		for (int i = 0; i < N; i++) 
        { 
			for (int j = 0; j < N; j++) 
                System.out.print(" " + sol[i][j] + 
                                 " "); 
            System.out.println(); 
        } 
	}
	public boolean solveMazeUtil(int[][] maze, int row, int col, int[][] sol) {
		
		//we have reached the destination
		if(row == (N-1) && col == (N-1)) {
			sol[row][col] = 1;
			return true;
		}
		if(isSafe(row,col,maze)){
			sol[row][col] = 1;
			if(isSafe(row+1, col, maze)) {
				return solveMazeUtil(maze,row+1,col,sol);
			}
			if(isSafe(row, col+1, maze)) {
				return solveMazeUtil(maze,row,col+1,sol);
			}
			sol[row][col] = 0;
			return false;
		}
		return false;
		
	}
}
