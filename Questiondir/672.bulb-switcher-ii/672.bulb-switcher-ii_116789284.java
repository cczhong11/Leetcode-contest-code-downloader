import java.util.HashSet;
import java.util.Set;

class Solution {
	String doIt(int n, int k1, int k2, int k3, int k4) {
		int[] res = new int[n];
		for (int i = 1; i <= n; ++i) {
			if (k1 == 1) res[i - 1] ^= 1;
			if (k2 == 1 && i % 2 == 0) {
				res[i - 1] ^= 1;
			}
			if (k3 == 1 && i % 2 == 1) {
				res[i - 1] ^= 1;
			}
			if (k4 == 1 && (i - 1) % 3 == 0) {
				res[i - 1] ^= 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append(res[i]);
		}
		return sb.toString();
	}
	
    public int flipLights(int n, int m) {
        Set<String> res = new HashSet<String>();
        for (int i = 0; i < 2; ++i) {
        	for (int j = 0; j < 2; ++j) {
        		for (int k = 0; k < 2; ++k) {
        			for (int t = 0; t < 2; ++t) {
        				int sum = i + j + k + t;
        				if (sum > m || (m - sum) % 2 != 0) {
        					continue;
        				}
        				String s = doIt(n, i, j, k, t);
        				res.add(s);
        			}
        		}
        	}
        }
        return res.size();
    }
}