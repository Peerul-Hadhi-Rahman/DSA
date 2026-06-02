RECURSION

public class Solution {
	public static long countWaysToMakeChange(int denominations[], int value){
		int n=denominations.length;
		return helper(n-1, value, denominations);
	}
	private static long helper(int ind, int target, int[] arr) {
		if(ind==0) {
			if(target%arr[0]==0) return 1;
			return 0;
		}

		long notPick=helper(ind-1, target, arr);
		long pick=0;
		if(arr[ind]<=target) {
			pick=helper(ind, target-arr[ind], arr);
		}
		return pick+notPick;
		
	}
}

MEMOIZATION

public class Solution {
	public static long countWaysToMakeChange(int denominations[], int value){
		int n=denominations.length;
		long[][] dp=new long[n][value+1];
		for(long[] row:dp) Arrays.fill(row, -1);
		return helper(n-1, value, denominations, dp);
	}
	private static long helper(int ind, int target, int[] arr, long[][] dp) {
		if(ind==0) {
			if(target%arr[0]==0) return 1;
			return 0;
		}
		if(dp[ind][target]!=-1) return dp[ind][target];

		long notPick=helper(ind-1, target, arr, dp);
		long pick=0;
		if(arr[ind]<=target) {
			pick=helper(ind, target-arr[ind], arr, dp);
		}
		dp[ind][target]=pick+notPick;
		return dp[ind][target];
	}
}


TABULATION

public class Solution {
	public static long countWaysToMakeChange(int denominations[], int value){
		int n=denominations.length;
		long[][] dp=new long[n][value+1];

		for(int d=0;d<=value;d++) {
			if(d%denominations[0]==0) dp[0][d]=1;
			else dp[0][d]=0;
		}
		
		for(int ind=1;ind<n;ind++) {
			for(int k=0;k<=value;k++) {
				long notPick=dp[ind-1][k];
				long pick=0;
				if(denominations[ind]<=k) {
					pick=dp[ind][k-denominations[ind]];
				}
				dp[ind][k]=pick+notPick;
			}
		}
		return dp[n-1][value];
	}
}

SPACE OPTIMIZATION

public class Solution {
	public static long countWaysToMakeChange(int denominations[], int value){
        
		int n=denominations.length;
		long[] prev=new long[value+1];
		long[] curr=new long[value+1];

		for(int d=0;d<=value;d++) {
			if(d%denominations[0]==0) prev[d]=1;
		}
		
		for(int ind=1;ind<n;ind++) {
			for(int k=0;k<=value;k++) {
				long notPick=prev[k];
				long pick=0;
				if(denominations[ind]<=k) {
					pick=curr[k-denominations[ind]];
				}
				curr[k]=pick+notPick;
			}
			prev=curr.clone();
		}
		return prev[value];
	}
}
