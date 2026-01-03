class Solution {
    static class Node {
        int val, row, idx;
        Node(int v, int r, int i) {
            val=v;
            row=r;
            idx=i;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq=new PriorityQueue<>((a, b) -> a.val - b.val);

        int max=Integer.MIN_VALUE;

        for (int i=0;i<nums.size();i++) {
            int val=nums.get(i).get(0);
            pq.offer(new Node(val, i, 0));
            max=Math.max(max, val);
        }
      
        int start=0, end=Integer.MAX_VALUE;

        while(pq.size()==nums.size()) {
            Node cur=pq.poll();
            int min=cur.val;

            if (max-min<end-start) {
                start=min;
                end=max;
            }
            if (cur.idx+1 < nums.get(cur.row).size()) {
                int nextVal=nums.get(cur.row).get(cur.idx+1);
                pq.offer(new Node(nextVal, cur.row, cur.idx+1));
                max=Math.max(max, nextVal);
            } 
            else {
                break;
            }
        }
        return new int[]{start, end};
    }
}
