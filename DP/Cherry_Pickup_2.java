//MEMOIZATION
class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][][] dp=new int[n][m][m];
        for(int[][] x:dp) {
            for(int[] y:x)
            Arrays.fill(y, -1);
        }

        return f(0, 0, m-1, grid, dp);
    }

    private int f(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length) {
            return -1000_000_000;
        }

        if(i==grid.length-1) {
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi=Integer.MIN_VALUE;
        for(int dj1=-1;dj1<=1;dj1++) {
            for(int dj2=-1;dj2<=1;dj2++) {
                int value=0;
                if(j1==j2) {
                   value+= grid[i][j1];
                }
                else {
                    value+= grid[i][j1] + grid[i][j2];
                }
                value+=f(i+1, j1+dj1, j2+dj2, grid, dp);
                maxi=Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}

//Tabulation 
class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][][] dp=new int[n][m][m];

        for(int j1=0;j1<m;j1++) {
            for(int j2=0;j2<m;j2++) {
                if(j1==j2) dp[n-1][j1][j2]=grid[n-1][j1];
                else dp[n-1][j1][j2]=grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for(int i=n-2;i>=0;i--) {
            for(int j1=0;j1<m;j1++) {
                for(int j2=0;j2<m;j2++) {

                    int maxi=Integer.MIN_VALUE;
        for(int dj1=-1;dj1<=1;dj1++) {
            for(int dj2=-1;dj2<=1;dj2++) {
                int value=0;
                if(j1==j2) {
                   value+= grid[i][j1];
                }
                else {
                    value+= grid[i][j1] + grid[i][j2];
                }
                int nextJ1=j1+dj1, nextJ2=j2+dj2;
                if(nextJ1>=0 && nextJ1<m && nextJ2>=0 && nextJ2<m) {
                    value+= dp[i+1][nextJ1][nextJ2];
                }
                 
                dp[i][j1][j2] = maxi=Math.max(maxi, value);
            }
        }
                }
            }
        }
        return dp[0][0][m-1];
    }
}
