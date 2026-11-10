class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder curr=new StringBuilder();
        backtrack(0,map,digits,curr,res);
        return res;
    }
    private void backtrack(int index,String[] map,String digits,StringBuilder curr,List<String> res){
        if(index==digits.length()){
            res.add(curr.toString());
            return;
        }
        
        String letter=map[digits.charAt(index)-'0'];
        for(int i=0;i<letter.length();i++){
            curr.append(letter.charAt(i));
            backtrack(index+1,map,digits,curr,res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
