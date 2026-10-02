class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
       }
       int A=nums1.length;
       int B=nums2.length;

       int total=A+B;
       int half=(total+1)/2;

       int l=0;
       int r=A;
        while(l<=r){
            int i=l+(r-l)/2;
            int j=half-i;

            //boundary rules
            int Aleft=(i>0)?nums1[i-1]:Integer.MIN_VALUE;
            int Aright=(i<A)?nums1[i]:Integer.MAX_VALUE;

            int Bleft=(j>0)?nums2[j-1]:Integer.MIN_VALUE;
            int Bright=(j<B)?nums2[j]:Integer.MAX_VALUE;
            //Correct partition
            if(Aleft<=Bright && Bleft<=Aright){
                if(total%2==1){
                    return Math.max(Aleft,Bleft);
                }
                //even total length
                return (Math.max(Aleft,Bleft)+Math.min(Aright,Bright))/2.0;
            }
            else if(Aleft>Bright){
                r=i-1;
            }else{
                l=i+1;
            }
        }
        return 0.0;
    }
}