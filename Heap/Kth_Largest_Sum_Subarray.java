class Solution {
    public static int kthLargest(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            int sum=0;
            for(int j=i;j<n;j++) {
                sum+=arr[j];
                if(pq.size()<k) {
                    pq.add(sum);
                }
                else if(sum>pq.peek()) {
                    pq.poll();
                    pq.add(sum);
                }
            }
        }
        return pq.peek();
    }
}
