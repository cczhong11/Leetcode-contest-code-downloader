public class Solution {
    class Path {
        int value;
        List<String> path;
        Path(int i) {
            value = i;
            path = new ArrayList<>();
        }
    }
    public List<Integer> cheapestJump(int[] A, int B) {
        Path[] dp = new Path[A.length];
        dp[0] = new Path(0);
        dp[0].path.add("1");
        for (int i = 1; i < A.length; i++) {
            dp[i] = new Path(-1);
            if (A[i] == -1) {
                continue;
            }
            for (int j = i - 1; j >= 0 && j >= i - B; j--) {
                if (dp[j].value != -1 && (dp[i].value == -1 || dp[j].value + A[i] < dp[i].value ||
                                          dp[j].value + A[i] == dp[i].value && comparePath(dp[j].path, dp[i].path) < 0)) {
                    dp[i].value = dp[j].value + A[i];
                    dp[i].path = new ArrayList<>(dp[j].path);
                }
            }
            if (dp[i].value != -1) {
                dp[i].path.add(i + 1 + "");
            }
        }
        List<Integer> res = new ArrayList<>();
        if (dp[A.length - 1].value == -1) return res;
        for (String s : dp[A.length - 1].path) res.add(Integer.parseInt(s));
        return res;
    }
    int comparePath(List<String> a, List<String> b) {
        int i = 0;
        while (i < a.size() && i < b.size()) {
            int r = Integer.parseInt(a.get(i)) - Integer.parseInt((b.get(i)));
            if (r != 0) return r;
            i++;
        }
        return -a.size() + b.size();
    }
}