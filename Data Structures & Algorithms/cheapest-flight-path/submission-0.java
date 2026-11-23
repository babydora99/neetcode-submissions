//Bellman-Ford Algorithm (limited to k + 1 iterations)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist=new int[n];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        //At most k+1 flights
        for(int i=0;i<=k;i++){
            int[] temp=dist.clone();

            for(int[] flight:flights){

                int from=flight[0];
                int to=flight[1];
                int price=flight[2];

                if(dist[from]!=Integer.MAX_VALUE){
                    int newCost=dist[from]+price;
                    temp[to]=Math.min(temp[to],newCost);
                }
            }
            dist=temp;
        }
        return dist[dst]==Integer.MAX_VALUE ? -1:dist[dst];
    }
}
