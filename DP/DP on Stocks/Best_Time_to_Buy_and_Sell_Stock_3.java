// RECURSION
class Solution {
    public int maxProfit(int[] prices) {
       
        return f(0, 1, 2, prices);
    }

    private int f(int i, int buy, int limit, int[] prices) {
        if(i==prices.length) return 0;
        if(limit==0) return 0;

        if(buy==1) {
            return Math.max(-prices[i] + f(i+1, 0, limit, prices), f(i+1, 1, limit, prices));
        }
        else {
            return Math.max(prices[i] + f(i+1, 1, limit-1, prices), f(i+1, 0, limit, prices));
        }
    }
}

// MEMOIZATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];

        for(int[][] col:dp) {
            for(int[] row:col) {
                 Arrays.fill(row, -1);
            }
        }
        return f(0, 1, 2, prices, dp);
    }

    private int f(int i, int buy, int limit, int[] prices, int[][][] dp) {
        if(i==prices.length) return 0;
        if(limit==0) return 0;

        if(dp[i][buy][limit]!=-1) return dp[i][buy][limit];
        if(buy==1) {
            return dp[i][buy][limit] = Math.max(-prices[i] + f(i+1, 0, limit, prices, dp), f(i+1, 1, limit, prices, dp));
        }
        else {
            return dp[i][buy][limit] = Math.max(prices[i] + f(i+1, 1, limit-1, prices, dp), f(i+1, 0, limit, prices, dp));
        }
    }
}

// TABULATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];

        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<2;buy++) {
                for(int limit=1;limit<3;limit++) {

                    if(buy==1) {
                        dp[i][buy][limit] = Math.max(-prices[i] + dp[i+1][0][limit], dp[i+1][1][limit]);
                    }
                    else {
                        dp[i][buy][limit] = Math.max(prices[i] + dp[i+1][1][limit-1], dp[i+1][0][limit]);
                    }
                }
            }
        }
    return dp[0][1][2];
    }
}

//SPACE OPTIMIZATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] after=new int[2][3];
        int[][] curr=new int[2][3];

        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<2;buy++) {
                for(int limit=1;limit<3;limit++) {

                    if(buy==1) {
                        curr[buy][limit] = Math.max(-prices[i] + after[0][limit], after[1][limit]);
                    }
                    else {
                        curr[buy][limit] = Math.max(prices[i] + after[1][limit-1], after[0][limit]);
                    }
                }
            }
            after=curr;
        }
    return after[1][2];
    }
}

// N * 4 SPACE OPTIMIZATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][5];

        for(int i=n-1;i>=0;i--) {
            for(int limit=3;limit>=0;limit--) {
                if(limit%2==0) {
                    dp[i][limit] = Math.max(-prices[i] + dp[i+1][limit+1], dp[i+1][limit]);
                }
                else {
                    dp[i][limit] = Math.max(prices[i] + dp[i+1][limit+1], dp[i+1][limit]);
                }
            }
        } 
       return dp[0][0];
    }
}
