class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map=new HashMap<>();

        for(int num:nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> lis=new ArrayList<>();
        for(int num:nums2) {
            if(map.getOrDefault(num, 0) > 0) {
                lis.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] res=new int[lis.size()];
        int i=0;
        for(int a:lis) {
            res[i++]=a;
        }
        return res;
    }
}
