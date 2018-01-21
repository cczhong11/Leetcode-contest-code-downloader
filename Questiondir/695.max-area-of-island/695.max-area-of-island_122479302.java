class Solution {
    public static int maxAreaOfIsland(int[][] grid){
    	int ret = 0;
    	for(int i = 0; i < grid.length; i++){
    		for(int z = 0; z < grid[i].length; z++){
    			ret = Math.max(ret, util(grid, i, z));
    		}
    	}
    	return ret;
    }
    public static int util(int[][] grid, int x, int y){        
    	if(grid[x][y] == 0)return 0;
    	grid[x][y] = 0;
    	
    	int ret = 1;
    	if(x > 0)ret += util(grid, x-1, y);
    	if(x < grid.length - 1)ret += util(grid, x+1, y);
    	if(y > 0)ret += util(grid, x, y-1);
    	if(y < grid[0].length - 1)ret += util(grid, x, y+1);
    	
    	return ret;
    }
}