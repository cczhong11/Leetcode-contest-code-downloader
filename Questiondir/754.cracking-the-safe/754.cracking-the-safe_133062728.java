	class Solution {
    	int n, k;
    	int[] a;
    	StringBuilder sb = new StringBuilder();
		
		void db(int t, int p)
		{
	        if(t > n){
	        	if(n % p == 0){
	        		for(int i = 1;i <= p;i++){
	        			sb.append(a[i]);
	        		}
	        	}
	        }else{
        		a[t] = a[t-p];
        		db(t+1, p);
        		for(int j = a[t-p] + 1;j < k;j++){
        			a[t] = j;
            		db(t+1, t);
        		}
        	}
		}
		
	    public String crackSafe(int n, int k) {
	    	a = new int[n*k];
	    	this.n = n; this.k = k;
	    	if(k == 1){
	    		sb.append("0");
	    	}else{
	    		db(1, 1);
	    	}
	    	for(int i = 0;i < n-1;i++){
	    		sb.append(0);
	    	}

	    	return sb.toString();
	    }
	}
