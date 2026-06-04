//Input -> codingninjas 
// Here input has "ingni" palindrome 
// To make a insertion to covert input as palindrom -> cod "ingni" jas
//Reversing cod -> doc. as same as jas -> saj 
//inserting reversed string to make a input as palindrome below : 
//now 
//cod saj "ingni" jas doc now this is palindrome 
//Insertion count is cod-3 + jas-3 => 6
// To find this just subtract the inputLength - LPS of string 
//codingninjas length = 11, LPS of codingninjas is 5 because "ingni"
// Answer is 11 - 5 => 6
  

public class Solution {
    public static int minInsertion(String str) {
        return str.length() - longestPalindromeSubsequence(str);
    }
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
