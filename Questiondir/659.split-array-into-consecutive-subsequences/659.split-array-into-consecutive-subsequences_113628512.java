	public class Solution {
	    public boolean isPossible(int[] nums) {
	    	TreeMap<Integer, Integer> f = new TreeMap<>();
	        for(int v : nums){
	        	if(f.containsKey(v)){
	        		f.put(v, f.get(v)+1);
	        	}else{
	        		f.put(v, 1);
	        	}
	        }
	        int n = nums.length;
	        int[] opens = new int[n+3];
	        int[] closes = new int[n+3];
	        int op = 0, cp = 0;
	        for(Map.Entry<Integer, Integer> e : f.entrySet()){
	        	{
		        	int over = e.getValue() - (f.containsKey(e.getKey()-1) ? f.get(e.getKey()-1) : 0);
		        	for(int j = 0;j < over;j++)opens[op++] = e.getKey();
	        	}
	        	{
		        	int over = e.getValue() - (f.containsKey(e.getKey()+1) ? f.get(e.getKey()+1) : 0);
		        	for(int j = 0;j < over;j++)closes[cp++] = e.getKey();
	        	}
	        }
//	        tr(f);
//	        tr(opens);
//	        tr(closes);
	        assert op == cp;
	        for(int i = 0;i < op;i++){
	        	if(closes[i] - opens[i] < 2)return false;
	        }
	        return true;
	    }
	}	
