class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        
        while(l<r){
            int curr=numbers[l]+numbers[r];

            if(curr<target){
                l++;
            }
            else if(curr>target){
                r--;
            }
            else{
                return new int[]{l+1,r+1};
            }
        }
        return new int[0];

    }
}
