//Backtrack
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder curr=new StringBuilder();
        backtrack(0,0,n,res,curr);
        return res;
    }
    private void backtrack(int open,int close,int n,List<String> res,StringBuilder curr){
        //if all n pairs are used
        if(curr.length()==2*n){
            res.add(curr.toString());
            return;
        }
        //Check the open bracket is exceed to n or available 
        if(open<n){
            curr.append('(');
            backtrack(open+1,close,n,res,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        //Add closing bracket ,only if it is matching with open bracket
        if(close<open){
            curr.append(')');
            backtrack(open,close+1,n,res,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
