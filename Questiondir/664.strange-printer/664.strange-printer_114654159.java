	class Solution {
	    public int strangePrinter(String S) {
	        char[] s = S.toCharArray();
	        int n = s.length;
	        if(n == 0)return 0;
	        int[][][] dp = new int[n][n][26];
	        for(int i = 0;i < n;i++){
	        	for(int j = 0;j < n;j++){
	        		Arrays.fill(dp[i][j], 99999999);
	        	}
	        }
	        for(int len = 1;len <= n;len++){
	        	for(int i = 0;i+len-1 < n;i++){
	        		int j = i+len-1;
	        		if(len == 1){
	        			dp[i][j][s[i]-'a'] = 1;
	        		}else{
	        			for(int k = i+1;k <= j;k++){
	        				int rmin = 99999999;
	        				for(int w = 0;w < 26;w++){
	        					rmin = Math.min(rmin, dp[k][j][w]);
    	        			}
		        			for(int u = 0;u < 26;u++){
    	        				dp[i][j][u] = Math.min(dp[i][j][u], dp[i][k-1][u] + Math.min(rmin, dp[k][j][u] - 1));
		        			}
	        			}
	        		}
	        	}
	        }
	        int min = 99999999;
	        for(int i = 0;i < 26;i++){
	        	min = Math.min(min, dp[0][n-1][i]);
	        }
	        return min;
	    }
	}	
