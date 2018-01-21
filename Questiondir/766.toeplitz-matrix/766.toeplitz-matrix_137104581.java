class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r=matrix.length-1;
        int c=0;
        while(r>=0&&c<matrix[0].length){
            int tempR=r;
            int tempC=c;
            int val=matrix[tempR][tempC];
            while(tempR<matrix.length&&tempC<matrix[0].length){
                if(matrix[tempR][tempC]!=val){
                    return false;
                }
                tempR++;
                tempC++;
            }
            if(r==0){
                c++;
            }
            else{
                r--;
            }
        }
        return true;
    }
}