	class Solution {
	    public int monotoneIncreasingDigits(int N) {
	    	if(N == 0)return 0;
	        char[] s = Integer.toString(N).toCharArray();
	        int n = s.length;
	        
	        boolean ok = true;
        	for(int j = 0;j < n-1;j++){
        		if(s[j] <= s[j+1]){
        		}else{
        			ok = false;
        		}
        	}
        	if(ok)return N;
        	
	        int[] dp = new int[10];
	        Arrays.fill(dp, -1);
	        int edge = 0;
	        for(int i = 0;i < n;i++){
	        	int[] ndp = new int[10];
	        	for(int j = 0;j < 10;j++){
	        		for(int k = j;k <= 9;k++){
	        			if(dp[j] != -1){
	        				ndp[k] = Math.max(ndp[k], dp[j] * 10 + k);
	        			}
	        		}
	        	}
	        	
	        	if(i == 0){
	        		for(int j = 1;j < s[i]-'0';j++){
	        			ndp[j] = Math.max(ndp[j], j);
	        		}
	        	}else{
	        		for(int j = 1;j <= 9;j++){
	        			ndp[j] = Math.max(ndp[j], j);
	        		}
	        		if(edge != -1){
		        		for(int j = edge%10;j < s[i]-'0';j++){
		        			ndp[j] = Math.max(ndp[j], edge*10+j);
		        		}
	        		}
	        	}
	        	if(edge == -1 || edge % 10 > s[i] - '0'){
	        		edge = -1;
	        	}else{
	        		edge = edge * 10 + s[i]-'0';
	        	}
	        	dp = ndp;
	        }
	        
	        int ret = 0;
	        for(int i = 0;i < 10;i++){
	        	ret = Math.max(ret, dp[i]);
	        }
	        return ret;
	    }
	}	