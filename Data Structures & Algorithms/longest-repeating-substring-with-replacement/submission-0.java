class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> count=new HashMap<>();

        int l=0,res=0,maxF=0;
        for(int r=0;r<s.length();r++){
            count.put(s.charAt(r),count.getOrDefault(s.charAt(r),0)+1);
            maxF=Math.max(maxF,count.get(s.charAt(r)));
            while((r-l+1 )- maxF >k){
                count.put(s.charAt(l),count.get(s.charAt(l))-1); // decrement in count
                l++; //increment of left pointer by 1
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}
