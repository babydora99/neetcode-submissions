class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int A = nums1.length;
        int B = nums2.length;

        int total = A + B;
        int half = (total + 1) / 2;

        int l = 0;
        int r = A;

        while (l <= r) {

            // Number of elements taken from nums1
            int i = l + (r - l) / 2;

            // Number of elements taken from nums2
            int j = half - i;

            // Boundary values
            int Aleft = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < A) ? nums1[i] : Integer.MAX_VALUE;

            int Bleft = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < B) ? nums2[j] : Integer.MAX_VALUE;

            // Correct partition
            if (Aleft <= Bright && Bleft <= Aright) {

                // Odd total length
                if (total % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                }

                // Even total length
                return (Math.max(Aleft, Bleft)
                        + Math.min(Aright, Bright)) / 2.0;
            }

            // Too many elements taken from nums1
            else if (Aleft > Bright) {
                r = i - 1;
            }

            // Too few elements taken from nums1
            else {
                l = i + 1;
            }
        }

        return 0.0;
    }
}