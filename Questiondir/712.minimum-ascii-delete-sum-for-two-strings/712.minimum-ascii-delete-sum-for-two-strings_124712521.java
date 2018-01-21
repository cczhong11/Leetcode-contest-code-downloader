class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] minSum = new int[s1.length()+1][s2.length()+1];
        minSum[0][0] = 0;
        for (int row = 1; row <= s1.length(); row++) {
            minSum[row][0] = minSum[row-1][0] + s1.charAt(row-1);
        }
        for (int col = 1; col <= s2.length(); col++) {
            minSum[0][col] = minSum[0][col-1] + s2.charAt(col-1);
        }
        for (int row = 1; row <= s1.length(); row++) {
            for (int col = 1; col <= s2.length(); col++) {
                if (s1.charAt(row-1) == s2.charAt(col-1)) minSum[row][col] = minSum[row-1][col-1];
                else minSum[row][col] = Math.min(minSum[row-1][col] + s1.charAt(row-1), minSum[row][col-1] + s2.charAt(col-1));
            }
        }
        return minSum[s1.length()][s2.length()];
    }
}