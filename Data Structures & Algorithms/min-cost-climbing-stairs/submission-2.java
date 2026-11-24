//Space Optimized DP
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int prev2=cost[0];
        int prev1=cost[1];
        for(int i=2;i<n;i++){
            int curr=cost[i]+Math.min(prev2,prev1);
            prev2=prev1;
            prev1=curr;
        }
        return Math.min(prev1,prev2);
    }
}
