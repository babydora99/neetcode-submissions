class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int r,int c,int index){
        //All characters matched
        if(index==word.length()){
            return true;
        }

        //Check boundaries and character match
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!=word.charAt(index)){
            return false;
        }

        //Mark current cell as visited
        char temp=board[r][c];
        board[r][c]='#';

        boolean found=
        dfs(board,word,r-1,c,index+1) || //UP
        dfs(board,word,r+1,c,index+1) || //DOWN
        dfs(board,word,r,c-1,index+1) || //LEFT
        dfs(board,word,r,c+1,index+1);   //RIGHT

        //Restore original character
        board[r][c]=temp;

        return found;
    }
}
