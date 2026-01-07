class Solution {
    public char getMaxOccuringChar(String s) {
        int[] freq=new int[26];
      
        for (char c:s.toCharArray()) {
            freq[c-'a']++;
        }
        int max=-1;
        char result='a';
        
        for (int i=0;i<26;i++) {
            if (freq[i]>max) {
                max=freq[i];
                result = (char) (i+'a');
            }
        }
        return result;
    }
}
