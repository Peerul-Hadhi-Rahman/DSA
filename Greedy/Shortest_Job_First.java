class Solution {
    static int solve(int bt[]) {
       Arrays.sort(bt);
       int wt=0, t=0;
       
       for(int i=0;i<bt.length;i++) {
           wt+=t;
           t+=bt[i];
       }
       return wt/bt.length;
    }
}
