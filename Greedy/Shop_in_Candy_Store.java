class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int n=prices.length;
        
        Arrays.sort(prices);
        
        int buy=0;
        int free=n-1;
        int mini=0;
        
        while(buy<=free) {
            mini+=prices[buy];
            buy++;
            free-=k;
        }
        
        buy=n-1;
        free=0;
        int maxi=0;
        
        while(free<=buy) {
            maxi+=prices[buy];
            buy--;
            free+=k;
        }
        
        ans.add(mini);
        ans.add(maxi);
        return ans;
    }
}
