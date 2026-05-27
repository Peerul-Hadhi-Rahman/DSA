MEMOIZATION

public class Solution {
	static int MOD=(int)1e9+7;
	public static int countPartitions(int n, int d, int[] arr) {
		int total=0;
		for(int row:arr) total+=row;

		if((total-d)<0 || (total-d)%2!=0) return 0;
		int target=(total-d)/2;

		int[][] dp=new int[n][target+1];
		for(int[] row:dp) Arrays.fill(row, -1);
		return count(n-1, target, arr, dp);
	}
	private static int count(int ind, int target, int[] arr, int[][] dp) {
		if(ind==0) {
			if(target==0 && arr[0]==0) return 2;
			if(target==0 || arr[0]==target) return 1;
			return 0;
		}
			if(dp[ind][target]!=-1) return dp[ind][target];
			int notTake=count(ind-1, target, arr, dp);
			int take=0;
			if(arr[ind]<=target) {
				take=count(ind-1, target-arr[ind], arr, dp);
			}
			dp[ind][target]=(take+notTake)%MOD;
		return dp[ind][target];
	}
}


TABULATION

public class Solution {
	static int MOD=(int)1e9+7;
	public static int countPartitions(int n, int d, int[] arr) {
		int total=0;
		for(int row:arr) total+=row;

		if((total-d)<0 || (total-d)%2!=0) return 0;
		int target=(total-d)/2;

		int[][] dp=new int[n][target+1];
	
		if(arr[0]==0) dp[0][0]=2;
		else dp[0][0]=1;

		if(arr[0]!=0 && arr[0]<=target) {
			dp[0][arr[0]]=1;
		}

		for(int i=1;i<n;i++) {
			for(int k=0;k<=target;k++) {
				int notTake=dp[i-1][k];
				int take=0;
				if(arr[i]<=k) {
					take=dp[i-1][k-arr[i]];
				}
				dp[i][k]=(take+notTake)%MOD;
			}
		}
		return dp[n-1][target];
	}
}

SPACE OPTIMIZATION

public class Solution {
	static int MOD=(int)1e9+7;
	public static int countPartitions(int n, int d, int[] arr) {
		int total=0;
		for(int row:arr) total+=row;

		if((total-d)<0 || (total-d)%2!=0) return 0;
		int target=(total-d)/2;

		int[] prev=new int[target+1];
		int[] curr=new int[target+1];
		prev[0]=0; curr[0]=0;

		if(arr[0]==0) prev[0]=2;
		else prev[0]=1;

		if(arr[0]!=0 && arr[0]<=target) {
			prev[arr[0]]=1;
		}

		for(int i=1;i<n;i++) {
			for(int k=0;k<=target;k++) {
				int notTake=prev[k];
				int take=0;
				if(arr[i]<=k) {
					take=prev[k-arr[i]];
				}
				curr[k]=(take+notTake)%MOD;
			}
			prev=curr.clone();
		}
		return prev[target];
	}
}
