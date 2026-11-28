//0/1 Knapsack Dynamic Programming
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;

        //calculate total sum
        for(int num:nums){
            totalSum+=num;
        }
        
        //odd sum cannot be divided equally 
        if(totalSum%2!=0){
            return false;
        }

        int target=totalSum/2;
        
        //dp[j] tells whether sum j is possible
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int num:nums){
            //traverse backwards
            for(int j=target;j>=num;j--){
                dp[j]=dp[j] || dp[j-num];
            }
        }
        return dp[target];
    }
}