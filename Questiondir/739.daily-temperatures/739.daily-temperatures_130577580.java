class Solution {
    public int[] dailyTemperatures(int[] t) {
        int[] r = new int[t.length];
        int back = 0;
        for (int i = 0; i < t.length; i++) {
            for (int j = i + 1; j < t.length; j++)
                if (t[i] < t[j]) {
                    r[i] = j - i;
                    break;
                }
        }
        return r;
    }
}