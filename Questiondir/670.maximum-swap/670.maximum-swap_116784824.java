class Solution {
    public int maximumSwap(int num) {
    		char[] s = String.valueOf(num).toCharArray();
    		
    		int ans = num;
    		for(int i = 0; i < s.length; i++) {
    			for(int j = i + 1; j < s.length; j++) {
    				// swap
    				swap(s, i, j);
    				ans = Integer.max(ans, Integer.valueOf(new String(s)));
    				swap(s, i, j);
    			}
    		}
    		return ans;
    }
    
    public void swap(char[] s, int i, int j) {
    		char tmp = s[i];
    		s[i] = s[j];
    		s[j] = tmp;
    }
}