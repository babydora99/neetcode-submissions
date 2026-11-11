class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap=new PriorityQueue<>();
        this.k=k;
        for(int num:nums){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>k){
            minHeap.poll();
        }
        return minHeap.peek();
        
    }
}
