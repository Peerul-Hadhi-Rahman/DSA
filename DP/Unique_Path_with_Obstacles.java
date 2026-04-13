//MEMOIZATION 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length-1;
        int n=obstacleGrid[0].length-1;
        if(obstacleGrid[m][n]==1) return 0;

        int[][] dp=new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(obstacleGrid, m, n, dp);
    }
    private int helper(int[][] obstacleGrid, int i, int j, int[][] dp) {
        
        int up=0, left=0;
       
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(i>0 && obstacleGrid[i-1][j]==0) {
            up=helper(obstacleGrid, i-1, j, dp);
        }
        if(j>0 && obstacleGrid[i][j-1]==0) {
            left=helper(obstacleGrid, i, j-1, dp);
        }
        long res=up+left;
        dp[i][j]=(int)res;

        return dp[i][j];

    }
}

//TABULATION

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1]==1) return 0;

        int[][] dp=new int[m][n]

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {

                if(obstacleGrid[i][j]==1) 
                    dp[i][j]=0;
                    
                 else if(i==0 && j==0) 
                    dp[i][j]=1;
                   
                else {
                     int up=0, left=0;

                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];

                dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

// SPACE OPTIMIZATION
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        
        dp[0] = (grid[0][0] == 1) ? 0 : 1;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                
                if(grid[i][j] == 1) {
                    dp[j] = 0;
                }
                else if(j > 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
