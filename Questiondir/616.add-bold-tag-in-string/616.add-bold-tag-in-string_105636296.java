public class Solution {

	private int[] cnt = new int[100010];
	private int[] nexts = new int[10000];
	
	private void build(String dict) {
		
		int i , length = dict.length();
		nexts[0] = - 1;
		nexts[1] = 0;
		for (i = 2;i < length;i ++) {
			int pos = nexts[i - 1];
			while (pos >= 0 && (dict.charAt(i) != dict.charAt(pos + 1))) {
				pos = nexts[pos];
			}
			nexts[i] = pos + 1;
		}
		
	}
	
	private void solve(String s , String dict) {
		
		s = " " + s;
		dict = " " + dict;
		build(dict);
		
		int i = 1 , length1 = s.length() , j = 1 , length2 = dict.length();
		while (i < length1 && j < length2) {
			if (s.charAt(i) == dict.charAt(j)) {
				i ++;
				j ++;
				if (j == length2) {
					int start = i - (length2 - 1) - 1;
					int end = start + (length2 - 2);
					cnt[start] ++;
					cnt[end + 1] --;
					j = nexts[j - 1] + 1;
				}
			} else {
				if (j > 1) {
					j = nexts[j - 1] + 1;
				} else {
					i ++;
					j = 1;
				}
			}
		}
		
	}
	
    public String addBoldTag(String s, String[] dict) {
     
    	Arrays.fill(cnt , 0);
    	
    	for (String string : dict) {
    		solve(s , string);
    	}
    	
    	StringBuilder builder = new StringBuilder();
    	int i , length = s.length() , value = 0;
    	for (i = 0;i < length;i ++) {
    		value += cnt[i];
    		if (value > 0) {
    			builder.append("<b>");
    			builder.append(s.charAt(i));
    			i ++;
    			while (i < length && (value + cnt[i]) > 0) {
    				builder.append(s.charAt(i));
    				value += cnt[i];
    				i ++;
    			}
    			builder.append("</b>");
    			if (i < length) {
    				builder.append(s.charAt(i));
    			}
    			value += cnt[i];
    		} else {
    			builder.append(s.charAt(i));
    		}
    	}
    	return builder.toString();
    	
    }

}