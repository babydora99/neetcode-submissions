//Prim's Algorithm
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[] visited=new boolean[n];
        int[] minDist=new int[n];

        Arrays.fill(minDist,Integer.MAX_VALUE);
        minDist[0]=0;
        int totalCost=0;
        for(int count=0;count<n;count++){
            int curr=-1;

            //find unvisted point with minimum connection cost
            for(int i=0;i<n;i++){
                if(!visited[i] && (curr==-1 || minDist[i]<minDist[curr])){
                    curr=i;
                }
            }
            //Add this point to the MST
            visited[curr]=true;
            totalCost+=minDist[curr];

            //update the minimum distance for remaining points
            for(int next=0;next<n;next++){
                if(!visited[next]){
                    int distance=Math.abs(points[curr][0]-points[next][0])+Math.abs(points[curr][1]-points[next][1]);
                    minDist[next]=Math.min(minDist[next],distance);
                }
            }
        }
        return totalCost;
    }
}
