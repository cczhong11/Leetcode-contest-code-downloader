class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] now = new double[N][N];
        now[r][c] = 1.0;
        
        int[] dx = new int[] {-2,-2,-1,-1,1,1,2,2};
        int[] dy = new int[] {-1,1,-2,2,-2,2,-1,1};
        for (int i=0; i<K; i++){
            double[][] next = new double[N][N];
            for (int j=0; j<N; j++)
                for (int k=0; k<N; k++)
                    if (now[j][k]>0)
                        for (int l = 0; l<dx.length; l++){
                            int x = j + dx[l];
                            int y = k + dy[l];
                            if (x>=0 && x<N && y>=0 && y<N)
                                next[x][y] += now[j][k]/dx.length;
                        }
            now = next;
        }
        
        double res = 0.0;
        for (int i=0;i<N;i++)
            for (int j=0;j<N;j++)
                res+=now[i][j];
        return res;
                
    }
}