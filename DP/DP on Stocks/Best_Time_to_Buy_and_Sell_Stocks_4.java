// SAME AS STOCKS 3 PROBLEM HERE TRANSACTIONS GIVEN IN K
// 1 TRANSACTION -> 2 STATES => BUY, SELL    ||  2*K STATES 

// OPTIMAL SOLUTION
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][k*2+1];

        for(int i=n-1;i>=0;i--) {
            for(int limit=k*2-1;limit>=0;limit--) {
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

// using just 2(k*2) SPACE 
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[] after=new int[k*2+1];
        int[] curr=new int[k*2+1];

        for(int i=n-1;i>=0;i--) {
            for(int limit=k*2-1;limit>=0;limit--) {
                if(limit%2==0) {
                   curr[limit] = Math.max(-prices[i] + after[limit+1], after[limit]);
                }
                else {
                    curr[limit] = Math.max(prices[i] + after[limit+1], after[limit]);
                }
            }
            after=curr;
        } 
       return after[0];
    }
}
