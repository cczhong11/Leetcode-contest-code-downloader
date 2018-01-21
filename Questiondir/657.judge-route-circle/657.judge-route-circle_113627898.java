public class Solution {
    public boolean judgeCircle(String moves) {
        int[] pos = new int[2];
        for (char c: moves.toCharArray()) {
            helper(c, pos);
        }
        
        return pos[0] == 0 && pos[1] == 0;
    }
    
    void helper(char c, int[] pos) {
        if (c == 'U') {
            pos[0]--;
        } else if (c == 'D') {
            pos[0]++;
        } else if (c == 'L') {
            pos[1]--;
        } else if (c == 'R') {
            pos[1]++;
        }
    }
}