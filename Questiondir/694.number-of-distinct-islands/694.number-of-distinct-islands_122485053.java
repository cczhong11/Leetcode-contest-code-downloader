class Solution {
    public int numDistinctIslands(int[][] grid) {
                int h=grid.length,w=h==0?0:grid[0].length;
        if (w==0)return 0;
        int ans=0;
        int[]dirs={1,0,-1,0,1};
        Set<String> res=new HashSet<>();
        for (int y=0;y<h;++y){
            for (int x=0;x<w;++x){
                if (grid[y][x]==0)continue;
                int minY =y, minX=x;
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{y,x});
                grid[y][x]=0;
                int curAns=0;
                List<int[]>island=new ArrayList<>();
                while (!q.isEmpty()){
                    ++curAns;
                    int[]cur=q.remove();
                    island.add(cur);
                    minY=Math.min(minY,cur[0]);
                    minX=Math.min(minX,cur[1]);
                    for (int k=0;k<4;++k){
                        int ny=cur[0]+dirs[k],nx=cur[1]+dirs[k+1];
                        if (ny>=0&&ny<h&&nx>=0&&nx<w&&grid[ny][nx]==1){
                            q.add(new int[]{ny,nx});
                            grid[ny][nx]=0;
                        }
                    }
                }
                ans=Math.max(ans,curAns);
                int finalMinY=minY,finalMinX=minX;
                res.add(island.stream().map(pt->String.format("%d.%d", pt[0]-finalMinY, pt[1]-finalMinX)).sorted().collect(Collectors.joining(",")));
            }
        }

        return res.size();
    }
}