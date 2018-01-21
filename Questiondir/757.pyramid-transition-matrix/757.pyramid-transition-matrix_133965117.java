	class Solution {
	    public boolean pyramidTransition(String bottom, List<String> allowed) {
	        int n = bottom.length();
	        int[][] to = new int[7][7];
	        for(String a : allowed){
	        	int x = a.charAt(0)-'A';
	        	int y = a.charAt(1)-'A';
	        	int z = a.charAt(2)-'A';
	        	to[x][y] |= 1<<z;
	        }
	        int[] dp = new int[n];
	        for(int i = 0;i < n;i++){
	        	dp[i] = 1<<bottom.charAt(i)-'A';
	        }
	        for(int i = n-1;i >= 1;i--){
	        	int[] ndp = new int[i];
	        	for(int j = 0;j < i;j++){
	        		int l = dp[j], r = dp[j+1];
	        		for(int k = 0;k < 7;k++){
	        			for(int u = 0;u < 7;u++){
	        				if(l<<~k<0 && r<<~u<0){
	        					ndp[j] |= to[k][u];
	        				}
	        			}
	        		}
	        	}
	        	dp = ndp;
	        }
	        return dp[0] != 0;
	    }
	}	
