import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	int[][] dp;
	String s;
	
	int calc(ArrayList<Integer> pos) {
		int n = pos.size() / 2;
		if (n == 0) return 0;
		//System.out.println(pos.size());
		int[][] minV = new int[n][n + 1];
		for (int[] d : minV) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		for (int i = 0; i < n; ++i) minV[i][1] = solve(pos.get(i * 2), pos.get(i * 2 + 1));
		for (int len = 2; len <= n; ++len) {
		    for (int i = 0; i < n; ++i) {
				if (i + len > n) continue;
				minV[i][len] = solve(pos.get(i * 2), pos.get((i + len - 1) * 2 + 1));
				for (int l = 1; l < len; ++l) {
					minV[i][len] = Math.min(minV[i][len], minV[i][l] + minV[i + l][len - l]);
				}
			}
		}
		//System.out.println(minV[0][n]);
		return minV[0][n];
	}
	
	int solve(int st, int ed) {
		if (st > ed) return 0;
		if (st == ed) return 1;
		if (dp[st][ed] >= 0) return dp[st][ed];
		
		int res = ed - st + 1;
		for (int i = st; i < ed; ++i) {
			res = Math.min(res, solve(st, i) + solve(i + 1, ed));
		}
		
		ArrayList<Integer> pos = new ArrayList<>();
		char ch = s.charAt(st);
		int index = st + 1;
		int tmp = 1;
		while (index <= ed) {
			while (index <= ed && s.charAt(index) == ch) ++index;
			if (index > ed) break;
			pos.add(index);
			int next = index;
			while (next <= ed && s.charAt(next) != ch) ++next;
			pos.add(next - 1);
			index = next;
		}
		
		tmp += calc(pos);
		res = Math.min(res, tmp);
		
		dp[st][ed] = res;
		return res;
	}
	
    public int strangePrinter(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int[] d : dp) {
        	Arrays.fill(d, -1);
        }
        this.s = s;
        return solve(0, n - 1);
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.strangePrinter("qrfzkqyrvhunkyq"));
    	System.out.println(s.strangePrinter("abcdefabcdefffffffffffffedcbafedcba"));
    }
}