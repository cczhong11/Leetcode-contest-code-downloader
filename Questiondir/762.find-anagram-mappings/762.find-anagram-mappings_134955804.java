	class Solution {
	    public int[] anagramMappings(int[] A, int[] B) {
	    	int n = A.length;
	    	boolean[] ved = new boolean[n];
	    	int[] f = new int[n];
	        for(int i = 0;i < n;i++){
	        	for(int j = 0;j < n;j++){
	        		if(B[j] == A[i] && !ved[j]){
	        			ved[j] = true;
	        			f[i] = j;
	        			break;
	        		}
	        	}
	        }
	        return f;
	    }
	}	
