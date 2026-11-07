class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        boolean[] used=new boolean[nums.length];

        backtrack(used,nums,curr,res);
        return res;
    }
    private void backtrack(boolean[] used,int[] nums,List<Integer> curr,List<List<Integer>> res){
        //if all the elemets are selected ,save the permutation
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            curr.add(nums[i]);
            used[i]=true;
            backtrack(used,nums,curr,res);
            curr.remove(curr.size()-1);
            used[i]=false;
        }   
    }
}
