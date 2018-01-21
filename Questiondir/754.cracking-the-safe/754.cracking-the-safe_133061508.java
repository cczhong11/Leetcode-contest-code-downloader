class Solution {
 public String crackSafe(int n, int k) {
     
    	Set<String> set = new HashSet<>();
    	StringBuilder builder = new StringBuilder();
    	// first number
    	for (int i = 0;i < n;i ++) {
    		builder.append("0");
    	}
    	set.add(builder.toString());
    	int total = 1;
    	for (int i = 0;i < n;i ++) {
    		total *= k;
    	}
    	for (int i = 0;i < total - 1;i ++) {
    		for (int j = k - 1;j >= 0;j --) {
    			StringBuilder temp = new StringBuilder();
    			for (int pos = builder.length() - (n - 1);pos < builder.length();pos ++) {
    				temp.append(builder.charAt(pos));
    			}
    			temp.append(j);
    			String string = temp.toString();
    			if (!set.contains(string)) {
    				set.add(string);
    				builder.append(j);
    				break;
    			}
    		}
    	}
    	return builder.toString();
    	
    }
}