// RECURSION
class Solution {
    public int maxProfit(int[] prices) {

        return f(0, 1, prices); 
    }
    private int f(int i, int buy, int[] prices) {
        if(i>=prices.length) return 0;

        if(buy==1) {
            return Math.max(-prices[i] + f(i+1, 0, prices), f(i+1, 1, prices));
        }
        else {
            return Math.max(prices[i] + f(i+2, 1, prices), f(i+1, 0, prices));
        }
    }
}

// MEMOIZATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];

        for(int[] row:dp) {
            Arrays.fill(row, -1);
        }

        return f(0, 1, prices, dp); 
    }
    private int f(int i, int buy, int[] prices, int[][] dp) {
        if(i>=prices.length) return 0;

        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1) {
            return dp[i][buy] = Math.max(-prices[i] + f(i+1, 0, prices, dp), f(i+1, 1, prices, dp));
        }
        else {
            return dp[i][buy] = Math.max(prices[i] + f(i+2, 1, prices, dp), f(i+1, 0, prices, dp));
        }
    }
}

//TABULATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+2][2];

        for(int i=n-1;i>=0;i--) {
            for(int buy=1;buy>=0;buy--) {
                if(buy==1) {
                    dp[i][buy] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                }
                else {
                    dp[i][buy] = Math.max(prices[i] + dp[i+2][1], dp[i+1][0]);
                }
            }
        } 
        return dp[0][1];
    }
}

//SPACE OPTIMIZATION  -> 6 Variables which is constant & TC -> (n)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] front1=new int[2];
        int[] front2=new int[2];
        int[] curr=new int[2];

        for(int i=n-1;i>=0;i--) {
 
            curr[1] = Math.max(-prices[i] + front1[0], front1[1]);
                
            curr[0] = Math.max(prices[i] + front2[1], front1[0]);

            front2=front1.clone();
            front1=curr.clone();

        } 
        return front1[1];
    }
}
