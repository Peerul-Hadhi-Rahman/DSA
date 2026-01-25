class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n=nums.length;
        int start=n-1;
        for(int i=n-2;i>=0;i--) {
            if(nums[i]<nums[i+1]){
                start=i;
            }
            else {
                break;
            }
        }
        return start;
    }
}
