class Solution {
    public boolean hasAlternatingBits(int n) {
        int last = -1;
        while (n > 0) {
        	int cur = n % 2;
        	n /= 2;
        	if (last == -1) {
        		last = cur;
        	} else if (cur == last) {
        		return false;
        	} else {
        		last = cur;
        	}
        }
        return true;
    }
}