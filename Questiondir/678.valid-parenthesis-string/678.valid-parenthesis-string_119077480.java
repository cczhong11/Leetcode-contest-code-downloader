import java.util.Arrays;

class Solution {
	int n;
	int dp[][];
	String s;
	
	int solve(int l, int r) {
		if (l > r) return 1;
		if (l == r) return s.charAt(l) == '*' ? 1 : 0;
		if (dp[l][r] >= 0) return dp[l][r];
		int res = 0;
		for (int i = l; i < r; ++i) {
			if (solve(l, i) > 0 && solve(i + 1, r) > 0) {
				res = 1;
				break;
			}
		}
		if (res == 0) {
			char cl = s.charAt(l);
			char cr = s.charAt(r);
			if ((cl == '(' || cl == '*') && (cr == ')' || cr == '*')) {
				res = solve(l + 1, r - 1);
			}
		}
		dp[l][r] = res;
		return res;
	}
	
    public boolean checkValidString(String s) {
    	this.s = s;
    	n = s.length();
        dp = new int[n][n];
        for (int[] d : dp) {
        	Arrays.fill(d, -1);
        }
        return solve(0, n - 1) > 0 ? true : false;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkValidString(")("));
    }
}