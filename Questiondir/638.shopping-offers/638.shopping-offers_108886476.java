	public class Solution {
		
		void dfs(int[] row, long[] dp, int plus, int plusval, int pos, int id)
		{
			if(pos == row.length){
				dp[id+plus] = Math.min(dp[id+plus], dp[id] + plusval);
			}else{
				for(int i = 0;i <= 6-row[pos];i++){
					dfs(row, dp, plus, plusval, pos+1, id*7+i);
				}
			}
		}
		
	    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	    	int n = price.size();
	    	
	        int num = 1;
	        for(int i = 0;i < n;i++)num *= 7;
	        long[] dp = new long[num];
	        Arrays.fill(dp, Long.MAX_VALUE / 10);
	        dp[0] = 0;
	        for(List<Integer> spe : special){
	        	int plus = 0;
        		int[] row = new int[n];
        		for(int i = 0;i < n;i++){
        			plus = plus * 7 + spe.get(i);
        			row[i] = spe.get(i);
        		}
        		
        		dfs(row, dp, plus, spe.get(n), 0, 0);
	        }
	        
        	int[] a = new int[n];
        	int id = 0;
        	long ret = Long.MAX_VALUE;
        	inner:
        	do{
        		long res = dp[id];
        		for(int i = 0;i < n;i++){
        			res += (long)(needs.get(i) - a[i]) * price.get(i);
        			if(a[i] > needs.get(i)){
        				id++;
        				continue inner;
        			}
        		}
        		ret = Math.min(ret, res);
        		id++;
        	}while(inc(a, 7));
        	return (int)ret;
	    }
	    
	    public boolean inc(int[] a, int base)
			{
				int n = a.length;
				int i;
				for(i = n - 1;i >= 0 && a[i] == base - 1;i--);
				if(i == -1)return false;
				
				a[i]++;
				Arrays.fill(a, i + 1, n, 0);
				return true;
			}
			
	    
		public long encInc(int[] a, int base)
		{
			long code = 0;
			for(int v : a)code = code * base + v;
			return code;
		}
	}	
