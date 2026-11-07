//Sort+Backtrack
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,target,curr,res);
        return res;
    }
    private void backtrack(int[] candidates,int index,int target,List<Integer> curr,List<List<Integer>> res){
        //
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            //skip duplicates on same recursion level
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            //array is sorted , so no need of the larger element
            if(candidates[i]>target){
                break;
            }

            curr.add(candidates[i]);
            //move to next elementbcz ssame element can't be used
            backtrack(candidates,i+1,target-candidates[i],curr,res);
            curr.remove(curr.size()-1);
        }
    }
}
