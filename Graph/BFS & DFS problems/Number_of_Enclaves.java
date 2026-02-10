class Solution {
    int rows, cols;
  
    private void dfs(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=rows || j>=cols || grid[i][j]==0) return;
        grid[i][j]=0;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
  
    public int numEnclaves(int[][] grid) {
        int count=0;
        rows=grid.length;
        cols=grid[0].length;

        for(int i=0;i<rows;i++) {
            dfs(grid, i, 0);
            dfs(grid, i, cols-1);
        }
        for(int j=0;j<cols;j++) {
            dfs(grid, 0, j);
            dfs(grid, rows-1, j);
        }
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
