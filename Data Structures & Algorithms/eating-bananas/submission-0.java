//Binary Search
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=Arrays.stream(piles).max().getAsInt();
        int res=r;
        while(l<=r){
            long totalTime=0;
            int k=(l+r)/2;
            for(int p:piles){
                totalTime+=(int) Math.ceil((double)p/k);
            }
            if(totalTime<=h){
                res=k;
                r=k-1;
            }else{
                l=k+1;
            }
        }
        return res;
    }
}
