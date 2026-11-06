class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        backtrack(0,nums,target,curr,res);
        return res;
    }
    private void backtrack(int index,int[] nums,int target,List<Integer> curr,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(nums[i]>target) continue;
            curr.add(nums[i]);
            //reuse the same element:use i instead of i+1
            backtrack(i,nums,target-nums[i],curr,res);
            curr.remove(curr.size()-1);
        }
    }
}

