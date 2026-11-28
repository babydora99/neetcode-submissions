//space optimized DP
class Solution {
    public int maxProduct(int[] nums) {
        int maxProd=nums[0];
        int minProd=nums[0];

        int res=nums[0];

        for(int i=1;i<nums.length;i++){
            int curr=nums[i];

            //Negative num can swap maximum and minimum
            if(curr<0){
                int temp=maxProd;
                maxProd=minProd;
                minProd=temp;
            }

            //calculate maximum and minimum prod
            maxProd=Math.max(curr,maxProd*curr);
            minProd=Math.min(curr,minProd*curr);

            //update global maximum
            res=Math.max(res,maxProd);
        }
        return res;
    }
}
