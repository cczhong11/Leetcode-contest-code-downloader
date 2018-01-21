public class Solution { // greedy, get rid of first enemy after itself
    public String predictPartyVictory(String senate) {
        char[] str = senate.toCharArray();
        int idx = 0;
        char p = str[idx];
        int len = str.length;
        int remain = len;
        while (true) {
            while (str[idx] == '0') {
                if (++idx == len) {
                    idx = 0;
                }
            }
            p = str[idx];
            int i = (idx + 1) % len;
            while (i != idx) {
                if (str[i] == '0' || str[i] == p) {
                    i++;
                } else { // get rid of enemy
                    str[i] = '0';
                    break;
                }
                if (i == len) {
                    i = 0;
                }
            }
            if (i == idx) {
                return p == 'R' ? "Radiant" : "Dire";
            } else {
                idx = (idx + 1) % len;
            }
        }
    }
}