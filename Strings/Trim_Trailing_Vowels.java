class Solution {
    public String trimTrailingVowels(String s) {
        int j=-1;
       
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i)!='a' && s.charAt(i)!='e' && 
            s.charAt(i)!='i' && s.charAt(i)!='o' && s.charAt(i)!='u') {
                j=i;
                break;
            }
        }
        if(j==-1) return "";
        
        return s.substring(0, j+1);
    }
}
