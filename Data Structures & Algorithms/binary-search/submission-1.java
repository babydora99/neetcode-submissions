//Recursive Binary Search
class Solution {
    public int binarySearch(int l,int r,int[] nums,int target){
        if(l>r) return -1;
        int m=l+(r-l)/2;
        if(nums[m]==target) return m;
        return (nums[m]<target) ? binarySearch(m+1,r,nums,target): binarySearch(l,m-1,nums,target);
    }
    public int search(int[] nums, int target) {
        return binarySearch(0,nums.length-1,nums,target);
    }
}
