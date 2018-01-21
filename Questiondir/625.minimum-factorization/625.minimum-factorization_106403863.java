public class Solution {
	public int smallestFactorization(int a) {
		if (a == 1) {
	        return 1;
	    }
		int [] fac = new int[10];
		for (int i = 9; i >= 2; ) {
			if (a % i == 0) {
				a = a / i;
				fac[i]++;
			} else {
				i--;
			}
		}
		if (a != 1) {
			return 0;
		}
		String num = "";
		for (int i = 2; i <= 9; i++) {
			for (int j = 0; j < fac[i]; j++) {
				num += String.valueOf(i);
			}
		}
		int ret = 0;
		try {
			ret = Integer.valueOf(num);
		} catch (Exception e) {
			return 0;
		}
		return ret;
    }
}