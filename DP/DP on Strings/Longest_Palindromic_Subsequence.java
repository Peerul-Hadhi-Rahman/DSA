//Just reverse the given String and use the LCS fuction 
OPTIMIZED CODE
  
  public class Solution {
	public static int longestPalindromeSubsequence(String s) {
	
		String reverse=new StringBuilder(s).reverse().toString();
		return lcs(s, reverse);
	}
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
