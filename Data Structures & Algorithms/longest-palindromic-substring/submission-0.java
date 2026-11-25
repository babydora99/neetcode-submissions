//Expand Around Center
class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int maxLen=0;

        for(int i=0;i<s.length();i++){
            //odd len pallindrome
            int len1=expand(s,i,i);
            //even len pallindrome
            int len2=expand(s,i,i+1);

            int len=Math.max(len1,len2);
            if(len>maxLen){
                maxLen=len;
                start=i-(len-1)/2;
            }
        }
        return s.substring(start,start+maxLen);
    }
    private int expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
