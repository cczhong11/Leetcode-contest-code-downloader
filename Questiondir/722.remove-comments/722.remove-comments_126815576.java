class Solution {
  public List<String> removeComments(String[] source) {
        
    	boolean flag1 = false;	/* */
    	boolean flag2 = false; 	//
    	List<String> ans = new ArrayList<>();
    	StringBuilder builder = new StringBuilder();
    	for (String line : source) {
    		int i , length = line.length();
    		for (i = 0;i < length;i ++) {
    			if (flag1) {
    				if (i + 1 < length && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
    					i ++;
    					flag1 = false;
    				}
    			} else if (flag2) {
    				continue;
    			} else {
    				if (i + 1 < length && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
    					flag1 = true;
    					i ++;
    				} else if (i + 1 < length && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
    					flag2 = true;
    					i ++;
    				} else {
    					builder.append(line.charAt(i));
    				}
    			}
    		}
    		flag2 = false;
    		if (!flag1 && builder.length() > 0) {
    			ans.add(builder.toString());
                builder.setLength(0);
    		}
    	}
    	if (builder.length() > 0) {
    		ans.add(builder.toString());
    	}
    	return ans;
    	
    }
}