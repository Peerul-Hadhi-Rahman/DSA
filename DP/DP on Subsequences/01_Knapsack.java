RECURSION

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    
        return helper(n-1, weight, value, maxWeight);
    }
    private static int helper(int ind, int[] wt, int[] val, int W) {
        if(ind==0) {
            if(wt[ind]<=W) return val[ind];
            else return 0;
        }
        
        int notPick = 0 + helper(ind-1, wt, val, W);
        int pick = Integer.MIN_VALUE;
        if(wt[ind]<=W) {
            pick = val[ind] + helper(ind-1, wt, val, W-wt[ind]);
        }
        return Math.max(pick, notPick);
    }
}

MEMOIZATION

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp=new int[n][maxWeight+1];
        for(int[] row:dp) Arrays.fill(row, -1);
        return helper(n-1, weight, value, maxWeight, dp);
    }
    private static int helper(int ind, int[] wt, int[] val, int W, int[][] dp) {
        if(ind==0) {
            if(wt[ind]<=W) return val[ind];
            else return 0;
        }
        if(dp[ind][W]!=-1) return dp[ind][W];

        int notPick = 0 + helper(ind-1, wt, val, W, dp);
        int pick = Integer.MIN_VALUE;
        if(wt[ind]<=W) {
            pick = val[ind] + helper(ind-1, wt, val, W-wt[ind], dp);
        }
        dp[ind][W]=Math.max(pick, notPick);
        return dp[ind][W];
    }
}

SPACE OPTIMIZATION

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            int[] prev =new int[maxWeight+1];
            int[] curr =new int[maxWeight+1];
            
            for(int i=weight[0];i<=maxWeight;i++) {
                prev[i]=value[0];
            }

            for(int ind=1;ind<n;ind++) {
                for(int k=0;k<=maxWeight;k++) {

                    int notPick= 0 + prev[k];
                    int pick=Integer.MIN_VALUE;

                    if(weight[ind]<=k) {
                        pick=value[ind] + prev[k-weight[ind]];
                    }
                    
                curr[k]=Math.max(pick, notPick);
                }
                prev=curr.clone();
            }
            return prev[maxWeight];
    }
}

1D SPACE OPTIMIZATION

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            int[] prev =new int[maxWeight+1];
            
            for(int i=weight[0];i<=maxWeight;i++) {
                prev[i]=value[0];
            }
            for(int ind=1;ind<n;ind++) {
                for(int k=maxWeight;k>=0;k--) {

                    int notPick= 0 + prev[k];
                    int pick=Integer.MIN_VALUE;

                    if(weight[ind]<=k) {
                        pick=value[ind] + prev[k-weight[ind]];
                    }
                    
                prev[k]=Math.max(pick, notPick);
                }
            }
            return prev[maxWeight];
    }
}
