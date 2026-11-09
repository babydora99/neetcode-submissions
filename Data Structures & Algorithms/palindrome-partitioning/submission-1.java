//Backtracking +Palindrome Checking 
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> curr=new ArrayList<>();

        backtrack(0,s,res,curr);
        return res;
    }
    private void backtrack(int start,String s,List<List<String>> res,List<String> curr){
        //entire string is partitioned
        if(start==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        //Try every possible ending position
        for(int end=start;end<s.length();end++){
            String substring=s.substring(start,end+1);
            //only choose palindrome substrings
            if(isPalindrome(substring)){
                curr.add(substring);
                backtrack(end+1,s,res,curr);

                //Backtracking 
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPalindrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
