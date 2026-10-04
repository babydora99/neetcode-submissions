class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> countT=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();

        //count char required from t
        for(char c:t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1);
        }

        int have=0;
        int need=countT.size();

        int l=0;
        int resLen=Integer.MAX_VALUE;
        int resLeft=0;

        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);

            //Add curr char to window
            window.put(c,window.getOrDefault(c,0)+1);

            //check if this char now satisfies its required freq
            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }
            //window is valid
            while(have==need){
                //update smallest answer
                if(r-l+1 <resLen){
                    resLen=r-l+1;
                    resLeft=l;
                }
                //Remove the left char
                char leftChar=s.charAt(l);
                window.put(leftChar,window.get(leftChar)-1);

                //window becomes invalid dfor the required char
                if(countT.containsKey(leftChar) && window.get(leftChar)<countT.get(leftChar)){
                    have--;
                }
                l++;
            }
        }
            if(resLen==Integer.MAX_VALUE){
                return "";
            }
            return s.substring(resLeft,resLeft+resLen);

    }
}
