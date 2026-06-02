public class Solution {
    public static int targetSum(int n, int target, int[] arr) {
    	return countPartitions(n, target, arr);
    }
	public static int countPartitions(int n, int d, int[] arr) {
		int total=0;
		for(int row:arr) total+=row;

		if((total-d)<0 || (total-d)%2!=0) return 0;
		int target=(total-d)/2;

		int[] prev=new int[target+1];
		int[] curr=new int[target+1];
		prev[0]=0; curr[0]=0;

		if(arr[0]==0) prev[0]=2;
		else prev[0]=1;

		if(arr[0]!=0 && arr[0]<=target) {
			prev[arr[0]]=1;
		}

		for(int i=1;i<n;i++) {
			for(int k=0;k<=target;k++) {
				int notTake=prev[k];
				int take=0;
				if(arr[i]<=k) {
					take=prev[k-arr[i]];
				}
				curr[k]=take+notTake;
			}
			prev=curr.clone();
		}
		return prev[target];
	}
}
