class MedianFinder {
    PriorityQueue<Integer> small; //Max Heap
    PriorityQueue<Integer> large; //Min Heap
    public MedianFinder() {
        small=new PriorityQueue<>(Collections.reverseOrder());
        large=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //Add number to the smaller half
        small.offer(num);
        //Every element in small <=every element in large
        large.offer(small.poll());
        //Balance the sizes
        if(large.size()>small.size()){
            small.offer(large.poll());
        }
        
    }
    
    public double findMedian() {
        if(large.size()<small.size()){
            return small.peek();
        }
        return (small.peek()+large.peek())/2.0;
    }
}
