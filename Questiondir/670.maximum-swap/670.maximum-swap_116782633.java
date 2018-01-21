	class Solution {
	    public int maximumSwap(int num) {
	        char[] s = Integer.toString(num).toCharArray();
	        int n = s.length;
	        int max = -1;
	        for(int i = 0;i < n;i++){
	        	for(int j = i;j < n;j++){
	        		{char d = s[i]; s[i] = s[j]; s[j] = d;}
	        		max = Math.max(max, Integer.parseInt(new String(s)));
	        		{char d = s[i]; s[i] = s[j]; s[j] = d;}
	        	}
	        }
	        return max;
	    }
	}	
