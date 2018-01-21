	class Solution {
	    public int maxChunksToSorted(int[] a) {
	    	int n = a.length;
	        int reach = 0;
	        int par = 0;
	        long[] aa = new long[n];
	        for(int i = 0;i < n;i++)aa[i] = (long)a[i]<<32|i;
	        long[] bb = Arrays.copyOf(aa, n);
	        Arrays.sort(bb);
	        int[] to = new int[n];
	        for(int i = 0;i < n;i++){
	        	to[i] = Arrays.binarySearch(bb, aa[i]);
	        }
	        outer:
	        for(int i = 0;i < n;i++){
	        	for(int j = reach;j <= i;j++){
	        		if(to[j] > i)continue outer;
	        	}
	        	reach = i;
	        	par++;
	        }
	        return par;
	    }
	}	
