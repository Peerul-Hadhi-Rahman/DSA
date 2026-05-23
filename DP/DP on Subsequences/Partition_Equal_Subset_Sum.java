RECURSION  TC -> O(2 ^ n) + O(n), SC -> O(n)

    class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums) {
            total+=num;
        }
        if(total%2!=0) return false;
        int n=nums.length;
        int target=total/2;
      
        return partition(n-1, target, nums);
    }

    private boolean partition(int ind, int target, int[] arr) {
        if(target==0) return true;
        if(ind==0) return  (arr[0]==target);

        boolean notTake=partition(ind-1, target, arr);
        boolean take=false;
        if(arr[ind]<=target) {
            take=partition(ind-1, target-arr[ind], arr);
        }
        return notTake || take;
    }
}


MEMOIZATION   TC -> O(n x k) + O(n), SC -> O(n x k) + O(n)

  class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums) {
            total+=num;
        }
        if(total%2!=0) return false;
        int n=nums.length;
        int target=total/2;
        int[][] dp=new int[n][target+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        return partition(n-1, target, nums, dp);
    }

    private boolean partition(int ind, int target, int[] arr, int[][] dp) {
        if(target==0) return true;
        if(ind==0) return  (arr[0]==target);
        if(dp[ind][target]!=-1) return dp[ind][target]==1;

        boolean notTake=partition(ind-1, target, arr, dp);
        boolean take=false;
        if(arr[ind]<=target) {
            take=partition(ind-1, target-arr[ind], arr, dp);
        }
        dp[ind][target]=(take || notTake)? 1:0;
        return notTake || take;
    }
}


TABULATION   TC -> O(n x k) + O(n), SC -> O(n x k)

  class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums) {
            total+=num;
        }
        if(total%2!=0) return false;
        int n=nums.length;
        int target=total/2;
        boolean[][] dp=new boolean[n][target+1];

        for(int i=0;i<n;i++) {
            dp[i][0]=true;
        }
        if(nums[0]<=target) {
            dp[0][nums[0]]=true;
        } 
        for(int i=1;i<n;i++) {
            for(int k=1;k<=target;k++) {
                boolean notTake=dp[i-1][k];
                boolean take=false;
                if(nums[i]<=k) {
                    take=dp[i-1][k-nums[i]];
                }
                dp[i][k]=take || notTake;
            }
        }
       return dp[n-1][target];
    }
    

SPACE OPTIMIZATION  TC -> O(n x k) + O(n), SC -> O(k)

  class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums) {
            total+=num;
        }
        if(total%2!=0) return false;
        int n=nums.length;
        int target=total/2;
      
        boolean[] prev=new boolean[target+1];
        boolean[] curr=new boolean[target+1];
        prev[0]=true;
        curr[0]=true;
        
        if(nums[0]<=target) {
            prev[nums[0]]=true;
        } 
        for(int i=1;i<n;i++) {
            for(int k=1;k<=target;k++) {
                boolean notTake=prev[k];
                boolean take=false;
                if(nums[i]<=k) {
                    take=prev[k-nums[i]];
                }
                curr[k]=take || notTake;
            }
            prev=curr.clone();
        }
       return prev[target];
    }

  
