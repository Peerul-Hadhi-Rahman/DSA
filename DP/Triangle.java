//Memoization  TC --> O(n²), SC --> O(n²) + recursion stack
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        
        int[][] dp=new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, triangle, dp);
    }
    private int helper(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        int n=triangle.size();

        if(i==n-1) return triangle.get(i).get(j);

        if(dp[i][j]!=-1) return dp[i][j];

        int down=helper(i+1, j, triangle, dp);
        int diagonal=helper(i+1, j+1, triangle, dp);

        return dp[i][j]=triangle.get(i).get(j) + Math.min(down, diagonal);
    }
}

//TABULATION  TC --> O(n²), SC --> O(n²)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();

        int[][] dp=new int[n][n];
        
        for(int j=0;j<n;j++) {
            dp[n-1][j]=triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
               int  down=dp[i+1][j];
               int diagonal=dp[i+1][j+1];

               dp[i][j]=triangle.get(i).get(j) + Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
}

//Space Optimization 1D DP  TC --> O(n²), SC --> O(n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();

        int[] dp=new int[n];
        
        for(int j=0;j<n;j++) {
            dp[j]=triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {

               dp[j]=triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
