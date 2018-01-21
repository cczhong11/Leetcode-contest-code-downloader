public class Solution {
    	public int findIntegers(int num) {
		List<Integer> list = new ArrayList<>();
		while (num > 0) {
        	list.add(num & 1);
        	num /= 2;
        }
        
		int[] dp = new int[32];
		dp[0] = 1;
		dp[1] = 2;;
		for (int i = 2; i <= 31; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		boolean ok = true;
        int ans = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
        	if (list.get(i) == 1) {
        		//System.out.println("i = " + i + " " + ans);
        		if (i + 1 < list.size() && list.get(i + 1) == 1) {
        			ans += dp[i];
        			ok = false;
        			break;
        		} else {
        			ans += dp[i];
        		}
        	}
        }
        if (ok) ans++;
        return ans;
    }
}