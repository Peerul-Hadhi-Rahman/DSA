// RECURSION
class Solution {
    public int maxProfit(int[] prices) {
        return f(0, 1, prices);
    }
    private int f(int i, int j, int[] prices) {
        if(i==prices.length) return 0;

        int profit=0;

        if(j==1) {
           return  profit = Math.max(-prices[i] + f(i+1, 0, prices), f(i+1, 1, prices));
        }
        else {
            return profit = Math.max( f(i+1, 0, prices) , prices[i] + f(i+1, 1, prices));
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

    private int f(int i, int j, int[] prices, int[][] dp) {
        if(i==prices.length) return 0;

        int profit=0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(j==1) {
           return  profit = Math.max(-prices[i] + f(i+1, 0, prices, dp), f(i+1, 1, prices, dp));
        }
        else {
            return profit = Math.max( f(i+1, 0, prices, dp) , prices[i] + f(i+1, 1, prices, dp));
        }
    }
}

// TABULATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];

        dp[n][0]=dp[n][1]=0;

        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<=1;j++) {

            if(j==1) {
             dp[i][j] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
            }
            else {
                dp[i][j] = Math.max(dp[i+1][0] , prices[i] + dp[i+1][1]);
            }
            }
        }
        return dp[0][1];
    }
}

//SPACE OPTIMIZATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] ahead=new int[2];
        int[] curr=new int[2];

        ahead[0]=ahead[1]=0;

        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<=1;j++) {

            if(j==1) {
             curr[j] = Math.max(-prices[i] + ahead[0], ahead[1]);
            }
            else {
                curr[j] = Math.max(ahead[0] , prices[i] + ahead[1]);
            }
            }
            ahead=curr;
        }
        return ahead[1];
    }
}

// 4 VARIABLES SPACE OPTIMIZATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int aheadBuy=0, aheadNotBuy=0, currBuy=0, currNotBuy=0;

        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<=1;j++) {

             currBuy = Math.max(-prices[i] + aheadNotBuy, aheadBuy);
             
             currNotBuy = Math.max(aheadNotBuy , prices[i] + aheadBuy);
            
            }
            aheadBuy=currBuy;
            aheadNotBuy=currNotBuy;
        }
        return aheadBuy;
    }
}
