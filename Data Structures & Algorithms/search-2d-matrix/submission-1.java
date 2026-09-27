//Binary Search(one pass)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW=matrix.length,COL=matrix[0].length;
        int l=0,r=ROW*COL-1;
        while(l<=r){
            int m=l+(r-l)/2;
            int row=m/COL;
            int col=m%COL;
            if(target>matrix[row][col]){
                l=m+1;
            }else if(target<matrix[row][col]){
                r=m-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
