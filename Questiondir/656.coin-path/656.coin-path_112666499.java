	public class Solution {
	    public List<Integer> cheapestJump(int[] A, int B) {
	    	int n = A.length;
	        int[] d = new int[n];
	        Arrays.fill(d, Integer.MAX_VALUE / 3);
	        d[0] = 0;
	        for(int i = 1;i < n;i++){
	        	if(A[i] != -1){
	        		int min = Integer.MAX_VALUE / 3;
	        		for(int j = Math.max(0, i-B);j < i;j++){
	        			int q = d[j] + A[j] ;
	        			if(q < min){
	        				min = q;
	        			}
	        		}
	        		d[i] = min;
	        	}
	        }
	        if(d[n-1] > Integer.MAX_VALUE / 4)return new ArrayList<>();
	        boolean[] marked = new boolean[n];
	        marked[n-1] = true;
	        for(int i = n-2;i >= 0;i--){
	        	for(int j = 1;j <= B && i+j < n;j++){
	        		if(marked[i+j] && d[i+j] == d[i] + A[i]){
	        			marked[i] = true;
	        			break;
	        		}
	        	}
	        }
	        List<Integer> route = new ArrayList<>();
	        int cur = 0;
	        while(cur < n-1){
		        route.add(cur+1);
		        for(int i = cur+1;i <= cur+B && i < n;i++){
		        	if(d[cur] + A[cur] == d[i] && marked[i]){
		        		cur = i;
		        		break;
		        	}
		        }
	        }
	        route.add(n);
	        return route;
	    }
	}	
