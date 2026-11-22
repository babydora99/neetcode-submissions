//Dijkstra's Algorithm on a 2D grid
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;

        boolean[][] visited=new boolean[n][n];

        //{time,row,col}
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        pq.offer(new int[]{grid[0][0],0,0});
        int[][] direction={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!pq.isEmpty()){
            int[] curr=pq.poll();

            int time=curr[0];
            int row=curr[1];
            int col=curr[2];

            if(visited[row][col]){
                continue;
            }
            visited[row][col]=true;

            //destination reached
            if(row==n-1 && col==n-1){
                return time;
            }

            //explore four directions
            for(int[] dir:direction){
                int newRow=row+dir[0];
                int newCol=col+dir[1];

                if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && !visited[newRow][newCol]){
                    int newTime=Math.max(time,grid[newRow][newCol]);
                    pq.offer(new int[]{newTime,newRow,newCol});
                }
            }
        }
        return -1;
    }
}
