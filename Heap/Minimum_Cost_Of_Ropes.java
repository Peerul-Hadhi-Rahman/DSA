class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
      
        for (long x : arr) {
            pq.add(x);
        }
        long cost=0;
        while (pq.size()>1) {
            long first=pq.poll();
            long second=pq.poll();
            long sum=first+second;
            cost+=sum;
            pq.add(sum);
        }
        return (int)cost;
    }
}
