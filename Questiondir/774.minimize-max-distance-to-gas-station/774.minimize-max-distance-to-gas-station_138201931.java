	class Solution {
	    public double minmaxGasDist(int[] xs, int K) {
	        int n = xs.length;
	        Arrays.sort(xs);
	        double low = 0, high = 100000009;
	        for(int rep = 0;rep < 80;rep++){
	        	double h = (high+low)/2;
	        	int need = 0;
	        	for(int i = 0;i < n-1;i++){
	        		need += (int)((xs[i+1] - xs[i])/h);
	        	}
	        	if(need > K){
	        		low = h;
	        	}else{
	        		high = h;
	        	}
	        }
	        return high;
	    }
	}	
