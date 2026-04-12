//RECURSION TC --> O(2^m*n), SC --> O(m*n) Recursion stack space
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m-1, n-1);
    }
    private int helper(int i, int j) {
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        return helper(i-1, j) + helper(i, j-1);
    }
}

//MEMOIZATION TC --> O(m*n), SC --> O(m*n) + O(m*n) Recursion stack space
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(m-1, n-1, dp);
    }
    private int helper(int i, int j, int[][] dp) {
        
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = helper(i-1, j, dp) + helper(i, j-1, dp);
        return dp[i][j];
    }
}

//TABULATION TC --> O(m*n), TC --> O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
      
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int up=0;
                int left=0;
              
                if(i==0 && j==0) dp[i][j]=1;
                
                else {
                    if(i>0)  up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    
                dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

//SPACE OPTIMIZATION TC --> O(m*n), SC --> O(2) constatnt
class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev=new int[n];

        for(int i=0;i<m;i++) {
            int[] temp=new int[n];

            for(int j=0;j<n;j++) {
                if(i==0 && j==0) temp[j]=1;
                else {
                    int up=prev[j];
                    int left=(j>0) ? temp[j-1] : 0;
                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }
}

//COMBINATORICS TC --> O(min(m, n)), SC --> O(1)
class Solution {
    public int uniquePaths(int m, int n) {
        int N=m+n-2;
        int r=Math.min(m-1, n-1);
        double res=1;

        for(int i=1;i<=r;i++) {
            res=res*(N-r+i)/i;
        }
        return (int)res;
    }
}
