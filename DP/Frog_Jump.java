class Solution {
    public int frogJump(int[] h) {
        int n = h.length;

        int prev = 0;  
        int prev2 = 0;  

        for (int i = 1; i < n; i++) {
            int oneStep = prev + Math.abs(h[i] - h[i - 1]);

            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                twoStep = prev2 + Math.abs(h[i] - h[i - 2]);
            }

            int curr = Math.min(oneStep, twoStep);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
