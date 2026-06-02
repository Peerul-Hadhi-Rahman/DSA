RECURSION
  
public class Solution {
    public static int minimumElements(int num[], int x) {
        int n=num.length;
        
        int ans = helper(n-1, x, num);
        if(ans>=(int)1e9) return -1;
        return ans;
    }
    private static int helper(int ind, int target, int[] arr) {
        if(ind==0) {
            if(target%arr[0]==0) return target/arr[0];
            return (int)1e9;
        }
    
        int notPick = 0 + helper(ind-1, target, arr);
        int pick = Integer.MAX_VALUE;
        if(arr[ind]<=target) {
            pick = 1 + helper(ind, target-arr[ind], arr);
        }
        return Math.min(pick, notPick);
    }
}

MEMOIZATION

public class Solution {
    public static int minimumElements(int num[], int x) {
        int n=num.length;
        int[][] dp=new int[n][x+1];

        for(int[] row:dp) Arrays.fill(row, -1);
        
        int ans = helper(n-1, x, num, dp);
        if(ans>=(int)1e9) return -1;
        return ans;
    }
    private static int helper(int ind, int target, int[] arr, int[][] dp) {
        if(ind==0) {
            if(target%arr[0]==0) return target/arr[0];
            return (int)1e9;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        int notPick = 0 + helper(ind-1, target, arr, dp);
        int pick = Integer.MAX_VALUE;
        if(arr[ind]<=target) {
            pick = 1 + helper(ind, target-arr[ind], arr, dp);
        }
        dp[ind][target]=Math.min(pick, notPick);
        return dp[ind][target];
    }

}

TABULATION

public class Solution {
    public static int minimumElements(int num[], int x) {
        int n=num.length;
        int[][] dp=new int[n][x+1];

        for(int i=0;i<=x;i++) {
            if(i%num[0]==0) dp[0][i]=i/num[0];
            else dp[0][i]=(int)1e9;
        }

        for(int ind=1;ind<n;ind++) {
            for(int mini=0;mini<=x;mini++) {
                int notPick = 0 + dp[ind-1][mini];
                int pick=Integer.MAX_VALUE;
                if(num[ind]<=mini) {
                    pick = 1 + dp[ind][mini-num[ind]];
                }
                dp[ind][mini]=Math.min(pick, notPick);
            }
        }
        int ans=dp[n-1][x];
        if(ans>=(int)1e9) return -1;
        return ans;
    }
}

SPACE OPTIMIZATION
  
public class Solution {
    public static int minimumElements(int num[], int x) {
        int n=num.length;
        int[] prev=new int[x+1];
        int[] curr=new int[x+1];

        for(int i=0;i<=x;i++) {
            if(i%num[0]==0) prev[i]=i/num[0];
            else prev[i]=(int)1e9;
        }

        for(int ind=1;ind<n;ind++) {
            for(int mini=0;mini<=x;mini++) {
                int notPick = 0 + prev[mini];
                int pick=Integer.MAX_VALUE;
                if(num[ind]<=mini) {
                    pick = 1 + curr[mini-num[ind]];
                }
                curr[mini]=Math.min(pick, notPick);
            }
            prev=curr.clone();
        }
        int ans=prev[x];
        if(ans>=(int)1e9) return -1;
        return ans;
    }
}


1D SPACE OPTIMIZATION

public class Solution {
    public static int minimumElements(int num[], int x) {
        int n=num.length;
        int[] prev=new int[x+1];
      
        for(int i=0;i<=x;i++) {
            if(i%num[0]==0) prev[i]=i/num[0];
            else prev[i]=(int)1e9;
        }

        for(int ind=1;ind<n;ind++) {
            for(int mini=0;mini<=x;mini++) {
                int notPick = 0 + prev[mini];
                int pick=Integer.MAX_VALUE;
                if(num[ind]<=mini) {
                    pick = 1 + prev[mini-num[ind]];
                }
                prev[mini]=Math.min(pick, notPick);
            }  
        }
        int ans=prev[x];
        if(ans>=(int)1e9) return -1;
        return ans;
    }
}
