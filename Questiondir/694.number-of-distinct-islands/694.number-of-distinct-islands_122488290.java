class Solution {
    int n,m;
    boolean[][] visited;
    public int numDistinctIslands(int[][] grid) {
        n = grid.length;
        if (n==0)
            return 0;
        m = grid[0].length;
        if (m==0)
            return 0;
        
        
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        int res = 0;
        
        visited = new boolean[n][m];
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++){
                if (!visited[i][j] && grid[i][j]==1)
                    visit(grid,i,j);
                else 
                    continue;
                
                boolean isNew = true;
                for (int k=0; k<xList.size(); k++){
                    if (same(visited, i, j, xList.get(k), yList.get(k))){
                        isNew = false;
                        break;
                    }
                }
                if (isNew){
                        res++;
                        xList.add(i);
                        yList.add(j);
                }
            }
        
        return res;
    }
    
    private boolean same(boolean[][] visited, int x1, int y1, int x2, int y2){
        int disx = x2-x1;
        int disy = y2-y1;
        
        boolean[][] check = new boolean[n][m];
        LinkedList<Integer> xList = new LinkedList<>();
        LinkedList<Integer> yList = new LinkedList<>();
        xList.add(x1);
        yList.add(y1);
        check[x1][y1]=true;
        
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};
        while (xList.size() > 0){
            int x = xList.remove();
            int y = yList.remove();
            
            for (int i=0;i<4;i++){
                if (isValid(x+dx[i],y+dy[i]) != isValid(x+dx[i]+disx,y+dy[i]+disy))
                    return false;
                
                
                if (isValid(x+dx[i],y+dy[i]) && !check[x+dx[i]][y+dy[i]]){
                    check[x+dx[i]][y+dy[i]] = true;
                    xList.add(x+dx[i]);
                    yList.add(y+dy[i]);
                }
            }
        }
        
        return true;
    }
    
    private void visit(int[][] grid, int x, int y){
        visited[x][y] = true;
        if (x>0 && !visited[x-1][y] && grid[x-1][y]>0)
            visit(grid,x-1,y);
        
        if (x+1<n && !visited[x+1][y] && grid[x+1][y]>0)
            visit(grid,x+1,y);
        
        if (y>0 && !visited[x][y-1] && grid[x][y-1]>0)
            visit(grid,x,y-1);
        
        if (y+1<m && !visited[x][y+1] && grid[x][y+1]>0)
            visit(grid,x,y+1);
    }
    
    private boolean isValid(int x, int y){
        return x>=0 && x<n && y>=0 && y<m && visited[x][y];
    }
}