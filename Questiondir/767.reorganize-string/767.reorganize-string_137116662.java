	class Solution {
	    public String reorganizeString(String S) {
	    	char[] s = S.toCharArray();
	        int[] f = new int[128];
	        for(char c : s){
	        	f[c]++;
	        }
	        int n = s.length;
	        for(int i = 0;i < 128;i++){
	        	if(f[i] >= (n+3)/2){
	        		return "";
	        	}
	        }
	        int[][] fi = new int[128][];
	        for(int i = 0;i < 128;i++)fi[i] = new int[]{f[i], i};
	        Arrays.sort(fi, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return -(a[0] - b[0]);
				}
			});
	        char[] ret = new char[n];
	        int p = 0;
	        for(int[] u : fi){
	        	for(int i = 0;i < u[0];i++){
	        		ret[p] = (char)u[1];
	        		p += 2;
	        		if(p >= n)p = 1;
	        	}
	        }
	        return new String(ret);
	    }
	}	
