	class Solution {
	    public boolean checkValidString(String s) {
	        char[] q = s.toCharArray();
	        int[] dp = new int[300];
	        dp[0] = 1;
	        for(char c : q){
	        	int[] ndp = new int[300];
	        	if(c == '('){
		        	for(int i = 0;i < 299;i++){
		        		ndp[i+1] = dp[i];
		        	}
	        	}else if(c == ')'){
		        	for(int i = 1;i < 300;i++){
		        		ndp[i-1] = dp[i];
		        	}
	        	}else{
	        		for(int i = 0;i < 300;i++){
	        			if(i+1 < 300)ndp[i+1] |= dp[i];
	        			ndp[i] |= dp[i];
	        			if(i-1 >= 0)ndp[i-1] |= dp[i];
	        		}
	        	}
	        	dp = ndp;
	        }
	        return dp[0] == 1;
	    }
	}	
