class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n=capacity.length;
        int minCapacity=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<n;i++) {
            if(capacity[i]>=itemSize && capacity[i]<minCapacity){
                minCapacity=capacity[i];
                index=i;
            }
        }
        return index;
    }
}
