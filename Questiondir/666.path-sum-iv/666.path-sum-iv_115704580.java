class Solution {
	
	private int[][] values;
	private int ans = 0;
	
    public int pathSum(int[] nums) {
     
    	if (nums.length == 0) {
    		return 0;
    	}
    	
    	values = new int[10][100];
    	for (int i = 0;i < 10;i ++) {
    		for (int j = 0;j < 100;j ++) {
    			values[i][j] = - 1;
    		}
    	}
    	for (int value : nums) {
    		int deep = value / 100;
    		int position = (value / 10) % 10;
    		int v = (value % 10);
    		values[deep][position] = v;
    	}
    	
    	ans = 0;
    	dfs(1 , 1 , 0);
    	return ans;
    	
    }
    
    private void dfs(int deep , int position , int sum) {
    	
    	sum += values[deep][position];
    	if (values[deep + 1][position * 2 - 1] < 0 && values[deep + 1][position * 2] < 0) {
    		ans += sum;
    	} else {
    		if (values[deep + 1][position * 2 - 1] >= 0) {
    			dfs(deep + 1 , position * 2 - 1 , sum);
    		}
    		if (values[deep + 1][position * 2] >= 0) {
    			dfs(deep + 1 , position * 2 , sum);
    		}
    	}
    	
    }
}