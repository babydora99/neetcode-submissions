class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<r){
            int m=(l+r)/2;
            if(nums[m]>nums[r]){
                l=m+1;
            }else{
                r=m;
            }
        }
        int pivot=l;
        int result=binarySearch(nums,target,0,pivot-1);
        if(result!=-1){
            return result;
        }
        return binarySearch(nums,target,pivot,nums.length-1);
    }
    public int binarySearch(int[] nums,int target,int l,int r){
        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]==target){
                return m;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return -1;
    }
}
