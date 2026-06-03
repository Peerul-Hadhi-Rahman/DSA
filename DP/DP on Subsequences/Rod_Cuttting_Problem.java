RECURSION
  
public class Solution {
	public static int cutRod(int price[], int n) {
		return helper(n-1, n, price);
	}
	 private static int helper(int ind, int target, int[] pr) {
        if(ind==0) {
            return target*pr[0];
        }
      
        int notPick = 0 + helper(ind-1, target, pr);
        int pick=Integer.MIN_VALUE;
        int rodLength=ind+1;
        if(rodLength<=target) {
            pick = pr[ind] + helper(ind, target-rodLength, pr);
        }
        return Math.max(pick, notPick);
    }
}

MEMOIZATION

public class Solution {
	public static int cutRod(int price[], int n) {
        
        int[][] dp=new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row, -1);
		return helper(n-1, n, price, dp);
	}
	 private static int helper(int ind, int target, int[] pr, int[][] dp) {
        if(ind==0) {
            return target*pr[0];
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        int notPick = 0 + helper(ind-1, target, pr, dp);
        int pick=Integer.MIN_VALUE;
        int rodLength=ind+1;
        if(rodLength<=target) {
            pick = pr[ind] + helper(ind, target-rodLength, pr, dp);
        }
        dp[ind][target]=Math.max(pick, notPick);
        return dp[ind][target];
    }
}

TABULATION

public class Solution {
	public static int cutRod(int price[], int n) {
        int[][] dp=new int[n][n+1];  

        for(int i=0;i<=n;i++) {
             dp[0][i]=price[0]*i;
        }
        for(int ind=1;ind<n;ind++) {
            for(int target=0;target<=n;target++) {
                int notPick = 0 + dp[ind-1][target];
                int pick=Integer.MIN_VALUE;
                int rodLength=ind+1;
                if(rodLength<=target) {
                    pick = price[ind] + dp[ind][target-rodLength];
                    }
                    dp[ind][target]=Math.max(pick, notPick);
            }
        }
       return dp[n-1][n];
	}
}

SPACE OPTIMIZATION

public class Solution {
	public static int cutRod(int price[], int n) {
        int[] prev=new int[n+1];
        int[] curr=new int[n+1];  

        for(int i=0;i<=n;i++) {
             prev[i]=price[0]*i;
        }
        for(int ind=1;ind<n;ind++) {
            for(int target=0;target<=n;target++) {
                int notPick = 0 + prev[target];
                int pick=Integer.MIN_VALUE;
                int rodLength=ind+1;
                if(rodLength<=target) {
                    pick = price[ind] + curr[target-rodLength];
                    }
                    curr[target]=Math.max(pick, notPick);
            }
            prev=curr.clone();
        }
       return prev[n];
	}
}
