public class Solution {
    private final int MOD = 1000000007;
    public String addBoldTag(String s, String[] dict) {
        boolean[] label = new boolean[s.length()];
        for (int i = 0; i < dict.length; i++) {
            labelString(s, label, dict[i]);
        }
        return getOutput(s, label);
    }
    private  String getOutput(String s, boolean[] label) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (label[i] && (i == 0 || !label[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (label[i] && (i == s.length() - 1 || !label[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
    private void labelString(String s, boolean[] label, String ss) {
        if (ss.length() > s.length()) return;
        int v1 = calcHash(ss, ss.length());
        int v2 = calcHash(s, ss.length());
        int idx = 0;
        boolean[] lab = new boolean[s.length()];
        int magicNum = pow(31, ss.length() - 1, MOD);
        do {
            if (v2 == v1 && isMatch(s, idx, ss)) {
                for (int i = idx + ss.length() - 1; i >= idx; i--) {
                    if (lab[i]) break;
                    lab[i] = true;
                }
            }
            if (idx + ss.length() < s.length()) {
                v2 = nextHash(s.charAt(idx), s.charAt(idx + ss.length()), magicNum, v2);
            }
            else {
                break;
            }
            idx ++;
        }while (true);
        for (int i = 0; i < label.length; i++) label[i] |= lab[i];
    }

    private int nextHash(char first, char next, int magic, int curr) {
        curr = (int)((curr + MOD - (magic * 1L * first) % MOD) % MOD);
        curr = (int)((curr * 31L + next) % MOD);
        return curr;
    }

    private int pow(int a, int b, int c) {
        long ans = 1;
        while (b != 0) {
            if (b % 2 == 1) {
                ans = (ans * a) % c;
            }
            b /= 2;
            a = (int)((a * 1L * a) % c);
        }
        return (int)ans;
    }
    private boolean isMatch(String s, int idx, String t) {
        if (idx + t.length() > s.length()) return false;
        for (int i = idx; i < idx + t.length(); i++) {
            if(s.charAt(i) != t.charAt(i - idx)) return false;
        }
        return true;
    }

    private int calcHash(String s, int len) {
        long v = 0;
        for (int i = 0; i < len; i++) {
            v = v * 31 + s.charAt(i);
            v %= 1000000007;
        }
        return (int)v;
    }
}