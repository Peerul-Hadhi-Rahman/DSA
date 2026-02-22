class Solution {
    public String reverseVowels(String s) {
        int l=0;
        int r=s.length()-1;
        char ch[]=s.toCharArray();

        while(l<=r) {
            if(!vowel(ch[l])) {
                l++;
            }
            else if(!vowel(ch[r])) {
                r--;
            }
            else {
                char temp=ch[l];
                ch[l]=ch[r];
                ch[r]=temp;
                l++;
                r--;
            }
        }
        return String.valueOf(ch);
    }
    public boolean vowel(char ch) {
        if(ch=='a' || ch=='e'|| ch=='i'|| ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
            return true;
        }
        return false;
    }
}
