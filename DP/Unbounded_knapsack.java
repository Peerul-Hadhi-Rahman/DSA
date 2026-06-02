RECURSION

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        
        return helper(n-1, w, profit, weight);
    }
    private static int helper(int ind, int target, int[] pr, int[] wt) {
        if(ind==0) {
            if(target%wt[0]==0) return (target/wt[0])*pr[0];
            else return 0;
        }
      
        int notPick = 0 + helper(ind-1, target, pr, wt);
        int pick=Integer.MIN_VALUE;
        if(wt[ind]<=target) {
            pick = pr[ind] + helper(ind, target-wt[ind], pr, wt);
        }
        return Math.max(pick, notPick);
    }
}

MEMOIZATION

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp=new int[n][w+1];
        for(int[] row:dp) Arrays.fill(row, -1);
        return helper(n-1, w, profit, weight, dp);
    }
    private static int helper(int ind, int target, int[] pr, int[] wt, int[][] dp) {
        if(ind==0) {
            if(target%wt[0]==0) return (target/wt[0])*pr[0];
            else return 0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];

        int notPick = 0 + helper(ind-1, target, pr, wt, dp);
        int pick=Integer.MIN_VALUE;
        if(wt[ind]<=target) {
            pick = pr[ind] + helper(ind, target-wt[ind], pr, wt, dp);
        }
        dp[ind][target] = Math.max(pick, notPick);
        return dp[ind][target];
    }
}

TABULATION

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp=new int[n][w+1];

        for(int i=0;i<=w;i++) { 
            dp[0][i]=(i/weight[0])*profit[0];
        }
        
        for(int ind=1;ind<n;ind++) {
            for(int target=0;target<=w;target++) {
                int notPick=0+ dp[ind-1][target];
                int pick=Integer.MIN_VALUE;
                if(weight[ind]<=target) {
                    pick=profit[ind] + dp[ind][target-weight[ind]];
                }
                dp[ind][target]=Math.max(pick, notPick);
            }
        }
        return dp[n-1][w];
    }
}

SPACE OPTIMIZATION

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] prev=new int[w+1];
        int[] curr=new int[w+1];

        for(int i=0;i<=w;i++) { 
            prev[i]=(i/weight[0])*profit[0];
        }
        
        for(int ind=1;ind<n;ind++) {
            for(int target=0;target<=w;target++) {
                int notPick=0+ prev[target];
                int pick=Integer.MIN_VALUE;
                if(weight[ind]<=target) {
                    pick=profit[ind] + curr[target-weight[ind]];
                }
                curr[target]=Math.max(pick, notPick);
            }
            prev=curr.clone();
        }
        return prev[w];
    }
}

1D ARRAY SPACE OPTIMIZATION

public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] prev=new int[w+1];
        
        for(int i=0;i<=w;i++) { 
            prev[i]=(i/weight[0])*profit[0];
        }
        
        for(int ind=1;ind<n;ind++) {
            for(int target=0;target<=w;target++) {
                int notPick=0+ prev[target];
                int pick=Integer.MIN_VALUE;
                if(weight[ind]<=target) {
                    pick=profit[ind] + prev[target-weight[ind]];
                }
                prev[target]=Math.max(pick, notPick);
            }
        }
        return prev[w];
    }
}
