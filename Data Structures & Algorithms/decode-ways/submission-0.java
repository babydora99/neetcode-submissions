//DP Array
class Solution {
    public int numDecodings(String s) {
        int n=s.length();

        int[] dp=new int[n+1];

        //Empty string has one way to decode
        dp[0]=1;

        //First character 
        dp[1]=s.charAt(0)=='0'?0:1;

        for(int i=2;i<=n;i++){
            //choice 1:Take one digit
            int oneDigit=s.charAt(i-1)-'0';
            if(oneDigit>=1 && oneDigit<=9){
                dp[i]+=dp[i-1];
            }
            //choice 2:Take two digits
            int twoDigits=Integer.parseInt(s.substring(i-2,i));

            if(twoDigits>=10 && twoDigits<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }
}
