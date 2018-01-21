class Solution {
    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        int start = 0;
        boolean toAct = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                toAct = true;
                break;
            } else if (s.charAt(i) > s.charAt(i - 1)) {
                start = i;
            }
        }
        if (!toAct) return N;
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(start, (char)(sb.charAt(start) - 1));
        for (int i = start + 1; i < sb.length(); i++)
            sb.setCharAt(i, '9');
        return Integer.valueOf(sb.toString());
    }
}