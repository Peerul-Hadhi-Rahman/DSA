class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> values=new ArrayList<>();
        List<Integer> positions =new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            if(nums[i]>=0) {
                values.add(nums[i]);
                positions.add(i);
            }
        }
        int n=values.size();
        if(n==0) return nums;

        k%=n;
        Collections.rotate(values, -k);
        for(int i=0;i<n;i++) {
            nums[positions.get(i)]=values.get(i);
        }
        return nums;
    }
}
