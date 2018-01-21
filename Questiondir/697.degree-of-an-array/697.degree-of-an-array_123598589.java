	class Solution {
	    public int findShortestSubArray(int[] nums) {
	        int n = nums.length;
	        for(int i = 0;i < n;i++)nums[i] += 1000000000;
	        nums = shrink(nums);
	        
	        int[] f = new int[50000];
	        for(int v : nums)f[v]++;
	        int maxf = 0;
	        for(int v : f)maxf = Math.max(maxf, v);
	        Arrays.fill(f, 0);
	        int p = 0;
	        int ret = 999999999;
	        for(int i = 0;i < n;i++){
	        	if(++f[nums[i]] < maxf)continue;
	        	while(p < i){
	        		f[nums[p]]--;
	        		if(nums[i] == nums[p])break;
	        		p++;
	        	}
	        	ret = Math.min(ret, i-p+1);
	        }
	        return ret;
	    }
	    
	    public int[] shrink(int[] a) {
			int n = a.length;
			long[] b = new long[n];
			for (int i = 0; i < n; i++)
				b[i] = (long) a[i] << 32 | i;
			Arrays.sort(b);
			int[] ret = new int[n];
			int p = 0;
			for (int i = 0; i < n; i++) {
				if (i > 0 && (b[i] ^ b[i - 1]) >> 32 != 0)
					p++;
				ret[(int) b[i]] = p;
			}
			return ret;
		}

	}	
