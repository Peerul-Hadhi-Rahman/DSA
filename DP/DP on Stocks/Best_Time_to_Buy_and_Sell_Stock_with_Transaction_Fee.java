// Same as Stocks 2 problem with transaction 
// Subtract transaction fee for every transaction

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int aheadBuy=0, aheadNotBuy=0, currBuy=0, currNotBuy=0;

        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<=1;j++) {

             currBuy = Math.max(-prices[i] + aheadNotBuy, aheadBuy);
             
             currNotBuy = Math.max(aheadNotBuy , (prices[i] + aheadBuy)-fee);
            
            }
            aheadBuy=currBuy;
            aheadNotBuy=currNotBuy;
        }
        return aheadBuy;
    }
}
