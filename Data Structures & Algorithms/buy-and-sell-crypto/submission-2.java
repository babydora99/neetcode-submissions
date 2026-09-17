class Solution {
    public int maxProfit(int[] prices) {
        //USING Two Pointers
        int l=0,r=1;
        int maxP=0;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                int profit=prices[r]-prices[l];
                maxP=Math.max(maxP,profit);
            }
            else{
                l=r;
            }
            r++;
        }
        return maxP;

        //USING Dynamic Programming
        // int maxP=0;
        // int minBuy=prices[0];

        // for(int sell:prices){
        //     minBuy=Math.min(minBuy,sell);
        //     maxP=Math.max(maxP,sell-minBuy);
        // }
        // return maxP;
    }
}
