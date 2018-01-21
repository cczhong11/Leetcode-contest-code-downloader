class Solution {
    public int countBinarySubstrings(String s) {
        int total = 0;
        int len = s.length();
        int[] zero = new int[len + 1];
        int[] one = new int[len + 1];
        int idx = 1;
        for (char c: s.toCharArray()) {
            if (c == '0') {
                zero[idx] = zero[idx - 1] + 1;
                if (one[idx - zero[idx]] >= zero[idx]) {
                    total++;
                }
            } else {
                one[idx] = one[idx - 1] + 1;
                if (zero[idx - one[idx]] >= one[idx]) {
                    total++;
                }
            }
            idx++;
        }
        return total;
    }
}