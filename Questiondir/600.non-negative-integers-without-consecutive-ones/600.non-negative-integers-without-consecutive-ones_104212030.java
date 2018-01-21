public class Solution {
    int[] a;
	int[] b;
	public int findIntegers(int num) {
		if (num == 1) return 2;
        int maxLen = (int)(Math.log((double)num) / Math.log(2.0)) + 1;
        int n = maxLen - 1;
        a = new int[n];
		b = new int[n];
		a[0] = b[0] = 1;
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
        return countNum(num);
    }
	
	public int countNum(int num) {
		if (num == 0) return 1;
		if (num == 1) return 2;
		int maxLen = (int)(Math.log((double)num) / Math.log(2.0)) + 1;
        int n = maxLen - 1;
        int res = a[n - 1] + b[n - 1];
        int diff = num - (int)Math.pow(2, maxLen - 1);
        int nextDigitCount = maxLen - 1;
    	int maxNextNum = (int)Math.pow(2, nextDigitCount - 1);
        int nextNum = Math.min(maxNextNum - 1, diff);
        res = res + countNum(nextNum);
        return res;
	}
}