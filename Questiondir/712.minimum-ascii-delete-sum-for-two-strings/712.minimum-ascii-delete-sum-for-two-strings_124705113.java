public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] table = new int[s1.length() + 1][s2.length() + 1];
        //init
        for (int i = 1; i < s1.length() + 1; i++)
            table[i][0] = table[i - 1][0] + s1.charAt(i - 1);

        for (int i = 1; i < s2.length() + 1; i++)
            table[0][i] = table[0][i - 1] + s2.charAt(i - 1);

        //dp
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) table[i][j] = table[i - 1][j - 1];
                else table[i][j] = Math.min(table[i - 1][j] + s1.charAt(i - 1), table[i][j - 1] + s2.charAt(j - 1));
            }
        }
        return table[s1.length()][s2.length()];
    }
}
