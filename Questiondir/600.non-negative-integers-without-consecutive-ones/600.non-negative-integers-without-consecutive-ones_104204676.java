public class Solution {

	private int[][][] dp;
	
    public int findIntegers(int num) {
    	
    	dp = new int[31][2][2];
    	int i , j , k;
    	for (i = 0;i < 31;i ++) {
    		for (j = 0;j < 2;j ++) {
    			for (k = 0;k < 2;k ++) {
    				dp[i][j][k] = - 1;
    			}
    		}
    	}
    	return dfs(29 , 0 , 0 , num);
        
    }
    
    private int dfs(int current , int isLess , int prevIsOne , int num) {
    	
    	if (current == - 1) {
    		return 1;
    	} else {
    		if (dp[current][isLess][prevIsOne] >= 0) {
    			return dp[current][isLess][prevIsOne];
    		}
    		
    		int ans = 0;
    		boolean isOne = (num & (1 << current)) != 0 ? true : false;
    		// 如果已经更小了，随便取值
    		if (isLess > 0) {
    			if (prevIsOne == 0) {
    				ans += dfs(current - 1 , isLess , 0 , num);
    				ans += dfs(current - 1 , isLess , 1 , num);
    			} else {
    				ans += dfs(current - 1 , isLess , 0 , num);
    			}
    		} else {
    			// 相同的
    			if (prevIsOne == 0) {
    				if (isOne) {
    					ans += dfs(current - 1 , 0 , 1 , num);
    					ans += dfs(current - 1 , 1 , 0 , num);
    				} else {
    					ans += dfs(current - 1 , 0 , 0 , num);
    				}
    			} else {
    				if (isOne) {
    					ans += dfs(current - 1 , 1 , 0 , num);
    				} else {
    					ans += dfs(current - 1 , 0 , 0 , num); 
    				}
    			}
    		}
    		return dp[current][isLess][prevIsOne] = ans;
    	}
    	
    }

}