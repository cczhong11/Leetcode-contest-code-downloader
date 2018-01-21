	class Solution {
	    public int findKthNumber(int m, int n, int k) {
	    	k--;
	        int low = 0, high = 1000000000;
	        while(high - low > 1){
	        	int h = high+low>>1;
	        	int num = 0;
	        	for(int i = 1;i <= m;i++){
	        		num += Math.min(h/i, n);
	        	}
	        	if(num <= k){
	        		low = h;
	        	}else{
	        		high = h;
	        	}
	        }
	        return high;
	    }
	}	
