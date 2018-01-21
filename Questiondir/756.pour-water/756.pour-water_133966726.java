	class Solution {
	    public int[] pourWater(int[] a, int V, int K) {
	        for(int i = 0;i < V;i++){
	        	int cur = K;
	        	inner:
	        	while(true){
		        	for(int j = cur-1;j >= 0;j--){
		        		if(a[j] < a[cur]){
		        			cur = j;
		        			continue inner;
		        		}
		        		if(a[j] > a[cur])break;
		        	}
		        	for(int j = cur+1;j < a.length;j++){
		        		if(a[j] < a[cur]){
		        			cur = j;
		        			continue inner;
		        		}
		        		if(a[j] > a[cur])break;
		        	}
		        	a[cur]++;
		        	break;
	        	}
	        }
	    	return a;
	    }
	}	
