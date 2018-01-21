	class Solution {
	    public int maxChunksToSorted(int[] a) {
	    	int n = a.length;
	        int reach = 0;
	        int par = 0;
	        outer:
	        for(int i = 0;i < n;i++){
	        	for(int j = reach;j <= i;j++){
	        		if(a[j] > i)continue outer;
	        	}
	        	reach = i;
	        	par++;
	        }
	        return par;
	    }
	}	
