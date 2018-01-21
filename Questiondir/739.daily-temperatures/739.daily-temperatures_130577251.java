import java.util.Arrays;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] index = new int[101];
        Arrays.fill(index, -1);
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; --i) {
        	int at = -1;
        	for (int j = temperatures[i] + 1; j <= 100; ++j) {
        		if (index[j] == -1) continue;
        		if (at == -1 || index[j] < at) {
        			at = index[j];
        		}
        	}
        	if (at >= 0) {
        		res[i] = at - i;
        	}
        	index[temperatures[i]] = i;
        }
        return res;
    }
}