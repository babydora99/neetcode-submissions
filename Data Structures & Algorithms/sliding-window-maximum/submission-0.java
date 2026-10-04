class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int[n-k+1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int r=0;r<n;r++){
            //add value and index
            pq.offer(new int[]{nums[r],r});

            //remove element that are outside of the window
            while (pq.peek()[1] <= r - k) {
                pq.poll();
            }
            if(r>=k-1){
                result[r-k+1]=pq.peek()[0];
            }
        }
        return result;
    }
}
