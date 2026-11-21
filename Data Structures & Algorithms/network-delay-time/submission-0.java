//Dijkstra's Algorithm with a Min Heap (PriorityQueue)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build adjacency List
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int w=time[2];

            adj.get(u).add(new int[]{v, w});
        }
        //Distance array
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        //Min Heap:{distance,node}
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        dist[k]=0;
        minHeap.offer(new int[]{0,k});

        //Dijkstra's algorithm
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int currDist=curr[0];
            int node=curr[1];

            //skip outdated heap entries
            if(currDist>dist[node]){
                continue;
            }

            //Explore neightbors
            for(int[] neigh:adj.get(node)){
                int nextNode=neigh[0];
                int weight=neigh[1];
                int newDist=currDist+weight;

                if(newDist<dist[nextNode]){
                    dist[nextNode]=newDist;
                    minHeap.offer(new int[]{newDist,nextNode});
                }
            }
        }
        //Find maximum shortest distance
        int maxTime=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxTime=Math.max(maxTime,dist[i]);
        }
        return maxTime;
    }
}
