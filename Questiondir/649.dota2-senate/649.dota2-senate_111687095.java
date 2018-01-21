public class Solution {
    public String predictPartyVictory(String senate) {
        int numD = 0;
        int numS = 0;
        for (int i = 0; i < senate.length(); ++i) {
            if (senate.charAt(i) == 'D') numD++;
            else numS++;
        }
        char[] A = senate.toCharArray();
        int state = 0;
        for (int i = 0; numS > 0 && numD > 0; i = (i + 1) % A.length) {
            if (A[i] == 'X') continue;
            if (A[i] == 'D') {
                if (state < 0) {
                    A[i] = 'X';
                    numD--;
                }
                state++;
            }
            if (A[i] == 'R') {
                if (state > 0) {
                    A[i] = 'X';
                    numS--;
                }
                state--;
            }
        }
        if (numS > 0) return "Radiant";
        else return "Dire";
    }
}