class Solution {
    public int pathSum(int[] nums) {
        int[][] node = new int[5][9];
        int total = 0;
        for (int num : nums) {
            node[num / 100][(num / 10) % 10] = num % 10 + node[num / 100 - 1][(((num / 10) % 10) + 1)/2];
        }
        int maxj = 1;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= maxj; j++) {
                if (i == 4 || (node[i+1][2 * j - 1] == 0 && node[i+1][2 * j] == 0)) total += node[i][j];
            }
            maxj *= 2;
        }
        return total;
    }
}