//BFS
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        Queue<int[]> queue=new LinkedList<>();
        int INF=  2147483647;

        //Add all treasure chests to the queue
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions={
            {-1,0}, //up
            {1,0}, //Down
            {0,-1}, //Left
            {0,1} //Right
        };
        //Multi-source BFS
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            for(int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];

                //check boundaries
                if(nr<0 || nc<0 || nr>=row || nc>=col){
                    continue;
                }
                //only visit unvisited land cells
                if(grid[nr][nc]!=INF){
                    continue;
                }
                //update distance
                grid[nr][nc]=grid[r][c]+1;
                //Add the cell to the queue
                queue.offer(new int[]{nr,nc});
            }
        }          
    }
}
