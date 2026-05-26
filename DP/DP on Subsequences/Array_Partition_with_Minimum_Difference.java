public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
        int total=0;
        for(int a:arr) total+=a;
        int k=total;

        boolean[] prev=new boolean[total+1];
        boolean[] curr=new boolean[total+1];
        prev[0]=true; curr[0]=true;

        if(arr[0]<=total) {
            prev[arr[0]]=true;
        }

        for(int i=1;i<n;i++) {
            for(int target=1;target<=k;target++) {
                boolean notTake=prev[target];
                boolean take=false;
                if(arr[i]<=target) {
                    take=prev[target-arr[i]];
                }
                curr[target]= take || notTake;
            }
            prev=curr.clone();
        }
        
        int mini=Integer.MAX_VALUE;

        for(int s1=0;s1<=total/2;s1++) {
            if(curr[s1]==true) {
                mini=Math.min(mini, Math.abs(total-2*s1));
            }
        }
        return mini;
    }
}
