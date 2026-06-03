RECURSION

public class Solution {
	public static int lcs(String s, String t) {
		int n=s.length();
		int m=t.length();
		
		return helper(n-1, m-1, s, t);
    }
	private static int helper(int ind1, int ind2, String s, String t) {
		if(ind1<0 || ind2<0) return 0;

		if(s.charAt(ind1)==t.charAt(ind2)) {
			return 1+helper(ind1-1, ind2-1, s, t);
		}
		return Math.max(helper(ind1-1, ind2, s, t), 
					    helper(ind1, ind2-1, s, t)); 
	}
}

MEMOIZATION

public class Solution {
	public static int lcs(String s, String t) {
		int n=s.length();
		int m=t.length();
		int[][] dp=new int[n][m];
		for(int[] row:dp) Arrays.fill(row, -1);
		return helper(n-1, m-1, s, t, dp);
    }
	private static int helper(int ind1, int ind2, String s, String t, int[][] dp) {
		if(ind1<0 || ind2<0) return 0;
		if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];

		if(s.charAt(ind1)==t.charAt(ind2)) {
			dp[ind1][ind2]=1+helper(ind1-1, ind2-1, s, t, dp);
			return dp[ind1][ind2];
		}
		dp[ind1][ind2] = Math.max(helper(ind1-1, ind2, s, t, dp), 
					    helper(ind1, ind2-1, s, t, dp));
		return dp[ind1][ind2];
	}
}

TABULATION

public class Solution {
	public static int lcs(String s, String t) {
	  int n=s.length();
		int m=t.length();
		int[][] dp=new int[n+1][m+1];

		for(int j=0;j<=m;j++) {
			dp[0][j]=0;
		}
		for(int i=0;i<=n;i++) {
			dp[i][0]=0;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s.charAt(i-1)==t.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
				dp[i][j]=Math.max(dp[i-1][j],
					    dp[i][j-1]);
				}
			}
		}
		return dp[n][m];
	}
}

SPACE OPTIMIZATION

public class Solution {
	public static int lcs(String s, String t) {
	  int n=s.length();
		int m=t.length();
		int[] prev=new int[m+1];
		int[] curr=new int[m+1];

		for(int j=0;j<=m;j++) {
			prev[j]=0;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s.charAt(i-1)==t.charAt(j-1)){
					curr[j] = 1 + prev[j-1];
				}
				else {
				curr[j]=Math.max(prev[j], curr[j-1]);
				}
			}
			prev=curr.clone();
		}
		return prev[m];
	}
}
