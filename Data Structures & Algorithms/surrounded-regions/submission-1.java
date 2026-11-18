//Graph+DFS+matrix Traversal
class Solution {
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;

        //check first and last column
        for(int i=0;i<row;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][col-1]=='O'){
                dfs(board,i,col-1);
            }
        }
        //check first and last row
        for(int j=0;j<col;j++){
            if(board[0][j]=='O'){
                dfs(board,0,j);
            }
            if(board[row-1][j]=='O'){
                dfs(board,row-1,j);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void dfs(char[][] board,int r,int c){
        //boundary and visited checks
        if(r<0 ||c<0||r>=board.length||c>=board[0].length||board[r][c]!='O'){
            return;
        }
        //mark safe boundary connected cell
        board[r][c]='T';
        //Explore four directions
        dfs(board,r-1,c);//Up
        dfs(board,r+1,c);//Down
        dfs(board,r,c-1);//Left
        dfs(board,r,c+1);//Right
    }
}
