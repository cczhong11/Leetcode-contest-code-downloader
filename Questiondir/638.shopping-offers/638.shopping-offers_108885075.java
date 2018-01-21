public class Solution {

	private static class Element {
		private int[] need;
		public Element(int[] array) {
			this.need = array;
		}
		public int hashCode() {
			int ans = 31;
			for (int value : need) {
				ans = ans * 37 + value;
			}
			return ans;
		}
		public boolean equals(Object object) {
			Element e = (Element) object;
			int i , n = this.need.length;
			for (i = 0;i < n;i ++) {
				if (this.need[i] != e.need[i]) {
					return false;
				}
			}
			return true;
		}
	}
	
	private int[] dp = new int[120010];
	
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    
    	for (int i = 0;i < 120000;i ++) {
    		dp[i] = - 1;
    	}
    	
    	int[] array = new int[needs.size()];
    	for (int i = 0;i < array.length;i ++) {
    		array[i] = needs.get(i);
    	}
    	Element e = new Element(array);
    	return dfs(price , special , e);
    	
    }
    
    private boolean isEnd(Element e) {
    	
    	for (int value : e.need) {
    		if (value > 0) {
    			return false;
    		}
    	}
    	return true;
    	
    }
    
    private boolean canUse(List<Integer> list , Element e) {
    	
    	int i , n = list.size() - 1;
    	for (i = 0;i < n;i ++) {
    		if (list.get(i) > e.need[i]) {
    			return false;
    		}
    	}
    	return true;
    	
    }
    
    private Element use(List<Integer> list , Element e) {
    	int[] need = new int[list.size() - 1];
    	Element newE = new Element(need);
    	int i , n = list.size() - 1;
    	for (i = 0;i < n;i ++) {
    		newE.need[i] = e.need[i] - list.get(i);
    	}
    	return newE;
    	
    }
    
    private int dfs(List<Integer> price , List<List<Integer>> special , Element e) {
    	
    	if (isEnd(e)) {
    		return 0;
    	} else {
    		
    		int dpValue = 0;
    		for (int value : e.need) {
    			dpValue = dpValue * 7 + value;
    		}
    		if (dp[dpValue] >= 0) {
    			return dp[dpValue];
    		}
    		
    		int ans = - 1;
    		for (List<Integer> list : special) {
    			if (canUse(list , e)) {
    				Element newE = use(list , e);
    				int temp = dfs(price , special , newE) + list.get(list.size() - 1);
    				if (temp < ans || ans < 0) {
    					ans = temp;
    				}
    			}
    		}
    		for (int i = 0;i < e.need.length;i ++) {
    			if (e.need[i] > 0) {
    				int[] array = new int[e.need.length];
	    			Element tempE = new Element(array);
	    			for (int j = 0;j < e.need.length;j ++) {
	    				tempE.need[j] = e.need[j];
	    			}
	    			tempE.need[i] --;
	    			int result = dfs(price , special , tempE) + price.get(i);
	    			if (result < ans || ans < 0) {
	    				ans = result;
	    			}
    			}
    		}
    		
    		dp[dpValue] = ans;
    		
    		return ans;
    	}
    	
    }
	
	

}