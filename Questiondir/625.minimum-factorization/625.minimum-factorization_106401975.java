public class Solution {

     public int smallestFactorization(int a) {
    	
    	if (a == 1) {
    		return a;
    	}
    
    	// 2 3 5 7 
    	Map<Integer , Integer> map = new TreeMap<>();
    	for (int i = 9;i > 1;i --) {
    		int cnt = 0;
    		while (a % i == 0) {
    			a /= i;
    			cnt ++;
    		}
    		if (cnt > 0) {
    			map.put(i , cnt);
    		}
    	}
    	if (a > 1) {
    		return 0;
    	} else {
    		StringBuilder builder = new StringBuilder();
    		for (Map.Entry<Integer , Integer> entry : map.entrySet()) {
    			for (int i = 0;i < entry.getValue();i ++) {
    				builder.append(entry.getKey());
    			}
    		}
    		if (builder.length() > 12) {
    			return 0;
    		} else {
    			long value = Long.parseLong(builder.toString());
    			if (value <= Integer.MAX_VALUE) {
    				return (int) value;
    			} else {
    				return 0;
    			}
    		}
    	}
    	
    }

}