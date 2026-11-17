//BFS
class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        int minutes=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!queue.isEmpty() && fresh>0){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int r=curr[0];
                int c=curr[1];
                for(int[] dir:directions){
                    int nr=r+dir[0];
                    int nc=c+dir[1];

                    if(nr<0||nc<0||nr>=row||nc>=col){
                        continue;
                    }    
                    //only fresh fruits can become rotten
                    if(grid[nr][nc]!=1){
                        continue;
                    }
                    //rot the fresh fruit
                    grid[nr][nc]=2;
                    fresh--;
                    queue.offer(new int[]{nr,nc});
                }    
            }
            minutes++;                
        }
        return fresh==0?minutes:-1;
    }             
}
