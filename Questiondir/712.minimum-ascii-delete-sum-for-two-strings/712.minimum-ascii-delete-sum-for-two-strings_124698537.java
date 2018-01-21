	class Solution {
	    public int minimumDeleteSum(String s1, String s2) {
	        char[] a = s1.toCharArray();
	        char[] b = s2.toCharArray();
			int n = a.length;
			int m = b.length;
			int[][] dp = new int[n+1][m+1];
			for(int i = 1;i <= n;i++){
				for(int j = 1;j <= m;j++){
					if(a[i-1] == b[j-1]){
						dp[i][j] = dp[i-1][j-1]+a[i-1];
					}else{
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			int ret = -dp[n][m]*2;
			for(char c : a){
				ret += c;
			}
			for(char c : b){
				ret += c;
			}
			return ret;
	    }
	}	
