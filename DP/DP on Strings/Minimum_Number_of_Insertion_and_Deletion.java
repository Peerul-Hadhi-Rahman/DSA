Input: 's1' = "abcd", 's2' = "anc"
Output: 3

// convert s1 to s2, here common subsequence is "ac" 
//   subtracting s1.length() - LCS,  s2.length() - LCS 
//   Adding both gives the answer
//   Explanation : LCS -> 2, s1 length =4, s2 length =3, 
//   (4-2) + (3-2) => 3

  public class Solution {
    public static int canYouMake(String s1, String s2) {
        return s1.length() - lcs(s1, s2) + + s2.length() - lcs(s1, s2);
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
