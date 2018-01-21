class Solution {
private static List<Integer>[] lists = new ArrayList[26];
	
	static {
		for (int i = 0;i < 26;i ++) {
			lists[i] = new ArrayList<>();
		}
	}
	
	private int lowerBound(int index , int pos) {
		
		int low = 0 , high = lists[index].size();
		while (low < high) {
			int mid = (low + high) / 2;
			if (lists[index].get(mid) < pos) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		if (low < lists[index].size()) {
			return lists[index].get(low);
		} else {
			return - 1;
		}
		
	}
	
	// start index in s
	private int check(String t , int startIndex) {
		
		int current = startIndex;
		int i = 1;
		while (i < t.length()) {
			int index = t.charAt(i) - 'a';
			int pos = lowerBound(index , current + 1);
			if (pos >= 0) {
				current = pos;
			} else {
				return - 1;
			}
			i ++;
		}
		return current - startIndex + 1;
		
	}
	
    public String minWindow(String S, String T) {
     
    	int i , length1 = S.length() , ans = - 1 , start = - 1;
    	for (i = 0;i < 26;i ++) {
    		lists[i].clear();
    	}
    	for (i = 0;i < length1;i ++) {
    		int index = S.charAt(i) - 'a';
    		lists[index].add(i);
    	}
    	
    	for (i = 0;i < length1;i ++) {
    		if (S.charAt(i) == T.charAt(0)) {
    			int temp = check(T , i);
    			if (temp >= 0) {
	    			if (temp < ans || ans < 0) {    				
	    				ans = temp;
	    				start = i;
	    			}
    			}
    		}
    	}
    		
    	if (ans < 0) {
    		return "";
    	} else {
    		String string = S.substring(start , start + ans);
    		return string;
    	}
    	
    }
}