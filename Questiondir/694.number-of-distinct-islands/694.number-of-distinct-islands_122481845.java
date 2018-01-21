class Solution {
   public static int numDistinctIslands(int[][] grid){
    	HashSet<String> all = new HashSet<>();
    	for(int i = 0; i < grid.length; i++){
    		for(int z = 0; z < grid[i].length; z++){
    			String s = util(grid, i, z);
    			if(!s.equals(""))all.add(s);
    		}
    	}
    	return all.size();
    }
    public static String util(int[][] grid, int x, int y){        
    	if(grid[x][y] == 0)return "";
    	grid[x][y] = 0;
    	
    	String ret = "K";
    	if(x > 0){
    		String s = util(grid, x-1, y);
    		if(s.length() > 0)ret += s + "L";
    	}
    	if(x < grid.length - 1){
    		String s = util(grid, x+1, y);
    		if(s.length() > 0)ret += s + "R";
    	}
    	if(y > 0){
    		String s = util(grid, x, y-1);
    		if(s.length() > 0)ret += s + "U";
    	}
    	if(y < grid[0].length - 1){
    		String s = util(grid, x, y+1);
    		if(s.length() > 0)ret += s + "D";
    	}
    	
    	return ret;
    }
}