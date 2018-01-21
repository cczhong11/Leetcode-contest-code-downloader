class Solution {
    public int[][] imageSmoother(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        
        int[][] res = new int[n][m];
        int[] dx = new int[] {-1,-1,-1,0,0,0,1,1,1};
        int[] dy = new int[] {-1,0,1,-1,0,1,-1,0,1};
        
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++){
                int sum = 0;
                int count = 0;
                for (int k=0;k<9;k++){
                    if (i+dx[k]>=0 && i+dx[k]<n && j+dy[k]>=0 && j+dy[k]<m){
                        sum += M[i+dx[k]][j+dy[k]];
                        count++;
                    }
                }
                res[i][j] = sum/count;
            }
        
        return res;
    }
}