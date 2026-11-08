//Sorting + Backtracking
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        //sort the array to find the duplicates
        Arrays.sort(nums);
        backtrack(0,nums,curr,res);
        return res;
    }
    private void backtrack(int index,int[] nums,List<Integer> curr,List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            backtrack(i+1,nums,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}
