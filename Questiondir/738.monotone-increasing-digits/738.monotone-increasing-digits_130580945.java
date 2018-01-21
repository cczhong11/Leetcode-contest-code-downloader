class Solution {
    public int monotoneIncreasingDigits(int N) {
        String s = N + "";
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                String t = s.substring(0, i) + (char)(s.charAt(i) - 1);
                for (int k = i + 1; k < s.length(); k++)
                    t += "9";
                return monotoneIncreasingDigits(Integer.valueOf(t));
            }
        }
        return N;
    }
}