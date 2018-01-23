public class Solution {
 public String findContestMatch(int n) {
        List<String> currentRound = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            currentRound.add(Integer.toString(i));
        }
        while (true) {
            int len = currentRound.size();
            if (len == 1) {
                break;
            }
            List<String> newRound = new ArrayList<String>();
            for (int i = 1; i <= len / 2; i++) {
                newRound.add("(" + currentRound.get(i - 1) + "," + currentRound.get(len - i) + ")");
            }
            currentRound = newRound;
        }
        return currentRound.get(0);
    }
}