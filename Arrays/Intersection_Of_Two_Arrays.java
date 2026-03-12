class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set=new HashSet<>();
        for(int i:nums1) {
            set.add(i);
        }

        List<Integer> lis=new ArrayList<>();
        for(int i:nums2) {
            if(set.contains(i)) {
                lis.add(i);
                set.remove(i);
            }
        }
        
        int[] res=new int[lis.size()];
        int i=0;
        for(int num:lis) {
           res[i++]=num;
        }
        return res;
    }
}
