OPTIMIZED CODE

public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp=new int[n+1][m+1];

		for(int j=0;j<=m;j++) {
			dp[0][j]=0;
		}
		for(int i=0;i<=n;i++) {
			dp[i][0]=0;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
				dp[i][j]=Math.max(dp[i-1][j],
					    dp[i][j-1]);
				}
			}
		}
		int len = dp[n][m];
        int index=len-1;
        char[] ch=new char[len];
        
        int i=n, j=m;
        while(i>0 && j>0) {
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                ch[index]=s1.charAt(i-1);
                index--;
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]) {
                i--;
            }
            else {
                j--;
            }
        }
        String ans=new String(ch);
        return ans;
    }
}
