class Solution {
    public int strangePrinter(String s) {
        String str = preprocess(s);
        int n = str.length();
        System.out.println(str);
        int[][] memo = new int[n][n];
        
        return helper(str, 0, n - 1, memo);
    }
    
    int helper(String str, int i, int j, int[][] memo) {
        //System.out.println(i + ", " + j);
        if (i > j) return 0;
        if (i == j) return 1;
        if (memo[i][j] != 0) return memo[i][j];
        char c = str.charAt(i);
        int res = j - i + 1;
        int end = str.indexOf(c, i + 1);
        //System.out.println("end: " + end);
        while (end != -1) {
            res = Math.min(res, helper(str, i + 1, end - 1, memo) + helper(str, end, j, memo));
            //res = Math.min(res, helper(str, i + 1, end - 1, memo) + 1 + helper(str, end + 1, j, memo));
            end = str.indexOf(c, end + 1);
        }
        res = Math.min(res, helper(str, i + 1, j, memo) + 1);
        // for (int k = i + 1; k < end; k++) {
        //     res = Math.min(res, helper(str, i, k - 1, memo) + helper(str, k, j, memo));
        // }
        
        memo[i][j] = res;
        return res;
    }
    
    String preprocess(String s) {
        StringBuilder res = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (res.length() == 0 || res.charAt(res.length() - 1) != c) {
                res.append(c);
            }
        }
        
        return res.toString();
    }
}