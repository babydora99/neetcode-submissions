class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        //only one house
        if(n==1){
            return nums[0];
        }
        //case 1:exclude the last house
        int case1=robLinear(nums,0,n-2);
        //case 2:exclude the first house
        int case2=robLinear(nums,1,n-1);
        return Math.max(case1,case2);
    }
    //Normal House Robber logic
    private int robLinear(int[] nums,int start,int end){
        int prev2=0;
        int prev1=0;

        for(int i=start;i<=end;i++){
            int rob=nums[i]+prev2;
            int skip=prev1;
            int curr=Math.max(rob,skip);

            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
