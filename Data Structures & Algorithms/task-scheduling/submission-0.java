class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];

        //count task frq
        for(int task:tasks){
            freq[task-'A']++;
        }

        //Max Heap
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int count:freq){
            if(count>0){
                maxHeap.offer(count);
            }
        }

        //Queue Store :[remaining freq,available time]
        Queue<int[]> queue=new LinkedList<>();
        int time=0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;

            //Execute the most freq available time
            if(!maxHeap.isEmpty()){
                int count=maxHeap.poll();
                count--;

                if(count>0){
                    queue.offer(new int[]{count,time+n});
                }
            }

            //Move tasks whose cooldown has finished back to help
            if(!queue.isEmpty() && queue.peek()[1]==time){
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
