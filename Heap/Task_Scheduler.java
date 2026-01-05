class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq=new int[26];
        for (char c:tasks) {
            freq[c-'A']++;
        }

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        for (int f:freq) {
            if (f>0) maxHeap.add(f);
        }
        int time=0;

         while (!maxHeap.isEmpty()) {
            int cycle = n + 1;
            List<Integer> temp = new ArrayList<>();

            while (cycle>0 && !maxHeap.isEmpty()) {
            int curr=maxHeap.poll();
            if (curr-1>0) {
                temp.add(curr-1);
            }
            time++;
            cycle--;
        }

        for (int t:temp) {
            maxHeap.add(t);
        }
        if (!maxHeap.isEmpty()) {
            time+=cycle;
        }
        }
        return time;
    }
}
