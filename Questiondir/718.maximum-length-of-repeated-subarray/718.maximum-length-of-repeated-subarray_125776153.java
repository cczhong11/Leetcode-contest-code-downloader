class Solution {
    public int findLength(int[] A, int[] B) {
        int la = A.length;
        int lb = B.length;
        int[][] ans = new int[la][lb];
        int max = 0;
        for(int i=0;i<la;i++){
            for(int j=0;j<lb;j++){
                if(A[i]==B[j]) {
                	ans[i][j] = i==0||j==0?1:ans[i-1][j-1]+1;
                	max = Math.max(max, ans[i][j]);
                }
            }
        }
        return max;
    }
}