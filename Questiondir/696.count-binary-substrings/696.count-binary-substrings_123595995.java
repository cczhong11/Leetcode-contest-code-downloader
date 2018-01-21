	class Solution {
	    public int countBinarySubstrings(String s) {
	        char[] t = s.toCharArray();
	        int n = t.length;
	        
	        int[] cum = new int[n+1];
	        int ret = 0;
	        for(int i = 0;i < n;i++){
	        	cum[i+1] = cum[i] + t[i] - '0';
	        }
	        for(int i = 1;i < n;i++){
	        	// i-1,i
	        	int low = 0, high = Math.min(n-i, i) + 1;
	        	while(high - low > 1){
	        		int h = high+low>>1;
	        		int l = cum[i] - cum[i-h];
	        		int r = cum[i+h] - cum[i];
	        		if(l == 0 && r == h || l == h && r == 0){
	        			low = h;
	        		}else{
	        			high = h;
	        		}
	        	}
        		ret += low;
	        }
	        return ret;
	    }
	}	
