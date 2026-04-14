//RECURSION  TC --> O(2^(m+n)), SC -> O(m + n) recursion stack
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        return helper(grid, m-1, n-1);
    }
    private int helper(int[][] grid, int i, int j) {
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;

 
        int up=helper(grid, i-1, j);
 
        int left=helper(grid, i, j-1);
 

        return grid[i][j] + Math.min(up, left);
    }
}

//MEMOIZATION  TC --> O(m × n), SC -->  O(m × n) + O(m + n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(grid, m-1, n-1, dp);
    }
    private int helper(int[][] grid, int i, int j, int[][] dp) {
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int up=helper(grid, i-1, j, dp);
        int left=helper(grid, i, j-1, dp);
 
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}


//TABULATION  TC --> O(m × n), SC --> O(m × n)
class Solution {
    public int minPathSum(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
 
        int[][] dp=new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
 
          for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {

        if(i==0 && j==0) {
            dp[i][j]=grid[i][j];
        }
        else {
            int up=Integer.MAX_VALUE;
            int left=Integer.MAX_VALUE;

            if(i>0) up=dp[i-1][j];
            if(j>0) left=dp[i][j-1];
            dp[i][j]=grid[i][j] + Math.min(up, left);
        }
            }
        }
        return dp[m-1][n-1];
 
    }
}

//SPACE OPTIMIZATION 1D DP
class Solution {
    public int solve(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

 
        dp[0] = grid[0][0];

        for(int j = 1; j < n; j++)
            dp[j] = dp[j-1] + grid[0][j];

        for(int i = 1; i < m; i++) {
            dp[0] += grid[i][0];

            for(int j = 1; j < n; j++) {
                dp[j] = grid[i][j] +
                        Math.min(dp[j], dp[j-1]);
            }
        }

        return dp[n-1];
    }
}
