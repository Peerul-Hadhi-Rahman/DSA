class Solution {
    public int residuePrefixes(String s) {

        int[] freq  = new int[26];
        int distinct=0, count=0;
      
        for (int i=0;i<s.length();i++) {
            int idx=s.charAt(i) - 'a';
            
               if (freq[idx] == 0) {
                distinct++;
            }
            freq[idx]++;

            int len = i + 1;
            if (distinct == len % 3) {
                count++;
            }
        }
        return count;
    }
}
