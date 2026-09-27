//Binary Search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS=matrix.length;
        int COLS=matrix[0].length;
        int top=0;
        int bot=ROWS-1;
        while(top<=bot){
            int row=(top+bot)/2;
            if(target>matrix[row][COLS-1]){
                top=row+1;
            }else if(target<matrix[row][0]){
                bot=row-1;
            }
            else{
                break;
            }
        }
        int l=0,r=COLS-1;
        int row=(top+bot)/2;
        if(!(top<=bot)){
            return false;
        }
        while(l<=r){
            int m=(l+r)/2;
            if(target>matrix[row][m]){
                l=m+1;
            }
            else if(target<matrix[row][m]){
                r=m-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
