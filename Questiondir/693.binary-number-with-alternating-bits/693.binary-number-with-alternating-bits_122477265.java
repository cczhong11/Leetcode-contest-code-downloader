class Solution {
    public boolean hasAlternatingBits(int n) {
		int p = -1;
		int m = n;
		while (m > 0) {
			int c = m % 2;
			if (c == p) {
				return false;
			}
			p = c;
			m /= 2;
		}
		return true;
    }
}