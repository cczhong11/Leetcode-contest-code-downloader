public class Solution {
    public int maxA(int N) {
        if (N < 3) return N;
        int[] maxA = new int[N+1];
        maxA[0] = 0;
        maxA[1] = 1;
        maxA[2] = 2;
        for (int i = 3; i <= N; i++) {
            maxA[i] = maxA[i-1] + 1;
            for (int j = 0; j <= i-3; j++) {
                maxA[i] = Math.max(maxA[i], maxA[j] * (i - j - 1));
            }
        }
        return maxA[N];
    }
}