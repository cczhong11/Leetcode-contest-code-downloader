class Solution {
    public int flipLights(int n, int m) {
        final int B = Math.min(6, n);
        final int T = (1 << B);
        boolean[] dp = new boolean[T];
        dp[0] = true;
        for (int i = 0; i < m; ++i) {
            boolean[] next = new boolean[T];
            for (int j = 0; j < T; ++j) {
                if (dp[j]) {
                    next[op1(j, B)] = true;
                    next[op2(j, B)] = true;
                    next[op3(j, B)] = true;
                    next[op4(j, B)] = true;
                }
            }
            dp = next;
        }
        
        int cnt = 0;
        for (boolean b : dp) {
            if (b) {
                ++cnt;
            }
        }
        return cnt;
    }
    
    private int flip(int num, int bit) {
        return num ^ (1 << bit);
    }
    
    private int op1(int num, int B) {
        for (int i = 0; i < B; ++i) {
            num = flip(num, i);
        }
        return num;
    }
    
    private int op2(int num, int B) {
        for (int i = 1; i < B; i += 2) {
            num = flip(num, i);
        }
        return num;
    }
    
    private int op3(int num, int B) {
        for (int i = 0; i < B; i += 2) {
            num = flip(num, i);
        }
        return num;
    }
    
    private int op4(int num, int B) {
        for (int i = 0; i < B; i += 3) {
            num = flip(num, i);
        }
        return num;
    }
}