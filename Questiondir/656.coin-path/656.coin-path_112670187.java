public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int len = A.length;
        if (A[len - 1] < 0) return new ArrayList<>();
        
        int dp[] = new int[len];
        dp[len - 1] = A[len - 1];
        for (int i = 0; i < len - 1; i++) {
            dp[i] = -1;
        }

        for (int i = len - 1; i > 0; i--) {
            if (dp[i] == -1) continue;

            for (int j = 1; j <= B; j++) {
                int pre = i - j;
                if (pre < 0 || A[pre] < 0) continue;

                int newVal = dp[i] + A[pre];
                if (dp[pre] == -1 || newVal < dp[pre]) {
                    dp[pre] = newVal;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        if (dp[0] < 0) {
            return res;
        }

        int idx = 0;
        while (idx < len) {
            res.add(idx + 1);

            if (idx == len - 1) break;

            for (int b = 1; b <= B; b++) {
                int next  = idx + b;
                if (next < len && dp[next] >= 0 && dp[next] + A[idx] == dp[idx]) {
                    idx = next;
                    break;
                }
            }
        }

        return res;
    }
}