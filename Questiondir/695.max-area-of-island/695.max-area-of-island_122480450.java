class Solution {
      public int maxAreaOfIsland(int[][] grid) {
        int h=grid.length,w=h==0?0:grid[0].length;
        if (w==0)return 0;
        int ans=0;
        int[]dirs={1,0,-1,0,1};
        for (int y=0;y<h;++y){
            for (int x=0;x<w;++x){
                if (grid[y][x]==0)continue;
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{y,x});
//                log.info("add {},{}", y, x);
                grid[y][x]=0;
                int curAns=0;
                while (!q.isEmpty()){
                    ++curAns;
                    int[]cur=q.remove();
//                    log.info("Remove {}", cur);
                    for (int k=0;k<4;++k){
                        int ny=cur[0]+dirs[k],nx=cur[1]+dirs[k+1];
//                        log.info("ny, nx: {}, {}", ny, nx);
                        if (ny>=0&&ny<h&&nx>=0&&nx<w&&grid[ny][nx]==1){
                            q.add(new int[]{ny,nx});
//                            log.info("add {},{}", ny, nx);
                            grid[ny][nx]=0;
                        }
                    }
                }
                ans=Math.max(ans,curAns);
            }
        }
        return ans;

    }
}