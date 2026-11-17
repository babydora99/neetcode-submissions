class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;

        boolean[][] pacific=new boolean[row][col];
        boolean[][] atlantic=new boolean[row][col];

        //start dfs from pacific
        for(int i=0;i<row;i++){
            dfs(heights,pacific,i,0);
            dfs(heights,atlantic,i,col-1);
        }    
        //start dfs from atlantic and pacific horizontal borders
        for(int j=0;j<col;j++){
            dfs(heights,pacific,0,j);
            dfs(heights,atlantic,row-1,j);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights,boolean[][] visited,int r,int c){
        if(visited[r][c]){
            return;
        }
        visited[r][c]=true;
        int[][] directions={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        for(int[] dir:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr<0||nc<0||nr>=heights.length||nc>=heights[0].length){
                continue;
            }
            if(visited[nr][nc]){
                continue;
            }
            //Reverse water flow:move to equal or higher cells
            if(heights[nr][nc]>=heights[r][c]){
                dfs(heights,visited,nr,nc);
            }
        }
    }
}
