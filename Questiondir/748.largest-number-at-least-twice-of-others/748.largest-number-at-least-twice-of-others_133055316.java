	class Solution {
	    public int dominantIndex(int[] a) {
	        int n = a.length;
	        outer:
	        for(int i = 0;i < n;i++){
	        	for(int j = 0;j < n;j++){
	        		if(j != i && a[j] * 2 > a[i]){
	        			continue outer;
	        		}
	        	}
	        	return i;
	        }
	        return -1;
	    }
	}	
