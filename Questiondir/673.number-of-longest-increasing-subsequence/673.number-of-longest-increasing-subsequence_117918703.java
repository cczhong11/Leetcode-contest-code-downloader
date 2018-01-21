	class Solution {
	    public int findNumberOfLIS(int[] nums) {
	        return (int)countLIS(nums);
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

	    
		public long countLIS(int[] a)
		{
			if(a.length == 0)return 0;
			a = shrink(a);
			int n = a.length;
			SegmentTreeRMQSumWhenMax st = new SegmentTreeRMQSumWhenMax(n+1);
			st.updateOrAdd(0, 0, 1); // shifted by 1
			for(int i = 0;i < n;i++){
				int max = st.maxx(0, a[i]+1); // <=a[i]
				st.updateOrAdd(a[i]+1, max+1, (int)st.gw);
			}
			return st.w[1];
		}
		
		private class SegmentTreeRMQSumWhenMax {
			public int M, H, N;
			public int[] st;
			public int[] w;
			
			public SegmentTreeRMQSumWhenMax(int n)
			{
				N = n;
				M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
				H = M>>>1;
				st = new int[M];
				w = new int[M];
				Arrays.fill(st, 0, M, Integer.MIN_VALUE);
			}
			
			// if x equals to before st[H+pos], +y, else update y
			public void updateOrAdd(int pos, int x, int y)
			{
				if(x < st[H+pos])throw new RuntimeException("x < st[H+pos]");
				if(x == st[H+pos]){
					w[H+pos] += y;
				}else{
					st[H+pos] = x;
					w[H+pos] = y; // y % mod
				}
				for(int i = (H+pos)>>>1;i >= 1;i >>>= 1)propagate(i);
			}
			
			private void propagate(int i)
			{
				if(st[2*i] < st[2*i+1]){
					st[i] = st[2*i+1];
					w[i] = w[2*i+1];
				}else if(st[2*i] > st[2*i+1]){
					st[i] = st[2*i];
					w[i] = w[2*i];
				}else{
					st[i] = st[2*i];
					w[i] = w[2*i] + w[2*i+1];
				}
			}
			
			public long gw;
			
			public int maxx(int l, int r){
				gw = 0;
				if(l >= r)return 0;
				int max = Integer.MIN_VALUE;
				while(l != 0){
					int f = l&-l;
					if(l+f > r)break;
					int v = st[(H+l)/f];
					if(v > max){
						max = v;
						gw = w[(H+l)/f];
					}else if(v == max){
						gw += w[(H+l)/f];
					}
					l += f;
				}
				
				while(l < r){
					int f = r&-r;
					int v = st[(H+r)/f-1];
					if(v > max){
						max = v;
						gw = w[(H+r)/f-1];
					}else if(v == max){
						gw += w[(H+r)/f-1];
					}
					r -= f;
				}
				return max;
			}
		}
	}
