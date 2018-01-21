	class Solution {
	    public int smallestDistancePair(int[] a, int k) {
	        int n = a.length;
	        Arrays.sort(a);
	        k--;
	        int low = -1, high = 100000000;
	        while(high - low > 1){
	        	int h = high+low>>1;
	        	int ct = 0;
	        	int p = 0;
	        	for(int i = 0;i < n;i++){
	        		while(p < i && a[i] - a[p] > h){
	        			p++;
	        		}
	        		ct += i-p;
	        	}
	        	if(k < ct){
	        		high = h;
	        	}else{
	        		low = h;
	        	}
	        }
	        return high;
	    }
	}	
