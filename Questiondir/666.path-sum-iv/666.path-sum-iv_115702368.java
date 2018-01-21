	class Solution {
	    public int pathSum(int[] nums) {
	    	int[][] div = new int[nums.length][];
	    	int p = 0;
	    	for(int v : nums){
	    		int d = v/100;
	    		int ind = v/10%10;
	    		int val = v%10;
	    		div[p++] = new int[]{d, ind-1, val};
	    	}
	    	int all = 0;
	    	outer:
	    	for(int[] u : div){
	    		int d = u[0], ind = u[1], val = u[2];
	    		for(int[] v : div){
	    			if(v[0] == d+1 && 
	    					(v[1] == ind*2 || v[1] == ind*2+1)){
	    				continue outer;
	    			}
	    		}
	    		while(d > 0){
		    		for(int[] v : div){
		    			if(v[0] == d && v[1] == ind){
		    				all += v[2];
		    				break;
		    			}
		    		}
		    		d--; ind>>= 1;
	    		}
	    	}
	    	return all;
	    }
	}	
