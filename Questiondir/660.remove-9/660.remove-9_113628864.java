public class Solution {
    public int newInteger(int n) {
		int total = 0;
		while (n > 0) {
			int cur = n;
			int ret = 1;
			int pow = 0;
			while (cur >= 9) {
				ret *= 10;
				cur = cur/9;
				pow++;
			}
			total += ret * cur;
			n -= cur * (int)Math.pow(9, pow);
		}
        return total;
    }
}