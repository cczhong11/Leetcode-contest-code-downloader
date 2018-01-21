	class Solution {
	    public int[] dailyTemperatures(int[] t) {
	        int n = t.length;
	        int[] e = enumNextWall(t);
	        for(int i = 0;i < n;i++){
	        	e[i] = e[i] == n ? 0 : e[i] - i;
	        }
	        return e;
	    }
	    
		public int[] enumNextWall(int[] a)
		{
			int n = a.length;
			int[] L = new int[n];
			for(int i = n-1;i >= 0;i--){
				L[i] = i+1;
				while(L[i] < n && a[L[i]] <= a[i])L[i] = L[L[i]];
			}
			return L;
		}

	}	
