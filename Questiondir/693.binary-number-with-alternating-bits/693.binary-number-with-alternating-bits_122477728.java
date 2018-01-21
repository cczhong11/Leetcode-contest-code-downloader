class Solution {
    public boolean hasAlternatingBits(int n) {
    	boolean a = true;
        int c = n % 2;
        n = n/2;
    	while (n>0) {
    		if (c==n%2)
                return false;
            c = n % 2;
    		n = n / 2;
    	}
    	return a;
    }

}