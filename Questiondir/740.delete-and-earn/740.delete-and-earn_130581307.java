	class Solution {
	    public int deleteAndEarn(int[] a) {
	        int n = a.length;
	        Arrays.sort(a);
	        long[] dp = new long[n+1];
	        long ret = 0;
	        long[] maxs = new long[n+1];
	        for(int i = 0;i < n;i++){
	        	if(i > 0 && a[i] == a[i-1]){
	        		dp[i+1] = dp[i] + a[i];
	        	}else{
		        	int ub = upperBound(a, a[i]-2);
		        	dp[i+1] = maxs[ub+1] + a[i];
	        	}
	        	ret = Math.max(ret, dp[i+1]);
	        	maxs[i+1] = Math.max(maxs[i], dp[i+1]);
	        }
	        return (int)ret;
	    }
	    
		public int upperBound(int[] a, int v){ return upperBound(a, 0, a.length, v); }
		public int upperBound(int[] a, int l, int r, int v)
		{
			int low = l-1, high = r;
			while(high-low > 1){
				int h = high+low>>>1;
				if(a[h] <= v){
					low = h;
				}else{
					high = h;
				}
			}
			return low;
		}

	}	
