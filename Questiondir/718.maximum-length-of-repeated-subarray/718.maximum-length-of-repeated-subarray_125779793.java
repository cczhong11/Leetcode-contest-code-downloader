class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] longestStartingAt = new int[A.length+1][B.length+1];
        
        int longest = 0;
        for (int i = A.length-1; i >= 0; i--) {
            for (int j = B.length-1; j >= 0; j--) {
                if (A[i] != B[j]) continue;
                longestStartingAt[i][j] = 1 + longestStartingAt[i+1][j+1];
                longest = Math.max(longestStartingAt[i][j], longest);
            }
        }
        
        return longest;
    }
}