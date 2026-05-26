RECURSION  TC -> O(2 ^ n), SC -> O(n)

  public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
      
      return helper(n-1, k, arr);
    }
    private static boolean helper(int ind, int target, int[] a) {
        if(target==0) return true;
        if(ind==0) return a[0]==target;
      
        boolean notTake=helper(ind-1, target, a);
        boolean take=false;
        if(target>=a[ind]) {
        take=helper(ind-1, target-a[ind], a);
        }
        return take || notTake;
    }
}


MEMOIZATION   TC -> O(n x k), SC -> O(n x k) + O(n)
                      
  public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
      int[][] dp=new int[n][k+1];
      for(int i=0;i<n;i++) {
        Arrays.fill(dp[i], -1);
      }
      return helper(n-1, k, arr, dp);
    }
    private static boolean helper(int ind, int target, int[] a, int[][] dp) {
        if(target==0) return true;
        if(ind==0) return a[0]==target;

        if(dp[ind][target]!=-1) return dp[ind][target]==1;

        boolean notTake=helper(ind-1, target, a, dp);
        boolean take=false;
        if(target>=a[ind]) {
        take=helper(ind-1, target-a[ind], a, dp);
        }
        dp[ind][target] = (take || notTake) ? 1:0;
        return take || notTake;
    }
}


TABULATION  TC -> O(n x k), SC -> O(n x k)
                    
  public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
      boolean[][] dp=new boolean[n][k+1];
      for(int i=0;i<n;i++) {
        dp[i][0]=true;
      }

      if(arr[0]<=k) {
        dp[0][arr[0]]=true;
      }
     
      for(int i=1;i<n;i++) {
        for(int target=1;target<=k;target++) {
          boolean notTake=dp[i-1][target];
          boolean take=false;
          if(arr[i]<=target) {
            take=dp[i-1][target-arr[i]];
          }
          dp[i][target]=take || notTake;
        }
      }
      return dp[n-1][k]; 
    }
  

SPACE OPTIMIZATION  TC -> O(n x k), SC -> O(k)
  
  public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
      boolean[] prev=new boolean[k+1];
      boolean[] curr=new boolean[k+1];
      prev[0]=true;
      curr[0]=true;

      if(arr[0]<=k) {
        prev[arr[0]]=true;
      }
     
      for(int i=1;i<n;i++) {
        curr[0]=true;
        for(int target=1;target<=k;target++) {
          boolean notTake=prev[target];
          boolean take=false;
          if(arr[i]<=target) {
            take=prev[target-arr[i]];
          }
          curr[target]=take || notTake;
        }
        prev=curr.clone();
      }
      return prev[k]; 
    }
}
