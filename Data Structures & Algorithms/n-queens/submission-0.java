class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        boolean[] cols=new boolean[n];
        boolean[] diagonal1=new boolean[2*n-1];
        boolean[] diagonal2=new boolean[2*n-1];

        backtrack(0,n,board,cols,diagonal1,diagonal2,res);
        return res;
    }
    private void backtrack(int row,int n,char[][] board,boolean[] cols,boolean[] diagonal1,boolean[] diagonal2,List<List<String>> res){
        //All queens have been placed
        if(row==n){
            List<String> sol=new ArrayList<>();

            for(int i=0;i<n;i++){
                sol.add(new String(board[i]));
            }
            res.add(sol);
            return;
        }
        //Try placing a queen in every col
        for(int col=0;col<n;col++){
            int d1=row-col+n-1;
            int d2=row+col;

            //check if pos is safe
            if(cols[col] || diagonal1[d1] || diagonal2[d2]){
                continue;
            }
            //place queen
            board[row][col]='Q';
            cols[col]=true;
            diagonal1[d1]=true;
            diagonal2[d2]=true;

            //move the next row
            backtrack(row+1,n,board,cols,diagonal1,diagonal2,res);
            //backtracking : remove queen
            board[row][col]='.';
            cols[col]=false;
            diagonal1[d1]=false;
            diagonal2[d2]=false;
        }
    }
}
