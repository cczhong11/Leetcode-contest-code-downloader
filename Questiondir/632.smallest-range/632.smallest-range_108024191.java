	public class Solution {
	    public int[] smallestRange(int[][] nums) {
	        int m = 0;
	        for(int[] row : nums)m += row.length;
	    	
	    	int n = nums.length;
        	int[][] es = new int[m][];
        	int p = 0;
        	for(int i = 0;i < n;i++){
        		for(int e : nums[i]){
        			es[p++] = new int[]{e, i};
        		}
        	}
        	Arrays.sort(es, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return a[0] - b[0];
				}
			});
        	
        	int tail = 0;
        	int[] f = new int[n];
        	int nin = 0;
        	int min = Integer.MAX_VALUE / 2;
        	int arg = -1;
        	for(int[] e : es){
        		if(++f[e[1]] == 1)nin++;
        		boolean full = nin == n;
        		while(tail < m && nin == n){
        			if(--f[es[tail++][1]] == 0)nin--;
        		}
        		if(full){
        			int len = e[0] - es[tail-1][0]+1;
        			if(len < min){
        				min = len;
        				arg = e[0];
        			}
        		}
        	}
	        return new int[]{arg-min+1, arg};
	    }
	}	
