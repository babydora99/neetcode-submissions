class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        int l=0,res=0;
        for(int i=0;i<s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                l=Math.max(mp.get(s.charAt(i))+1,l);
            }
            mp.put(s.charAt(i),i);
            res=Math.max(res,i-l+1);
        }
        return res;
    }
}
