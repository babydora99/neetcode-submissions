//Backtracking
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();

        BackTrack(0,nums,curr,res);
        return res;
    }
    private void BackTrack(int index,int[] nums,List<Integer> curr,List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            curr.add(nums[i]);//add elements in curr
            //Explore
            BackTrack(i+1,nums,curr,res);
            //Remove 
            curr.remove(curr.size()-1);
        }
    }
}
